package com.proyecto.restaurant_reservation.dto.response;

import com.proyecto.restaurant_reservation.domain.enums.Role;
import lombok.Data;
/*
 *-------------------------------
 * UserProfileResponseDTO
 * -------------------------------
 * Esta clase representa los detalles del perfil de un usuario.
 * Es utilizada para devolver la información relevante del usuario
 * después de un inicio de sesión exitoso.
 */

@Data
public class UserProfileResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
}
