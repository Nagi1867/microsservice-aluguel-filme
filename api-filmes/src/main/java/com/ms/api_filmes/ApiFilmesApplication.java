package com.ms.api_filmes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiFilmesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFilmesApplication.class, args);
	}

}
