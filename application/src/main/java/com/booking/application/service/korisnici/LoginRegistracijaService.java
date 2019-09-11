package com.booking.application.service.korisnici;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.dto.korisnici.RegistracijaDTO;
import com.booking.application.model.korisnici.AdminKompanije;
import com.booking.application.model.korisnici.AdminSistema;
import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.repository.korisnici.AdminKompanijeRepository;
import com.booking.application.repository.korisnici.AdminSistemaRepository;
import com.booking.application.repository.korisnici.KorisnikRepository;
import com.booking.application.service.opsti.EmailService;

@Service
public class LoginRegistracijaService {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
	private AdminKompanijeRepository adminKompanijeRepository;
	
	@Autowired
	private AdminSistemaRepository adminSistemaRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KorisnikDTO login(String mejl, String lozinka) {
		Optional<Korisnik> korisnik = this.vratiKorisnika(mejl, lozinka);
		if(korisnik.isPresent()) return new KorisnikDTO(korisnik.get());
		Optional<AdminKompanije> adminKompanije = this.vratiAdminaKompanije(mejl, lozinka);
		if(adminKompanije.isPresent()) return new KorisnikDTO(adminKompanije.get());
		Optional<AdminSistema> adminSistema = this.vratiAdminaSistema(mejl, lozinka);
		if(adminSistema.isPresent()) return new KorisnikDTO(adminSistema.get());
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Korisnik registracija(RegistracijaDTO registracijaDTO) {
		if(!registracijaDTO.getLozinka().contentEquals(registracijaDTO.getPotvrdaLozinke())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		String mejl = registracijaDTO.getEmail();
		if(this.adminSistemaRepository.findByEmail(mejl).isPresent() ||
			this.adminKompanijeRepository.findByEmail(mejl).isPresent() ||
			this.korisnikRepository.findByEmail(mejl).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Korisnik korisnik = new Korisnik(registracijaDTO);
		korisnik.setAktiviran(false);
		Korisnik kreirani = this.korisnikRepository.save(korisnik);
		this.emailService.posaljiLinkZaRegistraciju(kreirani.getEmail(), kreirani.getId());
		return kreirani;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private Optional<AdminSistema> vratiAdminaSistema(String mejl, String lozinka) {
		Optional<AdminSistema> admin = this.adminSistemaRepository.findByEmail(mejl);
		if(admin.isPresent() && admin.get().getLozinka().contentEquals(lozinka)) {
			return admin;
		} else {
			return Optional.empty();
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private Optional<AdminKompanije> vratiAdminaKompanije(String mejl, String lozinka) {
		Optional<AdminKompanije> admin = this.adminKompanijeRepository.findByEmail(mejl);
		if(admin.isPresent() && admin.get().getLozinka().contentEquals(lozinka)) {
			return admin;
		} else {
			return Optional.empty();
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private Optional<Korisnik> vratiKorisnika(String mejl, String lozinka) {
		Optional<Korisnik> korisnik = this.korisnikRepository.findByEmail(mejl);
		if(korisnik.isPresent() && korisnik.get().getLozinka().contentEquals(lozinka) && korisnik.get().isAktiviran()) {
			return korisnik;
		} else {
			return Optional.empty();
		}
	}
	
	
	
}
