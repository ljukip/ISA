package com.booking.application.repository.avionskakompanija;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.avionskakompanija.SedisteNaLetu;

@Repository
public interface SedisteNaLetuRepository extends JpaRepository<SedisteNaLetu, Long> {

}
