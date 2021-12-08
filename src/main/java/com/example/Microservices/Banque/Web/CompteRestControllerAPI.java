package com.example.Microservices.Banque.Web;

import com.example.Microservices.Banque.Entities.Compte;
import com.example.Microservices.Banque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController //
@RequestMapping("/banque")
public class CompteRestControllerAPI {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping(value = "/comptes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Compte> CompteList() {
        return compteRepository.findAll();
    }

    @GetMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Compte getOne(@PathVariable Long id) {
        return compteRepository.findById(id).get();
    }

    @PostMapping(path = "/comptes")
    public Compte save(Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping(path = "/comptes/{id}")
    public Compte update(@RequestBody Compte compte, @PathVariable Long id) {
        compte.setId(id);
        return compteRepository.save(compte);
    }

    @DeleteMapping(path = "/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void delete(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
