package com.gestion.apireparaciones.security.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Data
public class RegisterRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String type;

    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String branch;
}