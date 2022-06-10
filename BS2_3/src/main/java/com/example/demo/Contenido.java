package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class Contenido {

    private String nombre;

    public Contenido() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
