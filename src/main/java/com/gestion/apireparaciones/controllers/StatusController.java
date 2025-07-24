package com.gestion.apireparaciones.controllers;


import com.gestion.apireparaciones.Dto.ClientDTO;
import com.gestion.apireparaciones.Dto.StatusDTO;
import com.gestion.apireparaciones.Dto.StatusMapper;
import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.entities.Status;
import com.gestion.apireparaciones.services.StatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;
    private final StatusMapper statusMapper;

    public StatusController(StatusService statusService, StatusMapper statusMapper) {
        this.statusService = statusService;
        this.statusMapper = statusMapper;
    }


    @GetMapping("/all")
    public ResponseEntity<List<StatusDTO>> getAll() {
        List<Status> s = statusService.findAll();
        List<StatusDTO> dtos = s.stream().map(statusMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getById(@PathVariable Long id) {
        Status s = statusService.findById(id);
        return (s != null)  ? ResponseEntity.ok(statusMapper.toDTO(s))
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public ResponseEntity<StatusDTO> create(@RequestBody StatusDTO dto) {
        Status saved = statusService.save(statusMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(statusMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StatusDTO> update(@PathVariable Long id, @RequestBody StatusDTO dto) {
        Status s = statusService.update(id, statusMapper.toEntity(dto));
        return (s != null)  ? ResponseEntity.ok(statusMapper.toDTO(s))
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
