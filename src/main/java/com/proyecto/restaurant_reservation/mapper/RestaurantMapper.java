package com.proyecto.restaurant_reservation.mapper;

import com.proyecto.restaurant_reservation.domain.entity.District;
import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import com.proyecto.restaurant_reservation.dto.response.DistrictResponseDTO;
import com.proyecto.restaurant_reservation.dto.response.RestaurantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RestaurantMapper {
    private final ModelMapper modelMapper;

    /**
     * Convierte una entidad Restaurant a un objeto RestaurantResponseDTO.
     * Se utiliza ModelMapper para automatizar la copia de atributos entre las dos clases,
     * reduciendo código repetitivo.
     */
    public RestaurantResponseDTO toResponseDTO(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantResponseDTO.class);
    }
}
