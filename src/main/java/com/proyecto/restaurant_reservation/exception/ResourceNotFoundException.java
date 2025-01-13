package com.proyecto.restaurant_reservation.exception;

public class ResourceNotFoundException extends RuntimeException {
    /*
    * cuando estoy tratando de buscar un recursoy no lo encuentro
    * */

    public ResourceNotFoundException() {
        super();
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
