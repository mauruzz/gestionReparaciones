package com.gestion.apireparaciones.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ServiceTicket> serviceTicket;

    private String username;
    private String password;

    private String type;
    private String name;
    private String email;
    private String branch;

}
