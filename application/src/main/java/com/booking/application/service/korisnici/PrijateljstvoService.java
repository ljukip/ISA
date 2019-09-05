package com.booking.application.service.korisnici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.korisnici.Prijateljstvo;
import com.booking.application.repository.korisnici.PrijateljstvoRepository;

@Service
public class PrijateljstvoService {

	@Autowired
	private PrijateljstvoRepository prijateljstvoRepository;

	@Autowired
	private KorisnikService korisnikService;
	
	public Prijateljstvo kreiraj(Long korisnikId, Long prijateljId) {
		Korisnik korisnik = this.korisnikService.vratiJednog(korisnikId);
		Korisnik prijatelj = this.korisnikService.vratiJednog(prijateljId);
		if(this.korisnikService.vecSuPrijatelji(korisnik, prijatelj)) {
			Prijateljstvo prijateljstvo = new Prijateljstvo();
			prijateljstvo.setPrijatelj1(korisnik);
			prijateljstvo.setPrijatelj2(prijatelj);
			Prijateljstvo kreiranoPrijateljstvo = this.prijateljstvoRepository.save(prijateljstvo);
			return kreiranoPrijateljstvo;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}		
	}
	
	public void obrisi(Long korisnikId, Long prijateljId) {
		Korisnik korisnik = this.korisnikService.vratiJednog(korisnikId);
		Korisnik prijatelj = this.korisnikService.vratiJednog(prijateljId);
		Prijateljstvo prijateljstvo = this.vratiPrijateljstvo(korisnik, prijatelj);
		this.prijateljstvoRepository.delete(prijateljstvo);
	}
	
	private Prijateljstvo vratiPrijateljstvo(Korisnik korisnik, Korisnik prijatelj) {
		for(Prijateljstvo prijateljstvo : korisnik.getPrijateljstva1()) {
			if(prijateljstvo.getPrijatelj2().equals(prijatelj))
				return prijateljstvo;
		}
		for(Prijateljstvo prijateljstvo : korisnik.getPrijateljstva2()) {
			if(prijateljstvo.getPrijatelj1().equals(prijatelj))
				return prijateljstvo;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
}
