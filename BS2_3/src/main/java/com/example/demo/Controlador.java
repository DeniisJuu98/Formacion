package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class Controlador {

    @Autowired
    @Qualifier("bean1")
    Contenido p;

    @Autowired
    @Qualifier("bean2")
    Contenido p2;

    @Autowired
    @Qualifier("bean3")
    Contenido p3;


    @GetMapping("/controlador/bean/{bean}")
    public String getNombre(@PathVariable String bean){

        switch (bean){
            case"bean1":
                return p.getNombre();
            case "bean2":
                return p2.getNombre();
            case "bean3":
                return p3.getNombre();
        }
        return "null";
    }
}
