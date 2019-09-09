package com.booking.application.repository.vozila;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.vozila.ZakupVozila;

@Repository
public interface ZakupVozilaRepository extends JpaRepository<ZakupVozila, Long> {

}
