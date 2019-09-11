package com.booking.application.service.hotel;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.hotel.CenovnikSobe;
import com.booking.application.model.hotel.KomparatorZakupaPoDatumu;
import com.booking.application.model.hotel.Soba;
import com.booking.application.repository.hotel.CenovnikSobeRepository;
import com.booking.application.utils.VremeDatumUtils;

@Service
public class CenovnikSobeService {

	@Autowired
	private CenovnikSobeRepository cenovnikSobeRepository;
	
	@Autowired
	private SobaService sobaService;
	
	public List<CenovnikSobe> vratiCenovnikeSobe(Long sobaId, Long hotelId) {
		Soba soba = this.sobaService.vratiSobuHotela(hotelId, sobaId);
		return soba.getCenovnici();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private CenovnikSobe vratiCenovnik(Long cenovnikId) {
		Optional<CenovnikSobe> cenovnik = this.cenovnikSobeRepository.findById(cenovnikId);
		if(cenovnik.isPresent()) {
			return cenovnik.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public CenovnikSobe vratiCenovnikSobe(Long hotelId, Long sobaId, Long cenovnikId) {
		CenovnikSobe cenovnik = this.vratiCenovnik(cenovnikId);
		if(cenovnik.getSoba().getId().equals(sobaId)) {
			return cenovnik;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public CenovnikSobe kreiraj(CenovnikSobe noviCenovnik, Long hotelId, Long sobaId) {
		Soba soba = this.sobaService.vratiSobuHotela(hotelId, sobaId);
		noviCenovnik.setSoba(soba);
		CenovnikSobe kreiraniCenovnik = this.cenovnikSobeRepository.save(noviCenovnik);
		return kreiraniCenovnik;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public CenovnikSobe azuriraj(CenovnikSobe noviCenovnik, Long hotelId, Long sobaId) {
		CenovnikSobe cenovnik = this.vratiCenovnikSobe(hotelId, sobaId, noviCenovnik.getId());
		if(!this.dozvoljenaIzmena(cenovnik)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		cenovnik.prekopiraj(noviCenovnik);
		this.cenovnikSobeRepository.save(cenovnik);
		return cenovnik;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long hotelId, Long sobaId, Long cenovnikId) {
		CenovnikSobe cenovnik = this.vratiCenovnikSobe(hotelId, sobaId, cenovnikId);
		if(this.dozvoljenaIzmena(cenovnik)) {
			this.cenovnikSobeRepository.delete(cenovnik);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean dozvoljenaIzmena(CenovnikSobe cenovnik) {
		return cenovnik.getSoba().getZakupi().isEmpty();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public double izracunajCenu(Soba soba, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		if(soba.getCenovnici().isEmpty()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		long brojDana = VremeDatumUtils.razlikaUDanima(pocetniDatum, krajnjiDatum);
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
			return 1000;
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean datumPripadaCenovniku(LocalDate datum, CenovnikSobe cenovnik) {
		return cenovnik.getPocetniDatum().isBefore(datum) && cenovnik.getKrajnjiDatum().isAfter(datum);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private LocalDate dodajJedanDan(LocalDate datum) {
		return datum.plusDays(1);
	}
	
}
