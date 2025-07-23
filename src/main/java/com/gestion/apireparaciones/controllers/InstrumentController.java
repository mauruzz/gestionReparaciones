package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.Dto.ClientDTO;
import com.gestion.apireparaciones.Dto.InstrumentDTO;
import com.gestion.apireparaciones.Dto.InstrumentMapper;
import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.services.InstrumentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;
    private final InstrumentMapper instrumentMapper;

    public InstrumentController(InstrumentService instrumentService, InstrumentMapper instrumentMapper) {
        this.instrumentService = instrumentService;
        this.instrumentMapper = instrumentMapper;
    }


    @GetMapping("/all")
    public ResponseEntity<List<InstrumentDTO>> getAll() {
        List<Instrument> i = instrumentService.findAll();
        List<InstrumentDTO> dtos = i.stream().map(instrumentMapper::toDTO).toList();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InstrumentDTO> getById(@PathVariable Long id) {
        Instrument i = instrumentService.findById(id);
        return (i != null)  ? ResponseEntity.ok(instrumentMapper.toDTO(i))
                : ResponseEntity.notFound().build();

    }

    @PostMapping("/save")
    public ResponseEntity<InstrumentDTO> create(@RequestBody InstrumentDTO dto) {
        Instrument saved = instrumentService.save(instrumentMapper.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(instrumentMapper.toDTO(saved));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InstrumentDTO> update(@PathVariable Long id, @RequestBody InstrumentDTO dto) {
        Instrument u = instrumentService.update(id, instrumentMapper.toEntity(dto));
        return (u != null)  ? ResponseEntity.ok(instrumentMapper.toDTO(u))
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (instrumentService.findById(id) != null){
            instrumentService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
