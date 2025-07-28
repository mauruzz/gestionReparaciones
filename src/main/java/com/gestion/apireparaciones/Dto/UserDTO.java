package com.gestion.apireparaciones.Dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id_user;
    private String username;
    //private String password;  ENCRIPTAR PASSWORD AL ENVIARLO POR DTO
    private String type;
    private String name;
    private String email;
    private String branch;

}
