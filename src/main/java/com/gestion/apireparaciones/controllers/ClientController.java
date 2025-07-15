package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.repositories.ClientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientRepository clientRepo;

    public ClientController(ClientRepository clientRepo) { this.clientRepo = clientRepo; }

    @GetMapping("/all")
    public List<Client> getAll() { return clientRepo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return clientRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Client create(@RequestBody Client c) { return clientRepo.save(c); }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client c) {

        if (!clientRepo.existsById(id)) return ResponseEntity.notFound().build();

        c.setId_client(id);
        return ResponseEntity.ok(clientRepo.save(c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!clientRepo.existsById(id)) return ResponseEntity.notFound().build();

        clientRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
