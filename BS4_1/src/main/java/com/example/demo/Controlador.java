package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controlador {

    @Autowired
    Perfiles perfiles;

    @Value("${URL}")
    private String url;

    @Value("${password}")
    private String password;

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    @GetMapping("/parametros")
    public String parametros(){
        return "url: "+url+"\npassword: "+password;
    }

//    @GetMapping("/valores")
//    public String valores(){
//        return "Valor1: "+conf.getValor1()+"\nValor2: "+conf.getValor2();
//    }

    @GetMapping("/perfil")
    public void getNombre(){
        perfiles.miFuncion();
    }

}
