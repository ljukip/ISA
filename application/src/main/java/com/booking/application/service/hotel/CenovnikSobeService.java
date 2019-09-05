package com.booking.application.service.hotel;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.hotel.CenovnikSobe;
import com.booking.application.model.hotel.KomparatorZakupaPoDatumu;
import com.booking.application.model.hotel.Soba;
import com.booking.application.repository.hotel.CenovnikSobeRepository;
import com.booking.application.service.vremedatum.VremeDatumUtils;

@Service
public class CenovnikSobeService {

	@Autowired
	private CenovnikSobeRepository cenovnikSobeRepository;
	
	@Autowired
	private SobaService sobaService;
	
	@Autowired
	private VremeDatumUtils datumiUtils;
	
	public List<CenovnikSobe> vratiCenovnikeSobe(Long sobaId, Long hotelId) {
		Soba soba = this.sobaService.vratiSobuHotela(hotelId, sobaId);
		return soba.getCenovnici();
	}
	
	private CenovnikSobe vratiCenovnik(Long cenovnikId) {
		Optional<CenovnikSobe> cenovnik = this.cenovnikSobeRepository.findById(cenovnikId);
		if(cenovnik.isPresent()) {
			return cenovnik.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public CenovnikSobe vratiCenovnikSobe(Long hotelId, Long sobaId, Long cenovnikId) {
		Soba soba = this.sobaService.vratiSobuHotela(hotelId, sobaId);
		CenovnikSobe cenovnik = this.vratiCenovnik(sobaId);
		if(soba.getCenovnici().contains(cenovnik)) {
			return cenovnik;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public CenovnikSobe kreiraj(CenovnikSobe noviCenovnik, Long hotelId, Long sobaId) {
		Soba soba = this.sobaService.vratiSobuHotela(hotelId, sobaId);
		if(!this.dozvoljenoDodavanje(noviCenovnik, this.vratiCenovnikeSobe(sobaId, hotelId))) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		noviCenovnik.setSoba(soba);
		CenovnikSobe kreiraniCenovnik = this.cenovnikSobeRepository.save(noviCenovnik);
		return kreiraniCenovnik;
	}
	
	public CenovnikSobe azuriraj(CenovnikSobe noviCenovnik, Long hotelId, Long sobaId) {
		CenovnikSobe cenovnik = this.vratiCenovnikSobe(hotelId, sobaId, noviCenovnik.getId());
		if(!this.dozvoljenaIzmena(cenovnik)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		cenovnik.prekopiraj(noviCenovnik);
		this.cenovnikSobeRepository.save(cenovnik);
		return cenovnik;
	}
	
	public void obrisi(Long hotelId, Long sobaId, Long cenovnikId) {
		CenovnikSobe cenovnik = this.vratiCenovnikSobe(hotelId, sobaId, cenovnikId);
		if(this.dozvoljenaIzmena(cenovnik)) {
			this.cenovnikSobeRepository.delete(cenovnik);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	private boolean dozvoljenaIzmena(CenovnikSobe cenovnik) {
		return cenovnik.getSoba().getZakupi().isEmpty();
	}
	
	private boolean dozvoljenoDodavanje(CenovnikSobe noviCenovnik, List<CenovnikSobe> cenovnici) {
		/*for(CenovnikSobe cenovnik : cenovnici) {
			if(cenovnik.getKrajnjiDatum().isAfter(noviCenovnik.getPocetniDatum())) return false;
			if(cenovnik.getPocetniDatum().isAfter(noviCenovnik.getKrajnjiDatum())) return false;
		}*/
		return true;
	}
	
	// TODO : REIMPLEMENT
	public double izracunajCenu(Soba soba, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		if(soba.getCenovnici().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		long brojDana = this.datumiUtils.razlikaUDanima(pocetniDatum, krajnjiDatum);
		double cena = 0;
		List<CenovnikSobe> cenovnici = soba.getCenovnici();
		Collections.sort(cenovnici, new KomparatorZakupaPoDatumu());
		for(CenovnikSobe cenovnik : cenovnici) {
			while(this.datumPripadaCenovniku(pocetniDatum, cenovnik) && brojDana > 0 && krajnjiDatum.isAfter(pocetniDatum)) {
				cena += cenovnik.getCena();
				brojDana--;
				pocetniDatum = this.dodajJedanDan(pocetniDatum);
			}
		}
		if(cena != 0) {
			return cena;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	private boolean datumPripadaCenovniku(LocalDate datum, CenovnikSobe cenovnik) {
		return cenovnik.getPocetniDatum().isBefore(datum) && cenovnik.getKrajnjiDatum().isAfter(datum);
	}
	
	private LocalDate dodajJedanDan(LocalDate datum) {
		return datum.plusDays(1);
	}
	
}
