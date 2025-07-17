package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.entities.Status;
import com.gestion.apireparaciones.repositories.ServiceTicketRepository;
import com.gestion.apireparaciones.repositories.StatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl /*implements StatusService*/ extends GenericServiceImpl<Status, Long> {

    private final StatusRepository statusRepo;

    public StatusServiceImpl(StatusRepository statusRepo) {
        super(statusRepo);
        this.statusRepo = statusRepo;
    }


    public Status update(Long id, Status s) {
        if (!statusRepo.existsById(id)) return null;
        s.setId_status(id);
        return statusRepo.save(s);
    }
    /*
    //
    //  SI TODO FUNCIONA CON EL CODIGO TAL CUAL BORRAR TODO LO QUE ESTA COMENTADO, ES CÓDIGO VIEJO.
    //  ESTOY IMPLEMENTANDO UN SERVICIO GENERICO PARA EL CRUD HABITUAL
    //

    private final StatusRepository statusRepo;

    public StatusServiceImpl(StatusRepository statusRepo) { this.statusRepo = statusRepo; }

    @Override
    public List<Status> findAll() {
        return statusRepo.findAll();
    }

    @Override
    public Status findById(Long id) {
        return statusRepo.findById(id).orElse(null);
    }

    @Override
    public Status save(Status s) {
        return statusRepo.save(s);
    }

    @Override
    public Status update(Long id, Status s) {
        if (!statusRepo.existsById(id)) return null;
        s.setId_status(id);
        return statusRepo.save(s);
    }

    @Override
    public void delete(Long id) {
        statusRepo.deleteById(id);
    }

     */
}
