package com.proyecto.restaurant_reservation.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignupRequestDTO {
    /*
     *-------------------------------
     * SignupRequestDTO
     * -------------------------------
     * Este dto se utiliza para representar los datos que un usuario envía
     * al registrarse en el sistema. Incluye campos para el nombre, apellido,
     * correo electrónico y contraseña, y contiene validaciones para asegurar
     * que los datos sean correctos antes de ser procesados.
     */
    @NotBlank
    private String firstName;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotNull(message = "Password is mandatory")
    @Size(min = 4)
    private String password;
}
