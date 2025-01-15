package com.proyecto.restaurant_reservation.mapper;

import com.proyecto.restaurant_reservation.domain.entity.User;
import com.proyecto.restaurant_reservation.dto.request.SignupRequestDTO;
import com.proyecto.restaurant_reservation.dto.response.AuthResponseDTO;
import com.proyecto.restaurant_reservation.dto.response.UserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

/*
 * -------------------------------
 * UserMapper
 * -------------------------------
 * ¿Qué hace cada metodo?
 * - toUser: Convierte datos de registro (SignupRequestDTO) en una entidad User.
 * - toUserProfileResponseDTO: Convierte un User en un DTO de perfil básico (UserProfileResponseDTO).
 * - toAuthResponseDTO: Crea un DTO de respuesta de autenticación (AuthResponseDTO) con token y perfil.
 * -------------------------------
 * Componentes principales:
 * - ModelMapper: Realiza el mapeo automático de propiedades entre objetos.
 * -------------------------------
 */

@RequiredArgsConstructor
@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public User toUser(SignupRequestDTO signupRequestDTO) {
        return modelMapper.map(signupRequestDTO, User.class);
    }

    public UserProfileResponseDTO toUserProfileResponseDTO(User user) {
        return modelMapper.map(user, UserProfileResponseDTO.class);
    }

    public AuthResponseDTO toAuthResponseDTO(String token, UserProfileResponseDTO userProfile) {
        AuthResponseDTO authResponseDTO = new AuthResponseDTO();
        authResponseDTO.setToken(token);
        authResponseDTO.setUser(userProfile);
        return authResponseDTO;
    }
}
