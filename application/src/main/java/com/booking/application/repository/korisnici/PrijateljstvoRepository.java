package com.booking.application.repository.korisnici;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.korisnici.Prijateljstvo;

@Repository
public interface PrijateljstvoRepository extends JpaRepository<Prijateljstvo, Long> {
	
}
