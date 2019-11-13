package com.example.gestiondestock;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class GestionDeStockApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeStockApplication.class, args);
	}
	
	
	@Bean
	ApplicationRunner init(CommandeRepository repository) {
		
		return args ->{
			
			Stream.of("Commande 01","Commande 02","Commande 03").forEach(nom ->{
				repository.save(new Commande(nom));				
			});
			repository.findAll().forEach(System.out::println);
		};
		
	}
	
	

}
