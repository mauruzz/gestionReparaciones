package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.dto.ClientDTO;
import com.gestion.apireparaciones.dto.ClientMapper;
import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;
    private final ClientMapper clientMapper;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
        this.clientMapper = clientMapper;
    }


    @GetMapping("/all")
    public ResponseEntity<List<ClientDTO>> getAll() {
        List<Client> c = clientService.findAll();
        List<ClientDTO> dtos = c.stream().map(clientMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> getById(@PathVariable Long id) {
        Client c = clientService.findById(id);
        return (c != null)  ? ResponseEntity.ok(clientMapper.toDTO(c))
                            : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO dto) {
        Client saved = clientService.save(clientMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(clientMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto) {
        Client u = clientService.update(id, clientMapper.toEntity(dto));
        return (u != null)  ? ResponseEntity.ok(clientMapper.toDTO(u))
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
