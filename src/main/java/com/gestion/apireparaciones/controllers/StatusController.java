package com.gestion.apireparaciones.controllers;


import com.gestion.apireparaciones.entities.Status;
import com.gestion.apireparaciones.repositories.StatusRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusRepository statusRepo;

    public StatusController(StatusRepository statusRepo) {
        this.statusRepo = statusRepo;
    }

    @GetMapping("/all")
    public List<Status> getAll() {
        return statusRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getById(@PathVariable Long id) {
        return statusRepo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Status create(@RequestBody Status estado) {
        return statusRepo.save(estado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> update(@PathVariable Long id, @RequestBody Status estado) {

        if (!statusRepo.existsById(id)) return ResponseEntity.notFound().build();

        estado.setId_status(id);
        return ResponseEntity.ok(statusRepo.save(estado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!statusRepo.existsById(id)) return ResponseEntity.notFound().build();

        statusRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
