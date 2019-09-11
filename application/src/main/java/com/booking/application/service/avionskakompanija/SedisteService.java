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

import com.booking.application.dto.avionskakompanija.SedisteDTO;
import com.booking.application.model.avionskakompanija.KlasaSedista;
import com.booking.application.model.avionskakompanija.Let;
import com.booking.application.model.avionskakompanija.Sediste;
import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.repository.avionskakompanija.LetRepository;
import com.booking.application.repository.avionskakompanija.SedisteRepository;
import com.booking.application.service.korisnici.KorisnikService;

@Service
public class SedisteService {

	@Autowired
	private SedisteRepository sedisteRepository;
	
	@Autowired
	private LetService letService;
	
	@Autowired
	private KorisnikService korisnikService;

	@Autowired
	private LetRepository letRepository;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Sediste nadjiJedno(Long id) {
		Optional<Sediste> sediste = this.sedisteRepository.findById(id);
		if(sediste.isPresent()) {
			return sediste.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void izgenerisiSedista(Let let) {
		for(int i = 1; i <= Sediste.PODRAZUMEVANI_BROJ_SEDISTA; i++) {
			Sediste sediste = this.kreirajSediste(let);
			this.sedisteRepository.save(sediste);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	private Sediste kreirajSediste(Let let) {
		Sediste sediste = new Sediste();
		sediste.setLet(let);
		sediste.setCena(let.getCena());
		sediste.setKlasa(KlasaSedista.EKONOMSKA);
		return sediste;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Sediste> vratiSedistaLeta(Long letId) {
		Let let = this.letService.vratiLet(letId);
		return let.getSedista();
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Sediste> dodajSediste(Long letId) {
		Let let = this.letService.vratiLet(letId);
		Sediste sediste = this.kreirajSediste(let);
		this.sedisteRepository.save(sediste);
		return let.getSedista();
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public List<Sediste> izmeniSediste(SedisteDTO sedisteDTO, Long sedisteId) {
		Sediste sediste = this.nadjiJedno(sedisteId);try {
			Korisnik prijatelj = this.korisnikService.pronadjiPoMejlu(sedisteDTO.getEmail());
			Korisnik vlasnik = sediste.getAvionskaKarta().getRezervacija().getVlasnik();
			if(!this.korisnikService.vecSuPrijatelji(prijatelj, vlasnik)) {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}
			sediste.setImePutnika(prijatelj.getIme());
			sediste.setPrezimePutnika(prijatelj.getPrezime());
			
		} catch(ResponseStatusException e) {
			sediste.setImePutnika(sedisteDTO.getImePutnika());
			sediste.setPrezimePutnika(sedisteDTO.getPrezimePutnika());
		}
		sediste.setBrojPasosa(sedisteDTO.getBrojPasosa());
		sediste.setCena(sedisteDTO.getCena());
		sediste.setKlasa(sedisteDTO.getKlasa());
		this.sedisteRepository.save(sediste);
		return sediste.getLet().getSedista();
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Sediste> obrisiSediste(Long letId) {
		Let let = this.letService.vratiLet(letId);
		for(Sediste sediste : let.getSedista()) {
			if(sediste.getAvionskaKarta() == null) {
				this.sedisteRepository.delete(sediste);
				return this.vratiSedistaLeta(letId);
			}
		}
		throw new ResponseStatusException(HttpStatus.CONFLICT);
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void potvrdiSediste(Long sedisteId) {
		Sediste sediste = this.nadjiJedno(sedisteId);
		sediste.setPotvrdjeno(true);
		this.sedisteRepository.save(sediste);
	}
	
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void otkaziSediste(Long sedisteId) {
		Sediste sediste = this.nadjiJedno(sedisteId);
		Let let = sediste.getLet();
		let.setCena(let.getCena() - sediste.getCena());
		this.letRepository.save(let);
		sediste.setAvionskaKarta(null);
		sediste.setBrojPasosa(null);
		sediste.setImePutnika(null);
		sediste.setPrezimePutnika(null);
		this.sedisteRepository.save(sediste);
	}
	
}
