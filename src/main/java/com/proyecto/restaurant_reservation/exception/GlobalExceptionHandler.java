package com.proyecto.restaurant_reservation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    /*
     * -------------------------------
     * GLOBAL EXCEPTION HANDLER
     * -------------------------------
     * 1. Maneja errores de toda la aplicación.
     * 2. Devuelve respuestas personalizadas según el tipo de error.
     * 3. Ejemplo:
     *    - Si buscas un recurso inexistente -> 404 (Recurso no encontrado).
     *    - Si envías datos inválidos -> 400 (Solicitud inválida).
     *    - Si algo falla inesperadamente -> 500 (Error interno del servidor).
     * -------------------------------
     * ¿Qué hace cada metodo?
     * - handleResourceNotFoundException: Responde cuando no encuentras un recurso.
     * - handleBadRequestException: Responde cuando envías algo mal al servidor.
     * - handleException: Responde a cualquier error no manejado.
     * -------------------------------
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
        // Se usa el constructor de ErrorDetails con tres parámetros
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetails> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
