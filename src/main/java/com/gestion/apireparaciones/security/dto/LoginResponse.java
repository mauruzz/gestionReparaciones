package com.gestion.apireparaciones.security.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private String tokenType = "Bearer";
    private long expiresIn;
    private String username;
    private String role;
    private long id_user;
    private String name;
    private String email;
    private String branch;

    public LoginResponse(String token, long expiresIn, String username, String role, Long id_user,  String name, String email, String branch) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.username = username;
        this.role = role;
        this.id_user = id_user;
        this.name = name;
        this.email = email;
        this.branch = branch;
    }

}
