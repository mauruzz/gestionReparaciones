package com.gestion.apireparaciones.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Technicians")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_technician;

    @OneToOne(mappedBy = "technician")
    private ServiceTicket serviceTicket;

    private String name;
    private String email;
    private String branch;

}
