package com.booking.application.controller.korisnici;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.dto.korisnici.LoginDTO;
import com.booking.application.dto.korisnici.RegistracijaDTO;
import com.booking.application.service.korisnici.LoginRegistracijaService;

@RestController
public class LoginRegistracijaController {

	@Autowired
	private LoginRegistracijaService loginRegistracijaService;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> login(@RequestBody LoginDTO loginDTO) {
		return new ResponseEntity<KorisnikDTO>(this.loginRegistracijaService.login(loginDTO.getEmail(), loginDTO.getLozinka()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/signup", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KorisnikDTO> registracija(@RequestBody RegistracijaDTO registracijaDTO) {
		return new ResponseEntity<KorisnikDTO>(new KorisnikDTO(this.loginRegistracijaService.registracija(registracijaDTO)), HttpStatus.CREATED);
	}
	
}
