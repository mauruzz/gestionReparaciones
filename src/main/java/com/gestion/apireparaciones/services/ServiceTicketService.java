package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.repositories.ServiceTicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceTicketService extends GenericServiceImpl<ServiceTicket, Long> {

    private final ServiceTicketRepository serviceTicketRepo;
    private final InstrumentService instrumentService;
    private final ClientService clientService;

    public ServiceTicketService(ServiceTicketRepository serviceTicketRepo, InstrumentService instrumentService, ClientService clientService) {
        super(serviceTicketRepo);
        this.serviceTicketRepo = serviceTicketRepo;
        this.instrumentService = instrumentService;
        this.clientService = clientService;
    }

    @Override
    public ServiceTicket save(ServiceTicket st) {

        Instrument i = st.getInstrument();
        if (i != null) {
            i.setServiceTicket(st);     // Asocia Instrument con la ServiceTicket
            st.setInstrument(i);        // Asegura que la relación esté en ambos lados
        }

        Client c = st.getClient();
        if (c != null) {
            if (c.getId_client() == null) {
                // Cliente nuevo → lo guardás
                c = clientService.save(c);
            } else {
                // Cliente existente → lo buscás por ID
                c = clientService.findById(c.getId_client());
            }
            // Asignás el cliente (persistido o recuperado)
            st.setClient(c);
        }

        return super.save(st);
    }

    public ServiceTicket update(Long id, ServiceTicket st) {
        if (!serviceTicketRepo.existsById(id)) return null;
        st.setId_service_ticket(id);
        return serviceTicketRepo.save(st);
    }

    public List<ServiceTicket> findTickets(String startDate, String endDate, String clientName, String model, String product) {
        LocalDate start = (startDate != null) ? LocalDate.parse(startDate) : null;
        LocalDate end = (endDate != null) ? LocalDate.parse(endDate) : null;

        return serviceTicketRepo.findByFilters(start, end, clientName, model, product);
    }

}
