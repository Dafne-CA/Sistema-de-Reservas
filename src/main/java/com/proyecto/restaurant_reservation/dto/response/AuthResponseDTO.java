package com.proyecto.restaurant_reservation.dto.response;

import lombok.Data;
/*
 *-------------------------------
 * AuthResponseDTO
 * -------------------------------
 * Esta clase representa la respuesta del backend al frontend
 * cuando el usuario inicia sesión exitosamente. Incluye dos campos:
 * 1. Un token que se usará para autenticar futuras solicitudes.
 * 2. Un objeto con la información del perfil del usuario.
 */

@Data
public class AuthResponseDTO {

    private String token;
    private UserProfileResponseDTO user;
}
