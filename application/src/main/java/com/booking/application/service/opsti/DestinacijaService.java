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

import com.booking.application.model.avionskakompanija.Let;
import com.booking.application.model.hotel.ZakupSobe;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.model.opsti.Destinacija;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.vozila.ZakupVozila;
import com.booking.application.repository.opsti.DestinacijaRepository;

@Service
public class DestinacijaService {

	@Autowired
	private DestinacijaRepository destinacijaRepository;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Destinacija vratiJednu(Long id) {
		Optional<Destinacija> destinacija = this.destinacijaRepository.findById(id);
		if(destinacija.isPresent()) {
			return destinacija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Let> vratiLetoveNaDestinaciju(Long id) {
		Destinacija destinacija = this.vratiJednu(id);
		return destinacija.getLetoviU();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Let> vratiLetoveIzDestinacije(Long id) {
		Destinacija destinacija = this.vratiJednu(id);
		return destinacija.getLetoviIz();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean adresaJeUDestinaciji(Adresa adresa, Destinacija destinacija) {
		if(!adresa.getZemlja().equalsIgnoreCase(destinacija.getZemlja())) return false;
		if(!adresa.getGrad().equalsIgnoreCase(destinacija.getGrad())) return false;
		return true;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean poklapaSeDestinacija(Rezervacija rezervacija, ZakupVozila zakup) {
		Destinacija destinacija = rezervacija.getAvionskaKarta().getLet().getOdrediste();
		Adresa adresa = zakup.getVozilo().getGaraza().getAdresa();
		return this.adresaJeUDestinaciji(adresa, destinacija);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean poklapaSeDestinacija(Rezervacija rezervacija, ZakupSobe zakup) {
		Destinacija destinacija = rezervacija.getAvionskaKarta().getLet().getOdrediste();
		Adresa adresa = zakup.getSoba().getHotel().getAdresa();
		return this.adresaJeUDestinaciji(adresa, destinacija);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Destinacija> vratiSve() {
		return this.destinacijaRepository.findAll();
	}
	
}
