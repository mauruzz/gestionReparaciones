package com.gestion.apireparaciones.dto;

import com.gestion.apireparaciones.entities.ServiceTicket;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(
        componentModel = "spring",
        uses = {UserMapper.class, ClientMapper.class, InstrumentMapper.class}
)
public interface ServiceTicketMapper {

    @Mappings({
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "client", target = "client"),
            @Mapping(source = "instrument", target = "instrument"),
            @Mapping(source = "id_service_ticket", target = "id_service_ticket"),
            @Mapping(source = "entry_date", target = "entry_date"),
            @Mapping(source = "defect", target = "defect"),
            @Mapping(source = "work_done", target = "work_done"),
            @Mapping(source = "budget", target = "budget"),
            @Mapping(source = "total_cost", target = "total_cost"),
            @Mapping(source = "delivery_date", target = "delivery_date"),
            @Mapping(source = "comments", target = "comments"),
            @Mapping(source = "report", target = "report")
    })
    ServiceTicketDTO toDTO(ServiceTicket st);

    @InheritInverseConfiguration
    ServiceTicket toEntity(ServiceTicketDTO dto);

}