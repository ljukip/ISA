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

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.service.korisnici.KorisnikService;
import com.booking.application.service.korisnici.PrijateljstvoService;

@RestController
@RequestMapping(value = "/korisnici/obicni/{korisnik-id}")
public class PrijateljstvoController {

	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private PrijateljstvoService prijateljstvoService;
	
	@RequestMapping(value = "/prijatelji", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiPrijatelje(@PathVariable("korisnik-id") Long id) {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiKorisnike(this.korisnikService.vratiPrijatelje(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/nepoznati", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiNepoznate(@PathVariable("korisnik-id") Long id) {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiKorisnike(this.korisnikService.vratiNepoznate(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/prijatelji", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("korisnik-id") Long korisnikId,
			@RequestParam("prijatelj-id") Long prijateljId) {
		this.prijateljstvoService.obrisi(korisnikId, prijateljId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
