package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("Perfil3")
//@ConfigurationProperties("classpath=application-Perfil3.properties")
@Component
public class PerfilOtro implements Perfiles{
    private String profile="Otro Perfil";

    @Value("${URL}")
    private String a;

    @Value("${password}")
    private String b;


    @Override
    public void miFuncion() {
        System.out.println("Profile: " + profile + " con la siguiente url: " + a + " y contraseña: " + b );
    }
}
