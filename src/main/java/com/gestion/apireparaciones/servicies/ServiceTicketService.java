package com.gestion.apireparaciones.servicies;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.entities.ServiceTicket;

import java.util.List;

public interface ServiceTicketService {

    List<ServiceTicket> findAll();
    ServiceTicket findById(Long id);
    ServiceTicket save(ServiceTicket st);
    ServiceTicket update(Long id, ServiceTicket st);
    void delete(Long id);

}
