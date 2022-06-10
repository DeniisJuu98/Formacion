package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Controlador1 {

    @Autowired
    ServicioCiudad servicioCiudad;

    @PostMapping("/controlador1/addCiudad")
    public void getPersona (@RequestHeader(value = "nombre") String nombre, @RequestHeader(value = "nHabitantes") int nHabitantes){
        servicioCiudad.addCiudad(nombre,nHabitantes);
    }
}
