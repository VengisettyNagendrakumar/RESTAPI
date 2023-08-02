package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Restapi2Application {

	public static void main(String[] args) {
		SpringApplication.run(Restapi2Application.class, args);
	}
	@Bean //we write this because to use model mapper every where 
	public ModelMapper modelmapper() { //using modell mapper dependency 
		return new ModelMapper();
	}
}
