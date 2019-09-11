package com.booking.application.service.korisnici;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.korisnici.Prijateljstvo;
import com.booking.application.model.korisnici.ZahtevZaPrijateljstvo;
import com.booking.application.repository.korisnici.PrijateljstvoRepository;
import com.booking.application.repository.korisnici.ZahtevZaPrijateljstvoRepository;

@Service
public class ZahtevZaPrijateljstvoService {

	@Autowired
	private ZahtevZaPrijateljstvoRepository zahtevZaPrijateljstvoRepository;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private PrijateljstvoRepository prijateljstvoRepository;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<ZahtevZaPrijateljstvo> vratiPoslateZahteve(Long korisnikId) {
		Korisnik korisnik = this.korisnikService.vratiJednog(korisnikId);
		return korisnik.getPoslatiZahtevi();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<ZahtevZaPrijateljstvo> vratiPrimljeneZahteve(Long korisnikId) {
		Korisnik korisnik = this.korisnikService.vratiJednog(korisnikId);
		return korisnik.getPrimljeniZahtevi();
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ZahtevZaPrijateljstvo kreiraj(Long poslaoId, Long primioId) {
		Korisnik poslao = this.korisnikService.vratiJednog(poslaoId);
		Korisnik primio = this.korisnikService.vratiJednog(primioId);
		if(!this.korisnikService.vecSuPrijatelji(poslao, primio) && !this.postojiZahtev(poslaoId, primioId) && !this.postojiZahtev(primioId, poslaoId)) {
			ZahtevZaPrijateljstvo zahtev = new ZahtevZaPrijateljstvo();
			zahtev.setPoslao(poslao);
			zahtev.setPrimio(primio);
			return this.zahtevZaPrijateljstvoRepository.save(zahtev);
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long poslaoId, Long primioId) {
		try {
			ZahtevZaPrijateljstvo zahtev = this.vratiZahtev(poslaoId, primioId);
			this.zahtevZaPrijateljstvoRepository.delete(zahtev);
		} catch(ResponseStatusException e) {
			ZahtevZaPrijateljstvo zahtev = this.vratiZahtev(primioId, poslaoId);
			this.zahtevZaPrijateljstvoRepository.delete(zahtev);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean postojiZahtev(Long poslaoId, Long primioId) {
		try {
			this.vratiZahtev(poslaoId, primioId);
			return true;
		} catch(ResponseStatusException e) {
			return false;
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private ZahtevZaPrijateljstvo vratiZahtev(Long poslaoId, Long primioId) {
		Korisnik poslao = this.korisnikService.vratiJednog(poslaoId);
		Korisnik primio = this.korisnikService.vratiJednog(primioId);
		for(ZahtevZaPrijateljstvo zahtev : poslao.getPoslatiZahtevi()) {
			if(zahtev.getPrimio().equals(primio)) {
				return zahtev;
			}
		}
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Prijateljstvo prihvati(Long korisnikId, Long prijateljId) {
		Korisnik korisnik = this.korisnikService.vratiJednog(korisnikId);
		Korisnik prijatelj = this.korisnikService.vratiJednog(prijateljId);
		if(this.postojiZahtev(korisnikId, prijateljId)) {
			this.obrisi(korisnikId, prijateljId);
			Prijateljstvo prijateljstvo = new Prijateljstvo();
			prijateljstvo.setPrijatelj1(korisnik);
			prijateljstvo.setPrijatelj2(prijatelj);
			this.prijateljstvoRepository.save(prijateljstvo);
			return prijateljstvo;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
}
