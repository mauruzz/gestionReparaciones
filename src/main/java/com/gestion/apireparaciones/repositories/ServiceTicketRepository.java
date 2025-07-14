package com.gestion.apireparaciones.repositories;

import com.gestion.apireparaciones.entities.ServiceTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTicketRepository extends JpaRepository<ServiceTicket,Long> {
}
