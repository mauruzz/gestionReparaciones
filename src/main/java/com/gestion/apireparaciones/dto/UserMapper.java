package com.gestion.apireparaciones.dto;

import com.gestion.apireparaciones.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO dto);

}
