package com.gestion.apireparaciones.servicies;

import com.gestion.apireparaciones.entities.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findById(Long id);
    Client save(Client c);
    Client update(Long id, Client c);
    void delete(Long id);

}
