package com.proyecto.restaurant_reservation.repository;

import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    /* JPQL = Java Persistence Query Language
    Consulta personalizada para buscar restaurantes por el nombre del distrito
    Usamos "Page" para obtener solo una página de resultados, no todos de golpe
    Devuelve una página de restaurantes según el nombre del distrito*/

    @Query("SELECT r FROM Restaurant r WHERE r.district.name = :districtName")
    Page<Restaurant> findByDistrictName(@Param("districtName") String districtName, Pageable pageable);
}

