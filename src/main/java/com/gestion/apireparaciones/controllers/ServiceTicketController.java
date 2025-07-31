package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.dto.ServiceTicketDTO;
import com.gestion.apireparaciones.dto.ServiceTicketMapper;
import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.services.ServiceTicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service_ticket")
public class ServiceTicketController {

    private final ServiceTicketService serviceTicketService;
    private final ServiceTicketMapper mapper;

    public ServiceTicketController(ServiceTicketService serviceTicketService, ServiceTicketMapper mapper) {
        this.serviceTicketService = serviceTicketService;
        this.mapper = mapper;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceTicketDTO>> findAll() {
        List<ServiceTicket> tickets = serviceTicketService.findAll();
        List<ServiceTicketDTO> dtos = tickets.stream().map(mapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServiceTicketDTO> getById(@PathVariable Long id) {
        ServiceTicket st = serviceTicketService.findById(id);
        return ResponseEntity.ok(mapper.toDTO(st));
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceTicketDTO> create(@RequestBody ServiceTicketDTO dto) {
        ServiceTicket saved = serviceTicketService.save(mapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceTicketDTO> update(@PathVariable Long id, @RequestBody ServiceTicketDTO dto) {
        ServiceTicket u = serviceTicketService.update(id, mapper.toEntity(dto));
        return (u != null)  ? ResponseEntity.ok(mapper.toDTO(u))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (serviceTicketService.findById(id) != null){
            serviceTicketService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
