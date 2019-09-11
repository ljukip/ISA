package com.booking.application.repository.korisnici;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.korisnici.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {

	Optional<Korisnik> findByEmail(String mejl);

}
