package com.gestion.apireparaciones.security.dto;

import lombok.Data;

@Data
public class LoginResponse {

    private String token;
    private String tokenType = "Bearer";
    private long expiresIn;
    private String username;
    private String role;

    public LoginResponse(String token, long expiresIn, String username, String role) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.username = username;
        this.role = role;
    }

}
