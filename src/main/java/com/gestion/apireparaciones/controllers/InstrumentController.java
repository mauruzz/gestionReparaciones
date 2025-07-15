package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.repositories.InstrumentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentRepository instrumentRepo;

    public InstrumentController(InstrumentRepository instrumentRepo) {
        this.instrumentRepo = instrumentRepo;
    }

    @GetMapping("/all")
    public List<Instrument> getAll() {
        return instrumentRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getById(@PathVariable Long id) {
        return instrumentRepo.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/save")
    public Instrument create(@RequestBody Instrument i) {
        return instrumentRepo.save(i);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrument> update(@PathVariable Long id, @RequestBody Instrument i) {
        if (!instrumentRepo.existsById(id)) return ResponseEntity.notFound().build();
        i.setId_instrument(id);
        return ResponseEntity.ok(instrumentRepo.save(i));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!instrumentRepo.existsById(id)) return ResponseEntity.notFound().build();
        instrumentRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
