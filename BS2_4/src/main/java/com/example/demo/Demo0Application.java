package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Demo0Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo0Application.class, args);
	}

	@PostConstruct
	public void ejecutame1(){
		System.out.println("Hola desde la clase inicial");
	}

	@Bean
	CommandLineRunner ejecutame2(){
		return p ->{
			System.out.println("Hola desde clase secundaria");
		};
	}

	@Bean
	CommandLineRunner ejecutame3(){
		return p ->{
			System.out.println("Soy la tercera clase");
		};
	}
}
