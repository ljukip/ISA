package com.booking.application.controller.korisnici;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.service.korisnici.KorisnikService;

@RestController
@RequestMapping(value = "/korisnici/obicni")
public class KorisnikController {

	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiSve() {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiKorisnike(this.korisnikService.vratiSve()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> vratiJednog(@PathVariable("id") Long id) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.korisnikService.vratiJednog(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> kreiraj(@RequestBody KorisnikDTO korisnikDTO) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.korisnikService.kreiraj(new Korisnik(korisnikDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> azuriraj(@RequestBody KorisnikDTO korisnikDTO) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.korisnikService.azuriraj(new Korisnik(korisnikDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("id") Long id) {
		this.korisnikService.obrisi(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
