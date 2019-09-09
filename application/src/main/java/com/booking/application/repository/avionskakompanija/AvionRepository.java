package com.booking.application.repository.avionskakompanija;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.avionskakompanija.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long>{

}
