package com.gestion.apireparaciones.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_status;

    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<ServiceTicket> serviceTicket;


    private String description;


}
