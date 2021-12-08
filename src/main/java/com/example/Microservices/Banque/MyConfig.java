package com.example.Microservices.Banque;

import com.example.Microservices.Banque.Web.CompteRestControllerAPI;
import com.example.Microservices.Banque.Web.CompteRestJaxRSAPI;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleJaxWsServiceExporter;

// Class de configuration permettant de faire le deploiement avec Spring JAX-RS
@Configuration
public class MyConfig {

    //@Bean // Annotation permettant d'executer le démarrage
    /*

    on peut desactiver aussi
    si on veut pas travailler avec jersey
    Resrource ... c'est elle qui va deployer Jersey

    */
    public ResourceConfig resourceConfig() {
        ResourceConfig jerseyServlet = new ResourceConfig();
        jerseyServlet.register(CompteRestJaxRSAPI.class);
        return jerseyServlet;
    }

    @Bean // Deployer un Web Service JAX-WS en utilisant SimpleJaxServiceExporter
    SimpleJaxWsServiceExporter serviceExporter(){
        SimpleJaxWsServiceExporter serviceExporter = new SimpleJaxWsServiceExporter();
        serviceExporter.setBaseAddress("http://0.0.0.0:8888/");
        return serviceExporter;
    }
}

