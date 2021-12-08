package com.example.Microservices.Banque;

import com.example.Microservices.Banque.Entities.Client;
import com.example.Microservices.Banque.Entities.Compte;
import com.example.Microservices.Banque.Entities.TypeCompte;
import com.example.Microservices.Banque.repositories.ClientRepository;
import com.example.Microservices.Banque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class MicroServicesBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServicesBanqueApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository , RepositoryRestConfiguration restConfiguration,
							ClientRepository clientRepository){
		return args -> {
			restConfiguration.exposeIdsFor(Compte.class); // si on veut exposer le ID de notre Entité //
			Client c1 = clientRepository.save(new Client(null,"ISMAIL",null));
			Client c2 = clientRepository.save(new Client(null,"ALI",null));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.EPARGNE , c1));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.EPARGNE ,c2));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.COURANT,c2));
			compteRepository.save(new Compte(null,Math.random()*9000, new Date(), TypeCompte.EPARGNE,c1));
			compteRepository.findAll().forEach(c -> {
				System.out.println(c.getSolde()); // Lazy
			});
		};
	}

}