package com.luiDan.aviones.backend.business.services;

import java.util.List;
import java.util.Optional;

import com.luiDan.aviones.backend.business.model.Avion;

public interface AvionServices {
    Long create(Avion avion); // C

    Optional<Avion> read(Long id); // R

    void update(Avion avion); // U

    void delete(Long id); // D

    List<Avion> getAll(); // Obtener todos
}