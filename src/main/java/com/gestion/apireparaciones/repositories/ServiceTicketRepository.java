package com.gestion.apireparaciones.repositories;

import com.gestion.apireparaciones.entities.ServiceTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ServiceTicketRepository extends JpaRepository<ServiceTicket,Long> {

    @Query("SELECT t FROM ServiceTicket t " +
            "WHERE (:start IS NULL OR t.entry_date >= :start) " +
            "AND (:end IS NULL OR t.entry_date <= :end) " +
            "AND (:clientName IS NULL OR LOWER(t.client.name) LIKE LOWER(CONCAT('%', :clientName, '%'))) " +
            "AND (:model IS NULL OR LOWER(t.instrument.model) LIKE LOWER(CONCAT('%', :model, '%'))) " +
            "AND (:product IS NULL OR LOWER(t.instrument.product) LIKE LOWER(CONCAT('%', :product, '%')))")
    List<ServiceTicket> findByFilters(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end,
            @Param("clientName") String clientName,
            @Param("model") String model,
            @Param("product") String product
    );

}
