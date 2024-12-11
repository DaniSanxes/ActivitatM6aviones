package com.luiDan.aviones.backend.business.model;

import java.io.Serializable;

public class Avion implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String modelo;
    private Double peso;

    // Constructor vacío
    public Avion() {}

    // Constructor con valores
    public Avion(Long id, String modelo, Double peso) {
        this.id = id;
        this.modelo = modelo;
        this.peso = peso;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}

