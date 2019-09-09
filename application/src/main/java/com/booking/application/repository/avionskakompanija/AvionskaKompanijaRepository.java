package com.booking.application.repository.avionskakompanija;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.avionskakompanija.AvionskaKompanija;

@Repository
public interface AvionskaKompanijaRepository extends JpaRepository<AvionskaKompanija, Long> {

}
