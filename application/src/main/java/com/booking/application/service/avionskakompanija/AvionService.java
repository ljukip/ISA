package com.booking.application.service.avionskakompanija;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.avionskakompanija.Avion;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.repository.avionskakompanija.AvionRepository;

@Service
public class AvionService {

	@Autowired
	private AvionRepository avionRepository;
	
	@Autowired
	private AvionskaKompanijaService avionskaKompanijaService;
	
	public List<Avion> vratiAvioneKompanije(Long kompanijaId) {
		AvionskaKompanija avionskaKompanija = this.avionskaKompanijaService.vratiJednu(kompanijaId);
		return avionskaKompanija.getAvioni();
	}
	
	private Avion vratiJedan(Long avionId) {
		Optional<Avion> avion = this.avionRepository.findById(avionId);
		if(avion.isPresent()) {
			return avion.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Avion vratiAvionKompanije(Long kompanijaId, Long avionId) {
		AvionskaKompanija avionskaKompanija = this.avionskaKompanijaService.vratiJednu(kompanijaId);
		Avion avion = this.vratiJedan(avionId);
		if(avion.getAvionskaKompanija().equals(avionskaKompanija)) {
			return avion;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	public Avion kreiraj(Long kompanijaId, Avion avion) {
		AvionskaKompanija avionskaKompanija = this.avionskaKompanijaService.vratiJednu(kompanijaId);
		avion.setAvionskaKompanija(avionskaKompanija);
		Avion kreirani = this.avionRepository.save(avion);
		return kreirani;
	}
	
	public Avion azuriraj(Long kompanijaId, Avion novi) {
		Avion stari = this.vratiAvionKompanije(kompanijaId, novi.getId());
		stari.prekopiraj(novi);
		this.avionRepository.save(stari);
		return stari;
	}
	
	private boolean dozvoljenaIzmena(Avion avion) {
		return true;
	}
	
	public void obrisi(Long kompanijaId, Long avionId) {
		Avion avion = this.vratiAvionKompanije(kompanijaId, avionId);
		if(!this.dozvoljenaIzmena(avion)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		this.avionRepository.delete(avion);
	}
	
}
