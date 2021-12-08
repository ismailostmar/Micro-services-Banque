package com.example.Microservices.Banque.Web;

import com.example.Microservices.Banque.Entities.Compte;
import com.example.Microservices.Banque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Component
@WebService(serviceName = "BanqueWS") // JAX ws
public class CompteSoapService {

    @Autowired
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> CompteList(){
        return compteRepository.findAll();
    }

    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).get();
    }
}
