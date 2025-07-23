package com.gestion.apireparaciones.Dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gestion.apireparaciones.entities.ServiceTicket;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class InstrumentDTO {

    private Long id_instrument;
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
