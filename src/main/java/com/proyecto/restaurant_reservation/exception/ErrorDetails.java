package com.proyecto.restaurant_reservation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class ErrorDetails {
    /**
     * Clase que encapsula los detalles de un error en la aplicación.
     *
     * Se utiliza para proporcionar información estructurada sobre un error
     * al cliente, generalmente en APIs RESTful.
     *
     * Incluye:
     * - La fecha y hora en que ocurrió el error.
     * - Un mensaje descriptivo sobre el error.
     * - Detalles adicionales relacionados con el error.
     */

    private LocalDateTime timestamp;
    private String message;
    private String details;
}