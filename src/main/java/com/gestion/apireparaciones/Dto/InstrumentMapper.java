package com.gestion.apireparaciones.Dto;

import com.gestion.apireparaciones.entities.Instrument;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstrumentMapper {
    @Mapping(target = "serviceTicketId", source = "serviceTicket.id")
    InstrumentDTO toDTO(Instrument instrument);

    @InheritInverseConfiguration
    @Mapping(target = "serviceTicket", ignore = true) // se setea aparte si es necesario
    Instrument toEntity(InstrumentDTO dto);
}
