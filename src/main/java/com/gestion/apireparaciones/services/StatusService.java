package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Status;

import java.util.List;

public interface StatusService {

    List<Status> findAll();
    Status findById(Long id);
    Status save(Status s);
    Status update(Long id, Status s);
    void delete(Long id);

}
