package com.gestion.apireparaciones.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    @OneToMany(mappedBy = "client")
    private List<ServiceTicket> tickets;

    private String name;
    private String email;
    private String phone;
    private String address;

}
