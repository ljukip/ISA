package com.booking.application.repository.vozila;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.vozila.Vozilo;

@Repository
public interface VoziloRepository extends JpaRepository<Vozilo, Long> {

}
