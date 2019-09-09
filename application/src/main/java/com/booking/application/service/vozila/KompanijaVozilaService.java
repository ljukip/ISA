package com.booking.application.service.vozila;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.opsti.Adresa;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.repository.vozila.KompanijaVozilaRepository;
import com.booking.application.service.opsti.AdresaService;

@Service
public class KompanijaVozilaService {

	@Autowired
	private KompanijaVozilaRepository kompanijaVozilaRepository;

	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	public List<KompanijaVozila> vratiSve(Pageable page) {
		
		Page<KompanijaVozila> pageOfCompany = this.kompanijaVozilaRepository.findAll(page);
		List<KompanijaVozila> listOfCompany = new ArrayList<KompanijaVozila>();
		pageOfCompany.forEach(item -> {
			listOfCompany.add(item);
		});
		
		return listOfCompany;
	}

	public KompanijaVozila vratiJednu(Long id) {
		Optional<KompanijaVozila> kompanija = this.kompanijaVozilaRepository.findById(id);
		if(kompanija.isPresent()) {
			return kompanija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public KompanijaVozila kreiraj(KompanijaVozila kompanijaVozila) {
		KompanijaVozila kreiranaKompanija = this.kompanijaVozilaRepository.save(kompanijaVozila);
		return kreiranaKompanija;
	}

	public KompanijaVozila azuriraj(KompanijaVozila novaKompanija) {
		KompanijaVozila staraKompanija = this.vratiJednu(novaKompanija.getId());
		staraKompanija.prekopiraj(novaKompanija);
		this.kompanijaVozilaRepository.save(staraKompanija);
		return staraKompanija;
	}

	public void obrisi(Long id) {
		KompanijaVozila kompanija = this.vratiJednu(id);
		if(this.dozvoljenaIzmena(kompanija)) {
			this.kompanijaVozilaRepository.delete(kompanija);
			//TODO: pronadji adrese koje imaju setovate taj id za kompanije servis i setuj ih na null
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	private boolean dozvoljenaIzmena(KompanijaVozila kompanija) {
		for(Garaza garaza : kompanija.getGaraze()) {
			for(Vozilo vozilo : garaza.getVozila()) {
				if(!vozilo.getZakupi().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}
	
	public KompanijaVozila postaviAdresu(Long kompanijaId, Long adresaId) {
		KompanijaVozila kompanijaVozila = this.vratiJednu(kompanijaId);
		if(!this.dozvoljenaIzmena(kompanijaVozila)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Adresa novaAdresa = this.adresaService.vratiJednu(adresaId);
		if(!this.adresaService.dozvoljenaIzmena(novaAdresa)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Adresa staraAdresa = kompanijaVozila.getAdresa();
		staraAdresa.setKompanijaVozila(null);
		novaAdresa.setKompanijaVozila(kompanijaVozila);
		kompanijaVozila.setAdresa(novaAdresa);
		this.adresaRepository.save(staraAdresa);
		this.adresaRepository.save(novaAdresa);
		this.kompanijaVozilaRepository.save(kompanijaVozila);
		return kompanijaVozila;
	}
	
}
