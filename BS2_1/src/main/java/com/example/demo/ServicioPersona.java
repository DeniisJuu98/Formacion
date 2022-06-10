package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ServicioPersona {
    Persona p = new Persona();

    public Persona nuevaPersona(String nombre, String poblacion, int edad) {
        p.setNombre(nombre);
        p.setPobleacion(poblacion);
        p.setEdad(edad);
        return p;
    }

    public Persona getPersona()
    {
        return p;
    }
}
