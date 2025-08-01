package com.gestion.apireparaciones.security.dto;

import com.gestion.apireparaciones.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterRequestMapper {

    RegisterRequest toDTO(User user);

    User toEntity(RegisterRequest registerRequest);
}