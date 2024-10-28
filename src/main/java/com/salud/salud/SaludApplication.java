package com.salud.salud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.salud.salud.repository")
public class SaludApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaludApplication.class, args);
	}

}
