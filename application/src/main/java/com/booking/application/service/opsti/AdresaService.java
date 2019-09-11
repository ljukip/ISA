package com.booking.application.service.opsti;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.opsti.Adresa;
import com.booking.application.repository.opsti.AdresaRepository;

@Service
public class AdresaService {

	@Autowired
	private AdresaRepository adresaRepository;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Adresa> vratiSve() {
		return this.adresaRepository.findAll();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Adresa vratiJednu(Long id) {
		Optional<Adresa> adresa = this.adresaRepository.findById(id);
		if(adresa.isPresent()) {
			return adresa.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Adresa kreiraj(Adresa novaAdresa) {
		Adresa kreiranaAdresa = this.adresaRepository.save(novaAdresa);
		return kreiranaAdresa;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long id) {
		Adresa adresa = this.vratiJednu(id);
		if(this.dozvoljenaIzmena(adresa)) {
			this.adresaRepository.delete(adresa);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean dozvoljenaIzmena(Adresa adresa) {
		if(adresa.getAvionskaKompanija() != null) return false;
		if(adresa.getGaraza() != null) return false;
		if(adresa.getHotel() != null) return false;
		if(adresa.getKompanijaVozila() != null) return false;
		return true;
	}
	
}
