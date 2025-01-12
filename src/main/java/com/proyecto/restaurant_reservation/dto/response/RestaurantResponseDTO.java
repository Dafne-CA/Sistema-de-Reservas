package com.proyecto.restaurant_reservation.dto.response;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RestaurantResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String districtName;
    private double pricePerPerson;
    private int capacity;
}
