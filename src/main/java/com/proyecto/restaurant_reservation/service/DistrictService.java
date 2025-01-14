package com.proyecto.restaurant_reservation.service;

import com.proyecto.restaurant_reservation.domain.entity.District;
import com.proyecto.restaurant_reservation.dto.response.DistrictResponseDTO;
import com.proyecto.restaurant_reservation.mapper.DistrictMapper;
import com.proyecto.restaurant_reservation.repository.DistrictRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DistrictService {
    /*
     * -------------------------------
     * DistrictService
     * -------------------------------
     * Propósito:
     * - Manejar la lógica relacionada con los distritos.
     * - Recuperar datos de la base de datos y transformarlos en DTOs para enviar al cliente.
     * -------------------------------
     * ¿Qué hace cada componente?
     * - DistrictRepository: Accede directamente a la base de datos.
     * - DistrictMapper: Convierte entidades District a DTOs (DistrictResponseDTO).
     * -------------------------------
     */

    private final DistrictRepository districtRepository;
    private final DistrictMapper districtMapper;

    /*
     * Metodo: getAllDistricts
     * - Recuperar todos los distritos de la base de datos.
     * - Convertirlos en una lista de objetos DistrictResponseDTO.
     * Proceso:
     * 1. Obtener la lista de entidades District desde el repositorio.
     * 2. Transformar las entidades en DTOs con el mapper.
     * 3. Devolver la lista de DTOs al controlador para enviarlos como respuesta al cliente.
     */

    // La anotación asegura que esta operación sea de solo lectura
    @Transactional(readOnly= true)
    public List<DistrictResponseDTO> getAllDistricts() {
        // 1. Obtiene todos los distritos desde el repositorio.
        List<District> districts = districtRepository.findAll();
        // 2. Convierte la lista de entidades District en una lista de DTOs.
        return districtMapper.toResponseDtoList(districts);
    }

}
