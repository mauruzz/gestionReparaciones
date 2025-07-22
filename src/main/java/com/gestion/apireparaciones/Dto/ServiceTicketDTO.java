package com.gestion.apireparaciones.Dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
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

    //  Datos de la entidad Client
    private Long id_client;
    private String clientName;
    private String clientEmail;
    private String clientPhone;
    private String clientAddress;

    //  Datos de la entidad Intrument
    private Long id_instrument;
    private String instrumentProduct;
    private String instrumentBrand;
    private String instrumentModel;
    private String instrumentSerial_number;
    private LocalDate instrumentPurchase_date;
    private String instrumentReason;
    private Boolean instrumentWarranty;
    private String instrumentNotice;
    private String instrumentComments;

    //Datos de la entidad User
    private Long id_user;

}
