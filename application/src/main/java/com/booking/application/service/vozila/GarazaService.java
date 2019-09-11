package com.booking.application.service.vozila;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.repository.vozila.GarazaRepository;
import com.booking.application.repository.vozila.VoziloRepository;
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
	
	@Autowired
	private VoziloRepository voziloRepository;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Garaza> vratiGarazeKompanije(Long kompanijaId) {
		KompanijaVozila kompanija = this.kompanijaVozilaService.vratiJednu(kompanijaId);
		return kompanija.getGaraze();
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Garaza vratiJednu(Long garazaId) {
		Optional<Garaza> garaza = this.garazaRepository.findById(garazaId);
		if(garaza.isPresent()) {
			return garaza.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Garaza vratiGarazuKompanije(Long kompanijaId, Long garazaId) {
		KompanijaVozila kompanija = this.kompanijaVozilaService.vratiJednu(kompanijaId);
		Garaza garaza = this.vratiJednu(garazaId);
		if(garaza.getKompanija().equals(kompanija)) {
			return garaza;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Garaza kreiraj(Garaza garaza, AdresaDTO adresaDTO, Long kompanijaId) {
		Adresa adresa = this.adresaService.kreiraj(new Adresa(adresaDTO));
		KompanijaVozila kompanija = this.kompanijaVozilaService.vratiJednu(kompanijaId);
		garaza.setAdresa(adresa);
		garaza.setKompanija(kompanija);
		Garaza kreiranaGaraza = this.garazaRepository.save(garaza);
		adresa.setGaraza(kreiranaGaraza);
		this.adresaRepository.save(adresa);
		return kreiranaGaraza;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long kompanijaId, Long garazaId) {
		Garaza garaza = this.vratiGarazuKompanije(kompanijaId, garazaId);
		if(this.dozvoljenaIzmena(garaza)) {
			this.adresaRepository.delete(garaza.getAdresa());
			this.voziloRepository.deleteAll(garaza.getVozila());
			this.garazaRepository.delete(garaza);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean dozvoljenaIzmena(Garaza garaza) {
		for(Vozilo vozilo : garaza.getVozila()) {
			if(!vozilo.getZakupi().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Garaza azuriraj(Garaza garaza, AdresaDTO adresaDTO, Long kompanijaId) {
		Garaza staraGaraza = this.vratiGarazuKompanije(kompanijaId, garaza.getId());
		staraGaraza.getAdresa().prekopiraj(adresaDTO);
		this.adresaRepository.save(staraGaraza.getAdresa());
		return staraGaraza;
	}

}
