package com.luiDan.aviones.backend.business.services.impl;

import com.luiDan.aviones.backend.business.model.Avion;
import com.luiDan.aviones.backend.business.services.AvionServices;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class AvionServicesImpl implements AvionServices {
    private final Map<Long, Avion> avionMap = new TreeMap<>();

    // Constructor que inicializa datos para las pruebas
    public AvionServicesImpl() {
        avionMap.put(1L, new Avion(1L, "Boeing 747", 400.0));
        avionMap.put(2L, new Avion(2L, "Airbus A320", 150.0));
        avionMap.put(3L, new Avion(3L, "Cessna 172", 0.8));
    }

    @Override
    public Long create(Avion avion) {
        Long id = (long) (avionMap.size() + 1); // Generamos ID automáticamente
        avion.setId(id);
        avionMap.put(id, avion);
        return id;
    }

    @Override
    public Optional<Avion> read(Long id) {
        return Optional.ofNullable(avionMap.get(id));
    }

    @Override
    public void update(Avion avion) {
        if (!avionMap.containsKey(avion.getId())) {
            throw new IllegalStateException("El avión no existe");
        }
        avionMap.put(avion.getId(), avion);
    }

    @Override
    public void delete(Long id) {
        if (!avionMap.containsKey(id)) {
            throw new IllegalStateException("El avión no existe");
        }
        avionMap.remove(id);
    }

    @Override
    public List<Avion> getAll() {
        return new ArrayList<>(avionMap.values());
    }
}