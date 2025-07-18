package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.repositories.InstrumentRepository;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService extends GenericServiceImpl<Instrument, Long>{

    private final InstrumentRepository instrumentRepo;

    public InstrumentService(InstrumentRepository instrumentRepo) {
        super(instrumentRepo);
        this.instrumentRepo = instrumentRepo;
    }



    public Instrument update(Long id, Instrument i) {
        if (!instrumentRepo.existsById(id)) return null;
        i.setId_instrument(id);
        return instrumentRepo.save(i);
    }

}
