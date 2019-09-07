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
import com.booking.application.model.korisnici.AdminSistema;
import com.booking.application.service.korisnici.AdminSistemaService;

@RestController
@RequestMapping(value = "/korisnici/admini-sistema")
public class AdminSistemaController {

	@Autowired
	private AdminSistemaService adminSistemaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiSve() {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiAdmineSistema(this.adminSistemaService.vratiSve()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> vratiJednog(@PathVariable("id") Long adminId) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.adminSistemaService.vratiJednog(adminId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> kreiraj(@RequestBody KorisnikDTO adminSistemaDTO) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.adminSistemaService.kreiraj(new AdminSistema(adminSistemaDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> azuriraj(@RequestBody KorisnikDTO adminSistemaDTO) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.adminSistemaService.azuriraj(new AdminSistema(adminSistemaDTO))), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("id") Long adminId) {
		this.adminSistemaService.obrisi(adminId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
