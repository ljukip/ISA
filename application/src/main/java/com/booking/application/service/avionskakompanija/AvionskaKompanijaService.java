package com.booking.application.service.avionskakompanija;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.avionskakompanija.AvionskaKarta;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.avionskakompanija.Let;
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
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<AvionskaKompanija> vratiSve(Pageable page) {
		Page<AvionskaKompanija> pageOfAviokompanija = this.avionskaKompanijaRepository.findAll(page);
		List<AvionskaKompanija> listOfAviokompanija = new ArrayList<AvionskaKompanija>();
		pageOfAviokompanija.forEach(item -> {
			listOfAviokompanija.add(item);
		});
		
		return listOfAviokompanija;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public AvionskaKompanija vratiJednu(Long avionskaKompanijaId) {
		Optional<AvionskaKompanija> avionskaKompanija = this.avionskaKompanijaRepository.findById(avionskaKompanijaId);
		if(avionskaKompanija.isPresent()) {
			return avionskaKompanija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public AvionskaKompanija kreiraj(AvionskaKompanija avionskaKompanija, AdresaDTO adresaDTO) {
		Adresa adresa = this.adresaService.kreiraj(new Adresa(adresaDTO));
		avionskaKompanija.setAdresa(adresa);
		avionskaKompanija.setOcena(0.0);
		AvionskaKompanija kreirana = this.avionskaKompanijaRepository.save(avionskaKompanija);
		adresa.setAvionskaKompanija(kreirana);
		this.adresaRepository.save(adresa);
		return kreirana;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public AvionskaKompanija azuriraj(AvionskaKompanija novaKompanija, AdresaDTO adresaDTO) {
		AvionskaKompanija staraKompanija = this.vratiJednu(novaKompanija.getId());
		staraKompanija.prekopiraj(novaKompanija);
		this.avionskaKompanijaRepository.save(staraKompanija);
		staraKompanija.getAdresa().prekopiraj(adresaDTO);
		this.adresaRepository.save(staraKompanija.getAdresa());
		return staraKompanija;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long kompanijaId) {
		AvionskaKompanija avionskaKompanija = this.vratiJednu(kompanijaId);
		this.avionskaKompanijaRepository.delete(avionskaKompanija);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Double izracunajPrihod(Date pocetak, Date kraj, Long kompanijaId) {
		AvionskaKompanija kompanija = this.vratiJednu(kompanijaId);
		Double prihod = 0.0;
		for(Let let : kompanija.getLetovi()) {
			if(!(let.getVremePoletanja().after(pocetak) && let.getVremeSletanja().before(kraj))) continue;
			for(AvionskaKarta karta : let.getAvionskeKarte()) {
				prihod += karta.getCena();
			}
		}
		return prihod;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public HashMap<LocalDate, Integer> izracunajStatistiku(Date pocetak, Date kraj, Long kompanijaId) {
		// TODO : Implementiraj statistiku za avio kompaniju
		return null;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public AvionskaKompanija vratiNeku() {
		List<AvionskaKompanija> sve = this.avionskaKompanijaRepository.findAll();
		if(sve.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			return sve.get(0);
		}
	}
	
}
