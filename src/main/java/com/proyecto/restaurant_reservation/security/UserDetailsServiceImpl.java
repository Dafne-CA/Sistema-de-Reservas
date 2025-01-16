package com.proyecto.restaurant_reservation.security;

import com.proyecto.restaurant_reservation.domain.entity.User;
import com.proyecto.restaurant_reservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/*
 * -------------------------------
 * UserDetailsServiceImpl
 * -------------------------------
 * Propósito:
 * - Implementar la lógica para cargar los detalles de un usuario desde la base de datos.
 * - Adaptar la entidad `User` de la aplicación al formato que Spring Security necesita para autenticación.
 * -------------------------------
 * Componentes principales:
 * - UserRepository: Accede a la base de datos para buscar usuarios.
 * - UserDetailsService: Interface de Spring Security para cargar usuarios por su nombre de usuario.
 * -------------------------------
 * ¿Qué hace el metodo principal?
 * - loadUserByUsername:
 *   1. Busca al usuario por su correo (username).
 *   2. Convierte la entidad `User` de la aplicación en un objeto `UserDetails` de Spring Security.
 *   3. Devuelve los detalles necesarios para la autenticación.
 * -------------------------------
 */
@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Buscar al usuario por su correo en la base de datos.
        User user = userRepository.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        // Construir un objeto UserDetails usando los datos del usuario encontrado.
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }
}
