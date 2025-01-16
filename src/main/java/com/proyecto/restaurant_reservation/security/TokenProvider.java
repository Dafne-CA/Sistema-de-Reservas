package com.proyecto.restaurant_reservation.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/*
 * /*
 * Esta clase se encarga de generar, validar y extraer la información de los tokens JWT.
 * Los tokens JWT son utilizados para autenticar y autorizar a los usuarios de manera segura.
 * Los métodos clave incluyen la creación de tokens, la verificación de tokens existentes y la obtención de la información de usuario de los tokens.
 */
@Component
public class TokenProvider {

    // Inyecta el valor del secreto JWT desde la configuración.
    @Value("${jwt.secret}")
    private String jwtSecret;

    // Inyecta el tiempo de validez del token JWT en segundos.
    @Value("${jwt.validity-in-seconds}")
    private long jwtValidityInSeconds;

    // Almacena la clave generada a partir del secreto JWT.
    private Key key;

    // Se utiliza para analizar y verificar tokens JWT.
    private JwtParser jwtParser;

    /*
     * -------------------------------
     * Inicialización
     * -------------------------------
     */

    // Inicializa la clave y el parser JWT con la clave secreta.
    // La clave se deriva del secreto configurado y se utiliza para firmar y verificar los tokens JWT.
    @PostConstruct
    public void init() {
        // Decodifica la clave secreta en formato Base64 y la convierte en una clave HMAC.
        key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        jwtParser = Jwts
                .parserBuilder()
                .setSigningKey(key)
                .build();
    }

    /*
     * -------------------------------
     * Generación de un Token JWT
     * -------------------------------
     * Este metodo crea un token JWT para un usuario autenticado. Al autenticar a un usuario,
     * el TokenProvider crea un token JWT que incluye información sobre el usuario, como su nombre y rol.
     * Este token se utiliza para identificar y autenticar al usuario en solicitudes futuras sin necesidad
     * de que el usuario inicie sesión nuevamente.
     *
     * El token contiene:
     * 1. El nombre de usuario (subject).
     * 2. El rol del usuario.
     * 3. La firma HMAC usando la clave secreta.
     * 4. Fecha de expiración.
     */

    public String createAccessToken(Authentication authentication) {
        // Obtiene el rol del usuario autenticado.
        String role = authentication
                .getAuthorities()
                .stream()
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getAuthority();

        // Construye el token JWT.
        return Jwts
                .builder()
                .setSubject(authentication.getName())
                .claim("role", role)
                .signWith(key, SignatureAlgorithm.HS512)
                .setExpiration(new Date(System.currentTimeMillis() + jwtValidityInSeconds * 1000))
                .compact();
    }
    /*
     * -----------------------------------------------
     * Obtener la Autenticación a partir del Token JWT
     * -----------------------------------------------
     * Este metodo extrae la información del token JWT (usuario y rol) y la convierte en un objeto Authentication.
     * Este objeto Authentication se usa en Spring Security para verificar los permisos del usuario.
     */

    public Authentication getAuthentication(String token) {
        // Analiza el token JWT y obtiene las "claims" (información) del mismo.
        Claims claims = jwtParser.parseClaimsJws(token).getBody();

        String role = claims.get("role").toString();
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(role));

        User principal = new User(claims.getSubject(), "", authorities);
        return new UsernamePasswordAuthenticationToken(principal, token, authorities);
    }

    /*
     * -------------------------------
     * Validación del Token JWT
     * -------------------------------
     * Este metodo verifica la validez de un token JWT. Comprueba si el token no ha sido alterado,
     * si tiene una firma válida y si aún está dentro de su período de validez.
     * Si el token no es válido, lanza una excepción.
     */
    public boolean validateToken(String token) {
        try {
            jwtParser.parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
