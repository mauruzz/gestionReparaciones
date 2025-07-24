package com.gestion.apireparaciones.Dto;

import com.gestion.apireparaciones.Dto.InstrumentDTO;
import com.gestion.apireparaciones.entities.Instrument;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstrumentMapper {
    @Mapping(
            target = "serviceTicketId",
            expression = "java(instrument.getServiceTicket() != null ? instrument.getServiceTicket().getId_service_ticket() : null)"
    )
    InstrumentDTO toDTO(Instrument instrument);

    @InheritInverseConfiguration
    @Mapping(target = "serviceTicket", ignore = true)
    Instrument toEntity(InstrumentDTO dto);
}
