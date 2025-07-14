package com.gestion.apireparaciones.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Instrument")
public class Instrument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_instrument;

    @OneToOne
    @JoinColumn(name = "id_service_ticket", nullable = false)
    private ServiceTicket serviceTicket;

    private String producto;
    private String marca;
    private String modelo;
    private String nro_serie;
    private LocalDate fecha_compra;
    private String motivo;
    private String garantia;
    private String aviso;
    private String observaciones;

}
