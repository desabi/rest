package com.abi.rest01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Rest01Application {

	private static final Logger log = LoggerFactory.getLogger(Rest01Application.class);

	public static void main(String[] args) {
		log.info("Iniciando app.");
		SpringApplication.run(Rest01Application.class, args);
		log.info("App iniciada.");
	}

}
