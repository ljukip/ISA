package com.booking.application.repository.korisnici;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.korisnici.AdminSistema;

@Repository
public interface AdminSistemaRepository extends JpaRepository<AdminSistema, Long> {

	Optional<AdminSistema> findByEmail(String mejl);

}
