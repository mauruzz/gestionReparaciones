package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.dto.ServiceTicketDTO;
import com.gestion.apireparaciones.dto.ServiceTicketMapper;
import com.gestion.apireparaciones.entities.*;
import com.gestion.apireparaciones.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceTicketService extends GenericServiceImpl<ServiceTicket, Long> {

    private final ServiceTicketRepository serviceTicketRepo;
    private final ClientService clientService;
    private final InstrumentService instrumentService;
    private final StatusService statusService;
    private final UserService userService;

    public ServiceTicketService(ServiceTicketRepository serviceTicketRepo, ClientService clientService, InstrumentService instrumentService, StatusService statusService, UserService userService) {
        super(serviceTicketRepo);
        this.serviceTicketRepo = serviceTicketRepo;
        this.clientService = clientService;
        this.instrumentService = instrumentService;
        this.statusService = statusService;
        this.userService = userService;
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


    @Transactional
    public ServiceTicket update(Long id, ServiceTicket st) {
        ServiceTicket existing = serviceTicketRepo.findById(id).orElse(null);
        if (existing == null) return null;

        // Actualizar SOLO los campos propios de ServiceTicket
        existing.setEntry_date(st.getEntry_date());
        existing.setDefect(st.getDefect());
        existing.setWork_done(st.getWork_done());
        existing.setBudget(st.getBudget());
        existing.setTotal_cost(st.getTotal_cost());
        existing.setDelivery_date(st.getDelivery_date());
        existing.setComments(st.getComments());
        existing.setReport(st.getReport());

        // Si además querés modificar Instrument → usar su servicio
        if (st.getInstrument() != null && st.getInstrument().getId_instrument() != null) {
            instrumentService.update(st.getInstrument().getId_instrument(), st.getInstrument());
        }

        // Si además querés modificar Client
        if (st.getClient() != null && st.getClient().getId_client() != null) {
            clientService.update(st.getClient().getId_client(), st.getClient());
        }



        return serviceTicketRepo.save(existing);
    }





    public List<ServiceTicket> filterTickets(String startDate, String endDate, String clientName, String model, String product) {
        LocalDate start = (startDate != null) ? LocalDate.parse(startDate) : null;
        LocalDate end = (endDate != null) ? LocalDate.parse(endDate) : null;

        return serviceTicketRepo.findByFilters(start, end, clientName, model, product);
    }

}
