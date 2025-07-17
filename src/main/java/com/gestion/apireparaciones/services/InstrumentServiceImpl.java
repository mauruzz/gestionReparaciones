package com.gestion.apireparaciones.services;

import com.gestion.apireparaciones.entities.Client;
import com.gestion.apireparaciones.entities.Instrument;
import com.gestion.apireparaciones.repositories.ClientRepository;
import com.gestion.apireparaciones.repositories.InstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentServiceImpl /*implements InstrumentService*/ extends GenericServiceImpl<Instrument, Long>{

    private final InstrumentRepository instrumentRepo;

    public InstrumentServiceImpl(InstrumentRepository instrumentRepo) {
        super(instrumentRepo);
        this.instrumentRepo = instrumentRepo;
    }



    public Instrument update(Long id, Instrument i) {
        if (!instrumentRepo.existsById(id)) return null;
        i.setId_instrument(id);
        return instrumentRepo.save(i);
    }


    /*
    //
    //  SI TODO FUNCIONA CON EL CODIGO TAL CUAL BORRAR TODO LO QUE ESTA COMENTADO, ES CÓDIGO VIEJO.
    //  ESTOY IMPLEMENTANDO UN SERVICIO GENERICO PARA EL CRUD HABITUAL
    //
    private final InstrumentRepository instrumentRepo;

    public InstrumentServiceImpl(InstrumentRepository instrumentRepo) { this.instrumentRepo = instrumentRepo; }


    @Override
    public List<Instrument> findAll() {
        return instrumentRepo.findAll();
    }

    @Override
    public Instrument findById(Long id) {
        return instrumentRepo.findById(id).orElse(null);
    }

    @Override
    public Instrument save(Instrument i) {
        return instrumentRepo.save(i);
    }

    @Override
    public Instrument update(Long id, Instrument i) {
        if (!instrumentRepo.existsById(id)) return null;
        i.setId_instrument(id);
        return instrumentRepo.save(i);
    }

    @Override
    public void delete(Long id) {
        instrumentRepo.deleteById(id);
    }

     */
}
