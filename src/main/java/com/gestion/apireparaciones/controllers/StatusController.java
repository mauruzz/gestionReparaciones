package com.gestion.apireparaciones.controllers;


import com.gestion.apireparaciones.entities.Status;
import com.gestion.apireparaciones.services.StatusServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusServiceImpl statusService;

    public StatusController(StatusServiceImpl statusService) {
        this.statusService = statusService;
    }


    @GetMapping("/all")
    public List<Status> getAll() {
        return statusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> getById(@PathVariable Long id) {
        Status s = statusService.findById(id);
        return (s != null)  ? ResponseEntity.ok(s)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public Status create(@RequestBody Status s) {
        return statusService.save(s);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> update(@PathVariable Long id, @RequestBody Status s) {
        Status u = statusService.update(id, s);
        return (u != null)  ? ResponseEntity.ok(u)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (statusService.findById(id) != null){
            statusService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
