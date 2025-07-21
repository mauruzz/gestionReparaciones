package com.gestion.apireparaciones.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_client;

    @OneToMany(mappedBy = "client")
    @JsonManagedReference
    private List<ServiceTicket> tickets;

    private String name;
    private String email;
    private String phone;
    private String address;

}
