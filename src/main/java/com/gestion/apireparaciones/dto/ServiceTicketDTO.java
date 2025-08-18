package com.gestion.apireparaciones.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class ServiceTicketDTO {


    //  Datos de la entidad ServiceTicket
    private Long id_service_ticket;
    private LocalDate entry_date;
    private String defect;
    private String work_done;
    private String budget;
    private BigDecimal total_cost;
    private LocalDate delivery_date;
    private String comments;
    private String report;

    private UserDTO user;
    private ClientDTO client;
    private InstrumentDTO instrument;
    private StatusDTO status;

}
