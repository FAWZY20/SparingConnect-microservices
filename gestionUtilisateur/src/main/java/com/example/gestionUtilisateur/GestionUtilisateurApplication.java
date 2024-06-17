package com.example.gestionUtilisateur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GestionUtilisateurApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionUtilisateurApplication.class, args);
	}

}

