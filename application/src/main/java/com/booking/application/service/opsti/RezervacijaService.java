package com.booking.application.service.opsti;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.avionskakompanija.AvionskaKarta;
import com.booking.application.model.hotel.ZakupSobe;
import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.vozila.ZakupVozila;
import com.booking.application.repository.hotel.ZakupSobaRepository;
import com.booking.application.repository.opsti.RezervacijaRepository;
import com.booking.application.repository.vozila.ZakupVozilaRepository;
import com.booking.application.service.hotel.ZakupSobaService;
import com.booking.application.service.korisnici.KorisnikService;
import com.booking.application.service.vozila.ZakupVozilaService;

@Service
public class RezervacijaService {

	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Autowired
	private ZakupVozilaService zakupVozilaService;
	
	@Autowired
	private ZakupSobaService zakupSobaService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private ZakupVozilaRepository zakupVozilaRepository;
	
	@Autowired
	private ZakupSobaRepository zakupSobaRepository;
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Rezervacija sacuvajRezervaciju(Rezervacija rezervacija) {
		return this.rezervacijaRepository.save(rezervacija);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Rezervacija vratiJednu(Long rezervacijaId) {
		Optional<Rezervacija> rezervacija = this.rezervacijaRepository.findById(rezervacijaId);
		if(rezervacija.isPresent()) {
			return rezervacija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public Rezervacija dodajBrzuRezervacijuVozila(Long rezervacijaId, Long zakupVozilaId) {
		ZakupVozila zakup = this.zakupVozilaService.vratiBrziZakupVozila(zakupVozilaId);
		Rezervacija rezervacija = this.vratiJednu(rezervacijaId);
		/*if(destinacijaService.poklapaSeDestinacija(rezervacija, zakup)) {
			rezervacija.setZakupVozila(zakup);
			rezervacija.setKompletirana(true);
			return this.rezervacijaRepository.save(rezervacija);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}*/
		rezervacija.setZakupVozila(zakup);
		rezervacija.setKompletirana(true);
		this.rezervacijaRepository.save(rezervacija);
		zakup.setRezervacija(rezervacija);
		this.zakupVozilaRepository.save(zakup);
		return this.rezervacijaRepository.save(rezervacija);
	}
	
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public Rezervacija dodajBrzuRezervacijuSobe(Long rezervacijaId, Long zakupSoba) {
		ZakupSobe zakup = this.zakupSobaService.vratiBrziZakupSoba(zakupSoba);
		Rezervacija rezervacija = this.vratiJednu(rezervacijaId);
		/*if(destinacijaService.poklapaSeDestinacija(rezervacija, zakup)) {
			rezervacija.setZakupSoba(zakup);
			rezervacija.setKompletirana(true);
			return this.rezervacijaRepository.save(rezervacija);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}*/
		rezervacija.setZakupSoba(zakup);
		rezervacija.setKompletirana(true);
		this.rezervacijaRepository.save(rezervacija);
		zakup.setRezervacija(rezervacija);
		this.zakupSobaRepository.save(zakup);
		return this.rezervacijaRepository.save(rezervacija);
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public Rezervacija kompletirajRezervaciju(Long id) {
		Rezervacija rezervacija = this.vratiJednu(id);
		rezervacija.setKompletirana(true);
		return this.rezervacijaRepository.save(rezervacija);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<AvionskaKarta> preuzmiKarteKorisnika(Long id) {
		Korisnik korisnik = this.korisnikService.vratiJednog(id);
		List<AvionskaKarta> rezultat = new ArrayList<AvionskaKarta>();
		for(Rezervacija rezervacija : korisnik.getRezervacije()) {
			rezultat.add(rezervacija.getAvionskaKarta());
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<ZakupSobe> preuzmiZakupeSoba(Long id) {
		Korisnik korisnik = this.korisnikService.vratiJednog(id);
		List<ZakupSobe> rezultat = new ArrayList<ZakupSobe>();
		for(Rezervacija rezervacija : korisnik.getRezervacije()) {
			if(rezervacija.getZakupSoba() != null) {
				rezultat.add(rezervacija.getZakupSoba());
			}
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<ZakupVozila> preuzmiZakupeVozila(Long id) {
		Korisnik korisnik = this.korisnikService.vratiJednog(id);
		List<ZakupVozila> rezultat = new ArrayList<ZakupVozila>();
		for(Rezervacija rezervacija : korisnik.getRezervacije()) {
			if(rezervacija.getZakupVozila() != null) {
				rezultat.add(rezervacija.getZakupVozila());
			}
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Rezervacija> rezervacijeKorisnika(Long id) {
		Korisnik korisnik = this.korisnikService.vratiJednog(id);
		return korisnik.getRezervacije();
	}
	
}
