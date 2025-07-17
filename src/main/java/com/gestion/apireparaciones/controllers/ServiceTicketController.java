package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.services.ServiceTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service_ticket")
public class ServiceTicketController {

    private final ServiceTicketService serviceTicketService;

    public ServiceTicketController(ServiceTicketService serviceTicketService) { this.serviceTicketService = serviceTicketService; }

    @GetMapping("/all")
    public List<ServiceTicket> getAll() { return serviceTicketService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceTicket> getById(@PathVariable Long id) {
        ServiceTicket st = serviceTicketService.findById(id);
        return (st != null)  ? ResponseEntity.ok(st)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ServiceTicket create(@RequestBody ServiceTicket st) { return serviceTicketService.save(st); }

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
