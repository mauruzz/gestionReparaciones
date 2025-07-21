package com.gestion.apireparaciones.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@Table(name = "Instruments")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_instrument;

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "id_service_ticket")
    private ServiceTicket serviceTicket;

    private String product;
    private String brand;
    private String model;
    private String serial_number;
    private LocalDate purchase_datea;
    private String reason;
    private Boolean warranty;
    private String notice;
    private String comments;

}
