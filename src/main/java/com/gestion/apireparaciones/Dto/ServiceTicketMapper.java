package com.gestion.apireparaciones.Dto;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.entities.User;
import org.springframework.stereotype.Component;

@Component
public class ServiceTicketMapper {


    // Mapper de entidad → DTO
    public ServiceTicketDTO toDTO(ServiceTicket st) {
        ServiceTicketDTO dto = new ServiceTicketDTO();
        if (st != null) {
            dto.setId_service_ticket(st.getId_service_ticket());
            dto.setEntry_date(st.getEntry_date());
            dto.setDefect(st.getDefect());
            dto.setWork_done(st.getWork_done());
            dto.setBudget(st.getBudget());
            dto.setTotal_cost(st.getTotal_cost());
            dto.setDelivery_date(st.getDelivery_date());
            dto.setComments(st.getComments());
            dto.setReport(st.getReport());

            if (st.getClient() != null) {
                dto.setId_client(st.getClient().getId_client());
                dto.setClientName(st.getClient().getName());
                dto.setClientEmail(st.getClient().getEmail());
                dto.setClientPhone(st.getClient().getPhone());
                dto.setClientAddress(st.getClient().getAddress());
            }

            if (st.getInstrument() != null) {
                dto.setId_instrument(st.getInstrument().getId_instrument());
                dto.setInstrumentProduct(st.getInstrument().getProduct());
                dto.setInstrumentBrand(st.getInstrument().getBrand());
                dto.setInstrumentModel(st.getInstrument().getModel());
                dto.setInstrumentSerial_number(st.getInstrument().getSerial_number());
                dto.setInstrumentPurchase_date(st.getInstrument().getPurchase_date());
                dto.setInstrumentReason(st.getInstrument().getReason());
                dto.setInstrumentWarranty(st.getInstrument().getWarranty());
                dto.setInstrumentNotice(st.getInstrument().getNotice());
                dto.setInstrumentComments(st.getInstrument().getComments());
            }

            if (st.getUser() != null) {
                dto.setId_user(st.getUser().getId_user());
            }

            return dto;
        }
        return null;
    }

    // Mapper de DTO → entidad
    public ServiceTicket toEntity(ServiceTicketDTO dto) {
        ServiceTicket st = new ServiceTicket();
        User u = new User();
        Instrument i = new Instrument();
        Client c = new Client();

        u.setId_user(dto.getId_user());

        c.setId_client(dto.getId_client());
        c.setName(dto.getClientName());
        c.setEmail(dto.getClientEmail());
        c.setPhone(dto.getClientPhone());
        c.setAddress(dto.getClientAddress());

        i.setId_instrument(dto.getId_instrument());
        i.setProduct(dto.getInstrumentProduct());
        i.setBrand(dto.getInstrumentBrand());
        i.setModel(dto.getInstrumentModel());
        i.setSerial_number(dto.getInstrumentSerial_number());
        i.setPurchase_date(dto.getInstrumentPurchase_date());
        i.setReason(dto.getInstrumentReason());
        i.setWarranty(dto.getInstrumentWarranty());
        i.setNotice(dto.getInstrumentNotice());
        i.setComments(dto.getInstrumentComments());

        st.setClient(c);
        st.setInstrument(i);
        st.setUser(u);

        st.setId_service_ticket(dto.getId_service_ticket());
        st.setEntry_date(dto.getEntry_date());
        st.setDefect(dto.getDefect());
        st.setWork_done(dto.getWork_done());
        st.setBudget(dto.getBudget());
        st.setTotal_cost(dto.getTotal_cost());
        st.setDelivery_date(dto.getDelivery_date());
        st.setComments(dto.getComments());
        st.setReport(dto.getReport());

        return st;
    }


}