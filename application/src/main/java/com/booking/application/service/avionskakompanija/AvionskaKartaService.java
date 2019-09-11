package com.booking.application.service.avionskakompanija;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.dto.avionskakompanija.SedisteDTO;
import com.booking.application.model.avionskakompanija.AvionskaKarta;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.avionskakompanija.Let;
import com.booking.application.model.avionskakompanija.Sediste;
import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;
import com.booking.application.repository.avionskakompanija.AvionskaKartaRepository;
import com.booking.application.repository.avionskakompanija.AvionskaKompanijaRepository;
import com.booking.application.repository.avionskakompanija.SedisteRepository;
import com.booking.application.repository.opsti.RezervacijaRepository;
import com.booking.application.service.korisnici.KorisnikService;

@Service
public class AvionskaKartaService {

	@Autowired
	private AvionskaKartaRepository avionskaKartaRepository;

	@Autowired
	private SedisteRepository sedisteRepository;
	
	@Autowired
	private SedisteService sedisteService;
	
	@Autowired
	private LetService letService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	@Autowired
	private AvionskaKompanijaRepository avionskaKompanijaRepository;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private AvionskaKarta vratiJednu(Long id) {
		Optional<AvionskaKarta> karta = this.avionskaKartaRepository.findById(id);
		if(karta.isPresent()) {
			return karta.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public Rezervacija rezervisi(AvionskaKartaDTO kartaDTO, Long letId, Long korisnikId) {
		Let let = this.letService.vratiLet(letId);
		List<Sediste> sedista = this.izvuciSedista(kartaDTO.getSedistaDTO());
		Korisnik korisnik = this.korisnikService.vratiJednog(korisnikId);
		AvionskaKarta karta = new AvionskaKarta();
		Rezervacija rezervacija = new Rezervacija();
		double cena = 0;
		for(Sediste sediste : sedista) {
			if(this.sedisteJeSlobodno(sediste)) {
				sediste.setAvionskaKarta(karta);
				cena += let.getCena();
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}
		}	
		karta.setTip(TipZakupa.REDOVAN);
		this.avionskaKartaRepository.save(karta);
		this.rezervacijaRepository.save(rezervacija);
		this.sedisteRepository.saveAll(sedista);
		karta.setCena(cena);
		karta.setLet(let);
		karta.setRezervacija(rezervacija);
		karta.setLet(let);
		this.avionskaKartaRepository.save(karta);
		rezervacija.setAvionskaKarta(karta);
		rezervacija.setKompletirana(false);
		rezervacija.setVlasnik(korisnik);
		Rezervacija kreirana = this.rezervacijaRepository.save(rezervacija);
		karta.setSedista(sedista);
		return kreirana;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean sedisteJeSlobodno(Sediste sediste) {
		return sediste.getAvionskaKarta() == null;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private List<Sediste> izvuciSedista(List<SedisteDTO> sedista) {
		List<Sediste> rezultat = new ArrayList<Sediste>();
		for(SedisteDTO sediste : sedista) {
			rezultat.add(this.sedisteService.nadjiJedno(sediste.getId()));
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<AvionskaKarta> vratiBrzeRezervacije() {
		List<AvionskaKarta> rezultat = new ArrayList<AvionskaKarta>();
		for(AvionskaKarta karta : this.avionskaKartaRepository.findAll()) {
			if(karta.getTip().equals(TipZakupa.BRZ) && karta.getRezervacija() == null) {
				rezultat.add(karta);
			}
		}
		return rezultat;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public AvionskaKarta oceniKartu(Long zakupId, int ocena) {
		AvionskaKarta zakup = this.vratiJednu(zakupId);
		if(zakup.getOcena() != 0 || zakup.getLet().getVremePoletanja().after(new Date())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			if(ocena <= 5 && ocena >= 1) {
				zakup.setOcena(ocena);
				azurirajProsecnuOcenu(zakup.getLet().getAvionskaKompanija());
				this.avionskaKartaRepository.save(zakup);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
		}
		return zakup;
	}

	private void azurirajProsecnuOcenu(AvionskaKompanija kompanija) {
		double ukupno = 0.0;
		int broj = 0;
		for(Let let : kompanija.getLetovi()) {
			for(AvionskaKarta karta : let.getAvionskeKarte()) {
				if(karta.getOcena() != 0) {
					broj++;
					ukupno += karta.getOcena();
				}
			}
		}
		kompanija.setOcena(ukupno / broj);
		this.avionskaKompanijaRepository.save(kompanija);
	}
	
}
