package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Controlador1 {

    @Autowired
    ServicioPersona servicioPersona;

    @GetMapping("/controlador1/addPersona")
    public Persona getPersona (@RequestHeader(value = "nombre") String nombre,@RequestHeader(value = "pobleacion") String pobleacion, @RequestHeader(value = "edad") int edad){
        return servicioPersona.nuevaPersona(nombre,pobleacion,edad);
    }
}
