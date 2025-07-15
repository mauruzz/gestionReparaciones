package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.ServiceTicket;
import com.gestion.apireparaciones.repositories.ServiceTicketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service_ticket")
public class ServiceTicketController {

    private final ServiceTicketRepository ServiceTicketRepo;

    public ServiceTicketController(ServiceTicketRepository ServiceTicketRepo) { this.ServiceTicketRepo = ServiceTicketRepo; }

    @GetMapping("/all")
    public List<ServiceTicket> getAll() { return ServiceTicketRepo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceTicket> getById(@PathVariable Long id) {
        return ServiceTicketRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public ServiceTicket create(@RequestBody ServiceTicket st) { return ServiceTicketRepo.save(st); }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceTicket> update(@PathVariable Long id, @RequestBody ServiceTicket st) {

        if (!ServiceTicketRepo.existsById(id)) return ResponseEntity.notFound().build();

        st.setId_service_ticket(id);
        return ResponseEntity.ok(ServiceTicketRepo.save(st));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!ServiceTicketRepo.existsById(id)) return ResponseEntity.notFound().build();

        ServiceTicketRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
