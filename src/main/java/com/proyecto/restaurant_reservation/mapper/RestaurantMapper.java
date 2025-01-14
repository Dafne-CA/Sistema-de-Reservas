package com.proyecto.restaurant_reservation.mapper;

import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import com.proyecto.restaurant_reservation.dto.response.RestaurantResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RestaurantMapper {

    private final ModelMapper modelMapper;

    public RestaurantResponseDTO toResponseDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantResponseDTO.class);
    }

}