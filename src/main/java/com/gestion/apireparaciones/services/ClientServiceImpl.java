package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepo;

    public ClientServiceImpl(ClientRepository clientRepo) { this.clientRepo = clientRepo; }


    @Override
    public List<Client> findAll() {
        return clientRepo.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public Client save(Client c) {
        return clientRepo.save(c);
    }

    @Override
    public Client update(Long id, Client c) {
        if (!clientRepo.existsById(id)) return null;
        c.setId_client(id);
        return clientRepo.save(c);
    }

    @Override
    public void delete(Long id) {
        clientRepo.deleteById(id);
    }
}
