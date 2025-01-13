package com.proyecto.restaurant_reservation.mapper;

import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import com.proyecto.restaurant_reservation.dto.response.RestaurantResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    //Convierte una entidad a un DTO.
    RestaurantResponseDTO toResponseDTO(Restaurant restaurant);

    // Mapea una lista de entidades Restaurant a una lista de RestaurantResponseDTO
    List<RestaurantResponseDTO> toResponseDtoList(List<Restaurant> restaurants);

    // Conversión de DTO a entidad.
    Restaurant toEntity(RestaurantResponseDTO dto);
}
