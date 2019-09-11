package com.booking.application.service.korisnici;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.korisnici.Prijateljstvo;
import com.booking.application.repository.korisnici.KorisnikRepository;

@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Korisnik> vratiSve() {
		return korisnikRepository.findAll();
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Korisnik vratiJednog(Long id) {
		Optional<Korisnik> korisnik = this.korisnikRepository.findById(id);
		if(korisnik.isPresent()) {
			return korisnik.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Korisnik> vratiPrijatelje(Long id) {
		Korisnik korisnik = this.vratiJednog(id);
		Set<Korisnik> prijatelji = new HashSet<Korisnik>();
		for(Prijateljstvo prijateljstvo : korisnik.getPrijateljstva1()) {
			prijatelji.add(prijateljstvo.getPrijatelj2());
		}
		for(Prijateljstvo prijateljstvo : korisnik.getPrijateljstva2()) {
			prijatelji.add(prijateljstvo.getPrijatelj1());
		}
		return new ArrayList<Korisnik>(prijatelji);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Korisnik> vratiNepoznate(Long id) {
		Korisnik korisnik = this.vratiJednog(id);
		List<Korisnik> prijatelji = this.vratiPrijatelje(id);
		List<Korisnik> svi = this.vratiSve();
		svi.removeAll(prijatelji);
		svi.remove(korisnik);
		return svi;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Korisnik kreiraj(Korisnik korisnik) {
		Korisnik kreiraniKorisnik = this.korisnikRepository.save(korisnik);
		return kreiraniKorisnik;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Korisnik azuriraj(Korisnik korisnik) {
		Korisnik stariKorisnik = this.vratiJednog(korisnik.getId());
		stariKorisnik.prekopiraj(korisnik);
		this.korisnikRepository.save(stariKorisnik);
		return stariKorisnik;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long id) {
		Korisnik korisnik = this.vratiJednog(id);
		this.korisnikRepository.delete(korisnik);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean vecSuPrijatelji(Korisnik korisnik1, Korisnik korisnik2) {
		return this.vratiPrijatelje(korisnik1.getId()).contains(korisnik2);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void aktiviraj(Long id) {
		Korisnik korisnik = this.vratiJednog(id);
		korisnik.setAktiviran(true);
		this.korisnikRepository.save(korisnik);
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Korisnik pronadjiPoMejlu(String email) {
		if(email == null || email.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		List<Korisnik> korisnici = this.korisnikRepository.findAll();
		for(Korisnik korisnik : korisnici) {
			if(korisnik.getEmail().contentEquals(email)) {
				return korisnik;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
}
