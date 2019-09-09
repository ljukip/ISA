package com.booking.application.repository.vozila;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.vozila.KompanijaVozila;

@Repository
public interface KompanijaVozilaRepository extends JpaRepository<KompanijaVozila, Long> {

}
