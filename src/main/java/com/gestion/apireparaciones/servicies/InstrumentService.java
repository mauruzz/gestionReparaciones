package com.gestion.apireparaciones.servicies;

import com.gestion.apireparaciones.entities.Instrument;

import java.util.List;

public interface InstrumentService {

    List<Instrument> findAll();
    Instrument findById(Long id);
    Instrument save(Instrument i);
    Instrument update(Long id, Instrument i);
    void delete(Long id);

}
