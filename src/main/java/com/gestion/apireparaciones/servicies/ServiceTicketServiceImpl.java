package com.gestion.apireparaciones.servicies;

import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.repositories.ServiceTicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTicketServiceImpl implements ServiceTicketService {

    private final ServiceTicketRepository serviceTicketRepo;

    public ServiceTicketServiceImpl(ServiceTicketRepository serviceTicketRepo) { this.serviceTicketRepo = serviceTicketRepo; }


    @Override
    public List<ServiceTicket> findAll() {
        return serviceTicketRepo.findAll();
    }

    @Override
    public ServiceTicket findById(Long id) {
        return serviceTicketRepo.findById(id).orElse(null);
    }

    @Override
    public ServiceTicket save(ServiceTicket st) {
        return serviceTicketRepo.save(st);
    }

    @Override
    public ServiceTicket update(Long id, ServiceTicket st) {
        if (!serviceTicketRepo.existsById(id)) return null;
        st.setId_service_ticket(id);
        return serviceTicketRepo.save(st);
    }

    @Override
    public void delete(Long id) {
        serviceTicketRepo.deleteById(id);
    }
}
