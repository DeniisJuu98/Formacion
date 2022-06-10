package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.Control;

@RestController()
public class Controlador2 {

    @Autowired
    ServicioPersona servicioPersona;

    @GetMapping("/controlador2/getPersona")
    public Persona devuelvePersona(){
        Persona p = servicioPersona.getPersona();
        p.setEdad(p.getEdad()*2);
        return p;
    }
}
