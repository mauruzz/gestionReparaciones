package com.gestion.apireparaciones.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status;

    @OneToMany(mappedBy = "status")
    private List<ServiceTicket> serviceTicket;


    private String description;
    private String color;
    private boolean enable;


}
