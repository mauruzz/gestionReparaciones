package com.gestion.apireparaciones.Dto;

import com.gestion.apireparaciones.entities.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    StatusDTO toDTO(Status status);

    Status toEntity(StatusDTO dto);

}
