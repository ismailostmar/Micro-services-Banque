package com.example.Microservices.Banque.Entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde" , types = Compte.class)
public interface CompteProjections {
     public double getSolde();
}


