package com.example.Microservices.Banque.repositories;

import com.example.Microservices.Banque.Entities.Compte;
import com.example.Microservices.Banque.Entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

// Spring DataRest
@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

    // Spring DataRest
    @RestResource(path = "/byType")  // pour eviter d'utiliser le mot "findByType"
    //http://localhost:8082/api/comptes/search/findByType?type=EPARGNE
    public List<Compte> findByType (@Param("t") TypeCompte type);
}
