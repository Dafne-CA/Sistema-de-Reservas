package com.proyecto.restaurant_reservation.exception;

public class BadRequestException extends RuntimeException {
    /* Consturctor sin parametro
    * Se utiliza cuando no se desea especificar un mensaje,
    * y el sistema utilizará el mensaje predeterminado "Bad Request"*/

    public BadRequestException() {
        super("Bad Request");
    }

    /*Constructor con parámetro: aquí podemos pasar un mensaje personalizado
    del error*/
    public BadRequestException(String message) {
        super(message);
    }
}
