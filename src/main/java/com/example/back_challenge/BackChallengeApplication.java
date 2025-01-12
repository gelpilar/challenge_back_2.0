package com.example.back_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BackChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackChallengeApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**") // Permitir todas las rutas
						.allowedOrigins("*") // Permitir cualquier origen
						.allowedMethods("*") // Permitir todos los métodos HTTP
						.allowedHeaders("*"); // Permitir cualquier encabezado
			}
		};
	}
}
