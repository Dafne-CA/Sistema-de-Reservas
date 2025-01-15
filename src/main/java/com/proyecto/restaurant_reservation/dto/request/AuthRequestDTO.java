package com.proyecto.restaurant_reservation.dto.request;

import lombok.Data;
/**
 * 📄 **AuthRequestDTO**
 *
 * 👉 **Descripción:**
 * - DTO utilizado para enviar las credenciales del usuario en solicitudes de inicio de sesión.
 * - Contiene solo los campos necesarios para la autenticación.
 *
 * 🛠️ **Incluye:**
 * - `email`: Correo del usuario.
 * - `password`: Contraseña del usuario.
*/
@Data
public class AuthRequestDTO {

    private String email;
    private String password;
}
