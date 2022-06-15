package com.example.EjercicioJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.EjercicioJPA.Interfaces"})
public class EjercicioJPA {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioJPA.class, args);
	}

	

}
