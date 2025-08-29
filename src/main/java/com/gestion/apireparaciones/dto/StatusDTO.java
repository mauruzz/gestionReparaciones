package com.gestion.apireparaciones.dto;

import lombok.Data;

@Data
public class StatusDTO {

    private Long id_status;
    private String description;
    private String color;
    private boolean enable;

}
