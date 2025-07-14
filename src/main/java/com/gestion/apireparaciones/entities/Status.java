package com.gestion.apireparaciones.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status;

    private String description;

    @OneToOne(mappedBy = "status", cascade = CascadeType.ALL)
    private ServiceTicket serviceTicket;

}
