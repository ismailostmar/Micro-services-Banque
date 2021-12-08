package com.example.Microservices.Banque.Entities;

import org.springframework.data.rest.core.config.Projection;

// @Porjection est : sélectionner uniquement une colonne spécifique
// au lieu d'extraire toutes les colonnes de la table
@Projection(name = "mobile" , types = Compte.class)
public interface CompteProjections2 {
    public double getSolde();
    public TypeCompte getType();
}