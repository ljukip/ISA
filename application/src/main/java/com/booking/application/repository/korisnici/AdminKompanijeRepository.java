package com.booking.application.repository.korisnici;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.korisnici.AdminKompanije;

@Repository
public interface AdminKompanijeRepository extends JpaRepository<AdminKompanije, Long> {
	
}
