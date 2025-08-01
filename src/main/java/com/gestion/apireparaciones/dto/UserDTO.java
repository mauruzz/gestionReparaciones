package com.gestion.apireparaciones.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id_user;
    private String username;
    private String type;
    private String name;
    private String email;
    private String branch;

}
