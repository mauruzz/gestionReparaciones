package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.Dto.ServiceTicketDTO;
import com.gestion.apireparaciones.Dto.ServiceTicketMapper;
import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.services.ServiceTicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service_ticket")
public class ServiceTicketController {

    private final ServiceTicketService serviceTicketService;

    public ServiceTicketController(ServiceTicketService serviceTicketService) {
        this.serviceTicketService = serviceTicketService;
    }

/*
    @GetMapping("/all")
    public List<ServiceTicket> getAll() { return serviceTicketService.findAll(); }
*/
    @GetMapping("/all")
    public ResponseEntity<List<ServiceTicketDTO>> findAll() {
        List<ServiceTicket> tickets = serviceTicketService.findAll();
        List<ServiceTicketDTO> dtos = tickets.stream().map(ServiceTicketMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ServiceTicket> getById(@PathVariable Long id) {
        ServiceTicket st = serviceTicketService.findById(id);
        return (st != null)  ? ResponseEntity.ok(st)
                : ResponseEntity.notFound().build();
    }

    /*  Original antes del DTO
    @PostMapping("/save")
    public ServiceTicket create(@RequestBody ServiceTicket st) {
        return serviceTicketService.save(st);
    }
    */
    @PostMapping("/save")
    public ResponseEntity<ServiceTicketDTO> create(@RequestBody ServiceTicketDTO dto) {
        ServiceTicket saved = serviceTicketService.save(ServiceTicketMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(ServiceTicketMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceTicket> update(@PathVariable Long id, @RequestBody ServiceTicket st) {
        ServiceTicket u = serviceTicketService.update(id, st);
        return (u != null)  ? ResponseEntity.ok(u)
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
