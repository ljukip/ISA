package com.booking.application.controller.korisnici;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.korisnici.PrijateljstvoDTO;
import com.booking.application.dto.korisnici.ZahtevZaPrijateljstvoDTO;
import com.booking.application.service.korisnici.ZahtevZaPrijateljstvoService;

@RestController
@RequestMapping(value = "/korisnici/obicni/{korisnik-id}/zahtevi")
public class ZahtevZaPrijateljstvoController {

	@Autowired
	private ZahtevZaPrijateljstvoService zahtevZaPrijateljstvoService;
	
	@RequestMapping(value = "/poslati", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ZahtevZaPrijateljstvoDTO>> vratiPoslateZahteve(@PathVariable("korisnik-id") Long korisnikId) {
		return new ResponseEntity<List<ZahtevZaPrijateljstvoDTO>>(ZahtevZaPrijateljstvoDTO.transformisi(this.zahtevZaPrijateljstvoService.vratiPoslateZahteve(korisnikId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/primljeni", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ZahtevZaPrijateljstvoDTO>> vratiPrimljeneZahteve(@PathVariable("korisnik-id") Long korisnikId) {
		return new ResponseEntity<List<ZahtevZaPrijateljstvoDTO>>(ZahtevZaPrijateljstvoDTO.transformisi(this.zahtevZaPrijateljstvoService.vratiPrimljeneZahteve(korisnikId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZahtevZaPrijateljstvoDTO> kreiraj(@PathVariable("korisnik-id") Long korisnikId,
			@RequestParam("prijatelj-id") Long prijateljId) {
		return new ResponseEntity<ZahtevZaPrijateljstvoDTO>(new ZahtevZaPrijateljstvoDTO(this.zahtevZaPrijateljstvoService.kreiraj(korisnikId, prijateljId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrijateljstvoDTO> prihvati(@PathVariable("korisnik-id") Long korisnikId,
			@RequestParam("prijatelj-id") Long prijateljId) {
		return new ResponseEntity<PrijateljstvoDTO>(new PrijateljstvoDTO(this.zahtevZaPrijateljstvoService.prihvati(korisnikId, prijateljId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("korisnik-id") Long korisnikId,
			@RequestParam("prijatelj-id") Long prijateljId) {
		this.zahtevZaPrijateljstvoService.obrisi(korisnikId, prijateljId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
