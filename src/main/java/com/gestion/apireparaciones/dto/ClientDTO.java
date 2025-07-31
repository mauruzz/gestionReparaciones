package com.gestion.apireparaciones.dto;

import lombok.Data;

@Data
public class ClientDTO {

    private Long id_client;
    //private List<ServiceTicket> tickets;
    private String name;
    private String email;
    private String phone;
    private String address;

}
