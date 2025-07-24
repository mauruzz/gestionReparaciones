package com.gestion.apireparaciones.Dto;

import com.gestion.apireparaciones.entities.ServiceTicket;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class InstrumentDTO {

    private Long id_instrument;
    //private ServiceTicket serviceTicket;
    private Long serviceTicketId;
    private String product;
    private String brand;
    private String model;
    private String serial_number;
    private LocalDate purchase_date;
    private String reason;
    private Boolean warranty;
    private String notice;
    private String comments;

}
