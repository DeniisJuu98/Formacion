package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Demo0Application {

	public static void main(String[] args) {

		SpringApplication.run(Demo0Application.class, args);
	}
	@Bean("bean1")
	public Contenido Person1(){
		Contenido Contenido1 = new Contenido();
		Contenido1.setNombre("bean1");
		return Contenido1;
	}
	@Bean ("bean2")
	public Contenido Person2(){
		Contenido Contenido2 = new Contenido();
		Contenido2.setNombre("bean2");
		return Contenido2;
	}
	@Bean("bean3")
	public Contenido Person3(){
		Contenido Contenido3 = new Contenido();
		Contenido3.setNombre("bean3");
		return Contenido3;
	}
}
