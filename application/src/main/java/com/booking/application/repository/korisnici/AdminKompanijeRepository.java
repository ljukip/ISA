package com.booking.application.repository.korisnici;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.korisnici.AdminKompanije;

@Repository
public interface AdminKompanijeRepository extends JpaRepository<AdminKompanije, Long> {

	Optional<AdminKompanije> findByEmail(String mejl);
	
}
