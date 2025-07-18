package com.gestion.apireparaciones.controllers;

import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.services.InstrumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    private final InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }


    @GetMapping("/all")
    public List<Instrument> getAll() {
        return instrumentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getById(@PathVariable Long id) {
        Instrument i = instrumentService.findById(id);
        return (i != null)  ? ResponseEntity.ok(i)
                : ResponseEntity.notFound().build();
    }

    @PostMapping("/save")
    public Instrument create(@RequestBody Instrument i) {
        return instrumentService.save(i);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrument> update(@PathVariable Long id, @RequestBody Instrument i) {
        Instrument u = instrumentService.update(id, i);
        return (u != null)  ? ResponseEntity.ok(u)
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
