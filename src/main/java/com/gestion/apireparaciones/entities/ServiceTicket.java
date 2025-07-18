package com.gestion.apireparaciones.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Service_Tickets")
public class ServiceTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_service_ticket;

    @ManyToOne
    @JoinColumn(name = "id_client", nullable = false)
    private Client client;

    private LocalDate entry_date;

    @OneToOne
    @JoinColumn(name = "id_status")
    private Status status;

    private String defect;
    private String work_done;
    private String budget;
    private BigDecimal total_cost;
    private LocalDate delivery_date;
    private String comments;
    private String report;

    @OneToOne(mappedBy = "serviceTicket", cascade = CascadeType.ALL)
    private Instrument instrument;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

}
