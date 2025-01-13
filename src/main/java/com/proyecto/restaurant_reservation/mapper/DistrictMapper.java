package com.proyecto.restaurant_reservation.mapper;

import com.proyecto.restaurant_reservation.domain.entity.District;
import com.proyecto.restaurant_reservation.dto.response.DistrictResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class DistrictMapper {

    private final ModelMapper modelMapper;

    /**
     * Convierte una entidad District a un objeto DistrictResponseDTO.
     * Se utiliza ModelMapper para automatizar la copia de atributos entre las dos clases,
     * reduciendo código repetitivo.
     */
    public DistrictResponseDTO toResponseDTO(District district) {
        return modelMapper.map(district, DistrictResponseDTO.class);
    }
}
