package com.gestion.apireparaciones.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTO {

    private Long id_client;
    //private List<ServiceTicket> tickets;
    private String name;
    private String email;
    private String phone;
    private String address;

}
