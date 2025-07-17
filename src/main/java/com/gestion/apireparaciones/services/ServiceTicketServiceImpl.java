package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.repositories.InstrumentRepository;
import com.gestion.apireparaciones.repositories.ServiceTicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTicketServiceImpl /*implements ServiceTicketService*/ extends GenericServiceImpl<ServiceTicket, Long> {

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



    /*
    //
    //  SI TODO FUNCIONA CON EL CODIGO TAL CUAL BORRAR TODO LO QUE ESTA COMENTADO, ES CÓDIGO VIEJO.
    //  ESTOY IMPLEMENTANDO UN SERVICIO GENERICO PARA EL CRUD HABITUAL
    //
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

 */
}
