package com.gestion.apireparaciones.security.dto;

import com.gestion.apireparaciones.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RegisterRequestMapper {

    @Mapping(target = "password", ignore = true)
    RegisterRequest toDTO(User user);

    User toEntity(RegisterRequest registerRequest);
}