package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.repositories.ClientRepository;
import com.gestion.apireparaciones.servicies.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) { this.clientService = clientService; }

    @GetMapping("/all")
    public List<Client> getAll() { return clientService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        Client c = clientService.findById(id);
        return (c != null)  ? ResponseEntity.ok(c)
                            : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public Client create(@RequestBody Client c) { return clientService.save(c); }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client c) {
        Client u = clientService.update(id, c);
        return (u != null)  ? ResponseEntity.ok(u)
                            : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (clientService.findById(id) != null){
            clientService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
