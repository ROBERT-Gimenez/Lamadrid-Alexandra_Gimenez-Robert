package com.backend.Clinica_Odontologica;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;

import java.sql.Connection;
import java.sql.DriverManager;


@SpringBootApplication
@RestController
public class ClinicaOdontologicaApplication {

	private static Logger logger = LoggerFactory.getLogger(ClinicaOdontologicaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClinicaOdontologicaApplication.class, args);
		logger.info("Clinica is running now...");
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}




}