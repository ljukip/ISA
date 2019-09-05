package com.booking.application.service.korisnici;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.korisnici.Prijateljstvo;
import com.booking.application.repository.korisnici.KorisnikRepository;

@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;

	public List<Korisnik> vratiSve() {
		return korisnikRepository.findAll();
	}

	public Korisnik vratiJednog(Long id) {
		Optional<Korisnik> korisnik = this.korisnikRepository.findById(id);
		if(korisnik.isPresent()) {
			return korisnik.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

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

	public List<Korisnik> vratiNepoznate(Long id) {
		Korisnik korisnik = this.vratiJednog(id);
		List<Korisnik> prijatelji = this.vratiPrijatelje(id);
		List<Korisnik> svi = this.vratiSve();
		svi.removeAll(prijatelji);
		svi.remove(korisnik);
		return svi;
	}

	public Korisnik kreiraj(Korisnik korisnik) {
		Korisnik kreiraniKorisnik = this.korisnikRepository.save(korisnik);
		return kreiraniKorisnik;
	}

	public Korisnik azuriraj(Korisnik korisnik) {
		Korisnik stariKorisnik = this.vratiJednog(korisnik.getId());
		stariKorisnik.prekopiraj(korisnik);
		this.korisnikRepository.save(stariKorisnik);
		return stariKorisnik;
	}
	
	public void obrisi(Long id) {
		Korisnik korisnik = this.vratiJednog(id);
		this.korisnikRepository.delete(korisnik);
	}
	
	public boolean vecSuPrijatelji(Korisnik korisnik1, Korisnik korisnik2) {
		return this.vratiPrijatelje(korisnik1.getId()).contains(korisnik2);
	}
	
}
