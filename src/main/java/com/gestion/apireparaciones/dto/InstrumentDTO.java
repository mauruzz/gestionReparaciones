package com.gestion.apireparaciones.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
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
