package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.repositories.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends GenericServiceImpl<Client, Long> {

    private final ClientRepository clientRepo;

    public ClientService(ClientRepository clientRepo) {
        super(clientRepo);
        this.clientRepo = clientRepo;
    }



    public Client update(Long id, Client c) {
        if (!clientRepo.existsById(id)) return null;
        c.setId_client(id);
        return clientRepo.save(c);
    }

}
