package com.gestion.apireparaciones.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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
