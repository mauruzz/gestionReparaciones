package com.gestion.apireparaciones.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
