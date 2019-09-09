package com.booking.application.repository.opsti;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.opsti.Adresa;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long> {

	List<Adresa> findByGradEquals(String grad);
	
}
