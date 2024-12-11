package com.luiDan.aviones.backendpresentation.restcontrollers;

import com.luiDan.aviones.backend.business.model.Avion;
import com.luiDan.aviones.backend.business.services.AvionServices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aviones")
public class AvionController {

    private final AvionServices avionServices;

    public AvionController(AvionServices avionServices) {
        this.avionServices = avionServices;
    }

    @GetMapping
    public List<Avion> getAll() {
        return avionServices.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Long id) {
        Optional<Avion> optionalAvion = avionServices.read(id);
        if (optionalAvion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra el avión con ID " + id);
        }
        return ResponseEntity.ok(optionalAvion.get());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Avion avion, UriComponentsBuilder ucb) {
        Long id = avionServices.create(avion);
        URI uri = ucb.path("/aviones/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Avion avion) {
        try {
            avionServices.update(avion);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            avionServices.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
