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
        return instrumentRepo.findById(id)
                .map(existing -> {
                    // 🔹 Actualizamos SOLO los campos editables
                    existing.setProduct(i.getProduct());
                    existing.setBrand(i.getBrand());
                    existing.setModel(i.getModel());
                    existing.setSerial_number(i.getSerial_number());
                    existing.setPurchase_date(i.getPurchase_date());
                    existing.setReason(i.getReason());
                    existing.setWarranty(i.getWarranty());
                    existing.setNotice(i.getNotice());
                    existing.setComments(i.getComments());
                    // ⚠️ No tocamos el ServiceTicket ni otros vínculos

                    return instrumentRepo.save(existing);
                })
                .orElse(null);
    }

/*
    public Instrument update(Long id, Instrument i) {
        if (!instrumentRepo.existsById(id)) return null;
        i.setId_instrument(id);
        return instrumentRepo.save(i);
    }
*/
}
