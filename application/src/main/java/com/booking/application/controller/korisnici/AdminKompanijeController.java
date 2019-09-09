package com.booking.application.controller.korisnici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.model.korisnici.AdminKompanije;
import com.booking.application.service.korisnici.AdminKompanijeService;

@RestController
@RequestMapping(value = "/korisnici/admini-kompanija")
public class AdminKompanijeController {

	@Autowired
	private AdminKompanijeService adminKompanijeService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> vratiAdminaKompanije(@PathVariable("id") Long adminId) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.adminKompanijeService.vratiJednogAdmina(adminId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> kreiraj(@RequestBody KorisnikDTO adminDTO, @RequestParam("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.adminKompanijeService.kreiraj(new AdminKompanije(adminDTO), kompanijaId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> azuriraj(@RequestBody KorisnikDTO adminDTO) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.adminKompanijeService.azuriraj(new AdminKompanije(adminDTO))), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("id") Long adminId) {
		this.adminKompanijeService.obrisi(adminId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
