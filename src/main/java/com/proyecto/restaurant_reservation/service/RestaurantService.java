package com.proyecto.restaurant_reservation.service;

import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import com.proyecto.restaurant_reservation.dto.response.RestaurantResponseDTO;
import com.proyecto.restaurant_reservation.exception.ResourceNotFoundException;
import com.proyecto.restaurant_reservation.mapper.RestaurantMapper;
import com.proyecto.restaurant_reservation.repository.RestaurantRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;
    /**
     * Lista todos los restaurantes de forma paginada.
     *
     * -@param pageable Objeto que define:
     *                 - Número de página.
     *                 - Tamaño de página (cuántos registros por página).
     *                 - Orden (ascendente o descendente).
     * -@return Un objeto Page<RestaurantResponseDTO>, que contiene una lista de restaurantes
     *         ya convertidos en DTOs (solo la información necesaria para el cliente).
     */

    @Transactional( readOnly = true)
    public Page<RestaurantResponseDTO> getAllRestaurants(Pageable pageable) {
        // Llama al repositorio para buscar restaurantes en la base de datos
        Page<Restaurant> restaurants = restaurantRepository.findAll(pageable);
        // Convierte cada Restaurant en un DTO y devuelve la página transformada.
        return restaurants.map(restaurantMapper::toResponseDTO);
    }

    //Lista los restaurantes filtrados por el nombre del distrito.
    @Transactional( readOnly = true)
    public Page<RestaurantResponseDTO> getRestaurantsByDistrictName(Pageable pageable, String districtName) {
        Page<Restaurant> restaurants=restaurantRepository.findByDistrictName(districtName, pageable);
        return restaurants.map(restaurantMapper::toResponseDTO);
    }

    //Obtiene los detalles de un restaurante específico por su ID.
    public RestaurantResponseDTO getRestaurantById(Long id) {
        // 1. Busca el restaurante por ID. Si no existe, lanza una excepción personalizada.
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id: "+id));
        // 2. Convierte el restaurante encontrado en un DTO y lo devuelve.
        return restaurantMapper.toResponseDTO(restaurant);
    }

}

