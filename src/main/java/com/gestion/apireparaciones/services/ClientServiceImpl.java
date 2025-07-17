package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl /*implements ClientService */ extends GenericServiceImpl<Client, Long> {

    private final ClientRepository clientRepo;

    public ClientServiceImpl(ClientRepository clientRepo) {
        super(clientRepo);
        this.clientRepo = clientRepo;
    }



    public Client update(Long id, Client c) {
        if (!clientRepo.existsById(id)) return null;
        c.setId_client(id);
        return clientRepo.save(c);
    }


/*

    //
    //  SI TODO FUNCIONA CON EL CODIGO TAL CUAL BORRAR TODO LO QUE ESTA COMENTADO, ES CÓDIGO VIEJO.
    //  ESTOY IMPLEMENTANDO UN SERVICIO GENERICO PARA EL CRUD HABITUAL
    //
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

 */
}
