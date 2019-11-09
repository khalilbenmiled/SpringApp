package com.esprit.gestionProduit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MsGestionProduitApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsGestionProduitApplication.class, args);
	}

}
