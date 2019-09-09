package com.booking.application.repository.avionskakompanija;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.avionskakompanija.AvionskaKarta;

@Repository
public interface AvionskaKartaRepository extends JpaRepository<AvionskaKarta, Long> {

}
