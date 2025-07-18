package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.repositories.ServiceTicketRepository;
import org.springframework.stereotype.Service;


@Service
public class ServiceTicketServiceImpl extends GenericServiceImpl<ServiceTicket, Long> {

    private final ServiceTicketRepository serviceTicketRepo;

    public ServiceTicketServiceImpl(ServiceTicketRepository serviceTicketRepo) {
        super(serviceTicketRepo);
        this.serviceTicketRepo = serviceTicketRepo;
    }



    public ServiceTicket update(Long id, ServiceTicket st) {
        if (!serviceTicketRepo.existsById(id)) return null;
        st.setId_service_ticket(id);
        return serviceTicketRepo.save(st);
    }

}
