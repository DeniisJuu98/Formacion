package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Profile("Perfil2")
//@ConfigurationProperties("classpath=application-Perfil2.properties")
@Component
public class Perfil2 implements Perfiles {
    private String profile = "perfil2";

    @Value("${URL}")
    private String a;

    @Value("${password}")
    private String b;


    @Override
    public void miFuncion() {
        System.out.println("Profile: " + profile + " con la siguiente url: " + a + " y contraseña: " + b);
    }
}


