package com.proyecto.restaurant_reservation.mapper;

import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import com.proyecto.restaurant_reservation.dto.response.RestaurantResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    //Convierte una entidad a un DTO.
    RestaurantResponseDTO toResponseDTO(Restaurant restaurant);

    // Conversión de DTO a entidad.
    Restaurant toEntity(RestaurantResponseDTO dto);
}
