package com.gestion.apireparaciones.Dto;

import com.gestion.apireparaciones.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDTO toDTO(Client client);

    Client toEntity(ClientDTO clientDTO);
}