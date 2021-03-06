package com.booking.application.service.avionskakompanija;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.avionskakompanija.KategorijaPrtljaga;
import com.booking.application.repository.avionskakompanija.KategorijaPrtljagaRepository;

@Service
public class KategorijaPrtljagaService {

	@Autowired
	private KategorijaPrtljagaRepository kategorijaPrtljagaRepository;
	
	@Autowired
	private AvionskaKompanijaService avionskaKompanijaService;

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<KategorijaPrtljaga> vratiKategorijeKompanije(Long kompanijaId) {
		AvionskaKompanija kompanija = this.avionskaKompanijaService.vratiJednu(kompanijaId);
		return kompanija.getKategorijePrtljaga();
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KategorijaPrtljaga vratiJednu(Long kategorijaId) {
		Optional<KategorijaPrtljaga> kategorija = this.kategorijaPrtljagaRepository.findById(kategorijaId);
		if(kategorija.isPresent()) {
			return kategorija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KategorijaPrtljaga vratiKategorijuKompanije(Long kompanijaId, Long kategorijaId) {
		AvionskaKompanija kompanija = this.avionskaKompanijaService.vratiJednu(kompanijaId);
		KategorijaPrtljaga kategorija = this.vratiJednu(kategorijaId);
		if(kategorija.getAvionskaKompanija().equals(kompanija)) {
			return kategorija;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KategorijaPrtljaga kreiraj(KategorijaPrtljaga kategorijaPrtljaga, Long kompanijaId) {
		AvionskaKompanija kompanija = this.avionskaKompanijaService.vratiJednu(kompanijaId);
		kategorijaPrtljaga.setAvionskaKompanija(kompanija);
		KategorijaPrtljaga kreirana = this.kategorijaPrtljagaRepository.save(kategorijaPrtljaga);
		return kreirana;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KategorijaPrtljaga azuriraj(KategorijaPrtljaga novaKategorija, Long kompanijaId) {
		KategorijaPrtljaga staraKategorija = this.vratiKategorijuKompanije(kompanijaId, novaKategorija.getId());
		if(!this.dozvoljenaIzmena(staraKategorija)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		staraKategorija.prekopiraj(novaKategorija);
		this.kategorijaPrtljagaRepository.save(staraKategorija);
		return staraKategorija;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean dozvoljenaIzmena(KategorijaPrtljaga kategorija) {
		return kategorija.getSedista().isEmpty();
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long kompanijaId, Long kategorijaId) {
		KategorijaPrtljaga kategorija = this.vratiKategorijuKompanije(kompanijaId, kategorijaId);
		if(!this.dozvoljenaIzmena(kategorija)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		this.kategorijaPrtljagaRepository.delete(kategorija);
	}
	
}
