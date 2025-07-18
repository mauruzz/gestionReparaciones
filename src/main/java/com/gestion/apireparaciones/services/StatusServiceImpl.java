package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Status;
import com.gestion.apireparaciones.repositories.StatusRepository;
import org.springframework.stereotype.Service;


@Service
public class StatusServiceImpl extends GenericServiceImpl<Status, Long> {

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

}
