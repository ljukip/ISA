package com.booking.application.service.avionskakompanija;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.repository.avionskakompanija.AvionskaKompanijaRepository;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.service.opsti.AdresaService;

@Service
public class AvionskaKompanijaService {

	@Autowired
	private AvionskaKompanijaRepository avionskaKompanijaRepository;
	
	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	public List<AvionskaKompanija> vratiSve() {
		return this.avionskaKompanijaRepository.findAll();
	}
	
	public AvionskaKompanija vratiJednu(Long avionskaKompanijaId) {
		Optional<AvionskaKompanija> avionskaKompanija = this.avionskaKompanijaRepository.findById(avionskaKompanijaId);
		if(avionskaKompanija.isPresent()) {
			return avionskaKompanija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public AvionskaKompanija kreiraj(AvionskaKompanija avionskaKompanija) {
		AvionskaKompanija kreirana = this.avionskaKompanijaRepository.save(avionskaKompanija);
		return kreirana;
	}

	public AvionskaKompanija azuriraj(AvionskaKompanija novaKompanija) {
		AvionskaKompanija staraKompanija = this.vratiJednu(novaKompanija.getId());
		staraKompanija.prekopiraj(novaKompanija);
		this.avionskaKompanijaRepository.save(staraKompanija);
		return staraKompanija;
	}

	public void obrisi(Long kompanijaId) {
		AvionskaKompanija avionskaKompanija = this.vratiJednu(kompanijaId);
		this.avionskaKompanijaRepository.delete(avionskaKompanija);
	}

	private boolean dozvoljenaIzmena(AvionskaKompanija hotel) {
		return true;
	}
	
	public AvionskaKompanija postaviAdresu(Long kompanijaId, Long adresaId) {
		AvionskaKompanija avionskaKompanija = this.vratiJednu(kompanijaId);
		if(!this.dozvoljenaIzmena(avionskaKompanija)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Adresa novaAdresa = this.adresaService.vratiJednu(adresaId);
		if(!this.adresaService.dozvoljenaIzmena(novaAdresa)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Adresa staraAdresa = avionskaKompanija.getAdresa();
		staraAdresa.setAvionskaKompanija(null);
		novaAdresa.setAvionskaKompanija(avionskaKompanija);
		avionskaKompanija.setAdresa(novaAdresa);
		this.adresaRepository.save(staraAdresa);
		this.adresaRepository.save(novaAdresa);
		this.avionskaKompanijaRepository.save(avionskaKompanija);
		return avionskaKompanija;
	}
	
}
