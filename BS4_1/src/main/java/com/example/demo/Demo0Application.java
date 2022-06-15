package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class Demo0Application {
	@Autowired
	private Controlador c;

	public static void main(String[] args) {
		SpringApplication.run(Demo0Application.class, args);
	}

	@Bean
	CommandLineRunner properties(){
		return p ->{
			System.out.println(c.getUrl()+"\n"+c.getPassword());
		};
	}

}
