package com.booking.application.service.vozila;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.opsti.Adresa;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.repository.vozila.GarazaRepository;
import com.booking.application.service.opsti.AdresaService;

@Service
public class GarazaService {

	@Autowired
	private GarazaRepository garazaRepository;

	@Autowired
	private KompanijaVozilaService kompanijaVozilaService;

	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	public List<Garaza> vratiGarazeKompanije(Long kompanijaId) {
		KompanijaVozila kompanija = this.kompanijaVozilaService.vratiJednu(kompanijaId);
		return kompanija.getGaraze();
	}

	private Garaza vratiJednu(Long garazaId) {
		Optional<Garaza> garaza = this.garazaRepository.findById(garazaId);
		if(garaza.isPresent()) {
			return garaza.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public Garaza vratiGarazuKompanije(Long kompanijaId, Long garazaId) {
		KompanijaVozila kompanija = this.kompanijaVozilaService.vratiJednu(kompanijaId);
		Garaza garaza = this.vratiJednu(garazaId);
		if(garaza.getKompanija().equals(kompanija)) {
			return garaza;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	public Garaza kreiraj(Garaza garaza, Long kompanijaId) {
		KompanijaVozila kompanija = this.kompanijaVozilaService.vratiJednu(kompanijaId);
		garaza.setKompanija(kompanija);
		Garaza kreiranaGaraza = this.garazaRepository.save(garaza);
		return kreiranaGaraza;
	}

	public void obrisi(Long kompanijaId, Long garazaId) {
		Garaza garaza = this.vratiGarazuKompanije(kompanijaId, garazaId);
		if(this.dozvoljenaIzmena(garaza)) {
			this.garazaRepository.delete(garaza);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	private boolean dozvoljenaIzmena(Garaza garaza) {
		for(Vozilo vozilo : garaza.getVozila()) {
			if(!vozilo.getZakupi().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	public Garaza postaviAdresu(Long kompanijaId, Long garazaId, Long adresaId) {
		Garaza garaza = this.vratiJednu(garazaId);
		if(!this.dozvoljenaIzmena(garaza)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Adresa novaAdresa = this.adresaService.vratiJednu(adresaId);
		if(!this.adresaService.dozvoljenaIzmena(novaAdresa)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Adresa staraAdresa = garaza.getAdresa();
		staraAdresa.setGaraza(null);
		novaAdresa.setGaraza(garaza);
		garaza.setAdresa(novaAdresa);
		this.adresaRepository.save(staraAdresa);
		this.adresaRepository.save(novaAdresa);
		this.garazaRepository.save(garaza);
		return garaza;
	}

}
