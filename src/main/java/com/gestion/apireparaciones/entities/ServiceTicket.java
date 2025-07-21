package com.gestion.apireparaciones.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToOne(mappedBy = "serviceTicket", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "instrument-ticket")
    private Instrument instrument;

    @ManyToOne
    @JsonBackReference(value = "user-ticket")
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JsonBackReference(value = "status-ticket")
    @JoinColumn(name = "id_status")
    private Status status;

    @ManyToOne
    @JsonBackReference(value = "client-ticket")
    @JoinColumn(name = "id_client")
    private Client client;


    private LocalDate entry_date;
    private String defect;
    private String work_done;
    private String budget;
    private BigDecimal total_cost;
    private LocalDate delivery_date;
    private String comments;
    private String report;

}
