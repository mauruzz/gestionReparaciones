package com.gestion.apireparaciones.repositories;

import com.gestion.apireparaciones.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client,Long> {
}
