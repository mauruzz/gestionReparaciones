package com.gestion.apireparaciones.repositories;

import com.gestion.apireparaciones.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument,Long> {
}
