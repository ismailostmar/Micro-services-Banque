package com.example.Microservices.Banque.Web;

import com.example.Microservices.Banque.Entities.Compte;
import com.example.Microservices.Banque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

// Creation d'une API Rest avec JAX-RS
@Component // pour dire que c'est un composant SPRING
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepository compteRepository;


    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML}) // JaxB
    public List<Compte> CompteList(){
        return compteRepository.findAll();
    }

    @Path("/comptes/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON) // Jersey utilise JAXSON
    public Compte getOne(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get();
    }

    @Path("/comptes")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Compte save(Compte compte)
    {
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Compte update(Compte compte, @PathParam(value = "id") Long id)
    {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @Path("/comptes/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam(value = "id") Long id)
    {
        compteRepository.deleteById(id);
    }
}
