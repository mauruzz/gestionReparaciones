package com.gestion.apireparaciones.repositories;

import com.gestion.apireparaciones.entities.Status;
import com.gestion.apireparaciones.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status,Long> {

    Optional<Status> getStatusByDescription (String description);

}
