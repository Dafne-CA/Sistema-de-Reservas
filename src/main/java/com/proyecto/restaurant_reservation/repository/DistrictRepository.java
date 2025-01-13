package com.proyecto.restaurant_reservation.repository;

import com.proyecto.restaurant_reservation.domain.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {
    /**
     * Busca un distrito por su nombre
     * @param name Nombre del distrito a buscar.
     * @return Un Optional que puede contener el distrito si se encuentra, o estar vacío si no se encuentra.

     * Uso de Optional:Esto ayuda a manejar de manera segura el caso en el que no se encuentra un distrito con el nombre dado,
     * evitando posibles NullPointerExceptions. Si el distrito no se encuentra, Optional está vacío.

     * Si el buscador findByName no encuentra el distrito que están buscando, no te da un error.
     * En vez de eso, te devuelve algo llamado Optional.empty(), que significa "no encontré nada"
     */
    Optional<District> findByName(String name);
}
