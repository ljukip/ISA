package com.booking.application.service.vozila;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.repository.vozila.VoziloRepository;

@Service
public class VoziloService {

	@Autowired
	private VoziloRepository voziloRepository;
	
	@Autowired
	private GarazaService garazaService;

	public List<Vozilo> vratiVozilaGaraza(Long kompanijaId, Long garazaId) {
		Garaza garaza = this.garazaService.vratiGarazuKompanije(kompanijaId, garazaId);
		return garaza.getVozila();
	}

	private Vozilo vratiJednoVozilo(Long voziloId) {
		Optional<Vozilo> vozilo = this.voziloRepository.findById(voziloId);
		if(vozilo.isPresent()) {
			return vozilo.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Vozilo vratiVoziloGaraze(Long kompanijaId, Long garazaId, Long voziloId) {
		Garaza garaza = this.garazaService.vratiGarazuKompanije(kompanijaId, garazaId);
		Vozilo vozilo = this.vratiJednoVozilo(voziloId);
		if(vozilo.getGaraza().equals(garaza)) {
			return vozilo;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	public Vozilo kreiraj(Vozilo vozilo, Long kompanijaId, Long garazaId) {
		Garaza garaza = this.garazaService.vratiGarazuKompanije(kompanijaId, garazaId);
		vozilo.setGaraza(garaza);
		Vozilo kreiranoVozilo = this.voziloRepository.save(vozilo);
		return kreiranoVozilo;
	}

	public Vozilo azuriraj(Vozilo vozilo, Long kompanijaId, Long garazaId) {
		Vozilo staroVozilo = this.vratiVoziloGaraze(kompanijaId, garazaId, vozilo.getId());
		if(!this.dozvoljenaIzmena(staroVozilo)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		staroVozilo.prekopiraj(vozilo);
		this.voziloRepository.save(staroVozilo);
		return staroVozilo;
	}

	public void obrisi(Long kompanijaId, Long garazaId, Long voziloId) {
		Vozilo vozilo = this.vratiVoziloGaraze(kompanijaId, garazaId, voziloId);
		if(this.dozvoljenaIzmena(vozilo)) {
			this.voziloRepository.delete(vozilo);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	private boolean dozvoljenaIzmena(Vozilo vozilo) {
		return vozilo.getZakupi().isEmpty();
	}
	
}
