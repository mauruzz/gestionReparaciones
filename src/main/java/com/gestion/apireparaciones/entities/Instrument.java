package com.gestion.apireparaciones.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_instrument;

    @OneToOne
    @JoinColumn(name = "id_service_ticket")
    private ServiceTicket serviceTicket;

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
