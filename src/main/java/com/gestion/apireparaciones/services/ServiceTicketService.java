package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.repositories.ServiceTicketRepository;
import org.springframework.stereotype.Service;


@Service
public class ServiceTicketService extends GenericServiceImpl<ServiceTicket, Long> {

    private final ServiceTicketRepository serviceTicketRepo;
    private final InstrumentService instrumentService;

    public ServiceTicketService(ServiceTicketRepository serviceTicketRepo, InstrumentService instrumentService) {
        super(serviceTicketRepo);
        this.serviceTicketRepo = serviceTicketRepo;
        this.instrumentService = instrumentService;
    }

    @Override
    public ServiceTicket save(ServiceTicket st) {
        //instrumentService.save(st.getInstrument());

        Instrument i = st.getInstrument();

        if (i != null) {
            i.setServiceTicket(st);     // Asocia Instrument con la ServiceTicket
            st.setInstrument(i);        // Asegura que la relación esté en ambos lados
        }

        return super.save(st);
    }


    public ServiceTicket update(Long id, ServiceTicket st) {
        if (!serviceTicketRepo.existsById(id)) return null;
        st.setId_service_ticket(id);
        return serviceTicketRepo.save(st);
    }

}
