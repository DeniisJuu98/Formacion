package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Profile("Perfil1")
//@PropertySource("classpath:miconfiguracion.properties")
@Component
public class Perfil1 implements Perfiles{
    private String profile= "perfil1" ;

    @Value("${URL}")
    private String a;

    @Value("${password}")
    private String b;


    @Override
    public void miFuncion() {
        System.out.println("Profile: "+profile + " con la siguiente url: " + a + " y contraseña: " + b );
    }

}
