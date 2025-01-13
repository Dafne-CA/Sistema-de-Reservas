package com.proyecto.restaurant_reservation.mapper;
import com.proyecto.restaurant_reservation.domain.entity.District;
import com.proyecto.restaurant_reservation.domain.entity.Restaurant;
import com.proyecto.restaurant_reservation.dto.response.DistrictResponseDTO;
import com.proyecto.restaurant_reservation.dto.response.RestaurantResponseDTO;
import org.mapstruct.Mapper;

// MapStruct genera automáticamente el código de mapeo y lo convierte en un componente Spring.
@Mapper(componentModel = "spring")
public interface DistrictMapper {

    /*
     * Convierte una entidad District a un DTO DistrictResponseDTO.
     * Se encarga de la conversión automáticamente al compilar, sin necesidad de escribir código repetitivo.
     * El componente Spring asegura que este mapeador esté disponible en toda la aplicación.
     */

    // Conversión de entidad a DTO
    DistrictResponseDTO toResponseDTO(District district);

    // Conversión de DTO a entidad
    District toEntity(DistrictResponseDTO dto);
}
