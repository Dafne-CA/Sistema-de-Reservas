package com.proyecto.restaurant_reservation.controller;

import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import com.proyecto.restaurant_reservation.dto.response.RestaurantResponseDTO;
import com.proyecto.restaurant_reservation.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    //Recupera una lista paginada de todos los restaurantes.
    @GetMapping("/page")
    public ResponseEntity<Page<RestaurantResponseDTO>> getAllRestaurants(
            @PageableDefault(size = 5) Pageable pageable){
        Page<RestaurantResponseDTO> restaurants = restaurantService.getAllRestaurants(pageable);
        return ResponseEntity.ok(restaurants);
    }

    //Busca restaurantes por distrito, devolviendo una lista paginada.
    @GetMapping("/page/district")
    public ResponseEntity<Page<RestaurantResponseDTO>> findByDistrictName(
            @RequestParam String districtName,
            @PageableDefault(sort = "name", size = 5) Pageable pageable){
        Page<RestaurantResponseDTO> restaurants = restaurantService.findByDistrictName(districtName, pageable);
        return ResponseEntity.ok(restaurants);
    }

    //Busca un restaurante específico por su ID
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> getRestaurantById(@PathVariable Long id){
        RestaurantResponseDTO restaurant = restaurantService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }
}
