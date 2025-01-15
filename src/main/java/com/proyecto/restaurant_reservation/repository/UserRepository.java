package com.proyecto.restaurant_reservation.repository;

import com.proyecto.restaurant_reservation.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/*
 * -------------------------------
 * UserRepository
 * -------------------------------
 * ¿Qué hace cada metodo?
 *
 * - findOneByEmail: Busca un usuario en la base de datos utilizando su correo electrónico.
 *   Un Optional que contiene el usuario si se encuentra, o vacío si no.
 *
 * - existsByEmail: Verifica si ya existe un usuario registrado con un correo específico.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByEmail(String email);
    boolean existsByEmail(String email);
}
