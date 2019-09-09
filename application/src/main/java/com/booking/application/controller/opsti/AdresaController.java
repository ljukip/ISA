package com.booking.application.controller.opsti;

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

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.service.opsti.AdresaService;

@RestController
@RequestMapping(value = "/adrese")
public class AdresaController {

	@Autowired
	private AdresaService adresaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdresaDTO>> vratiSve() {
		return new ResponseEntity<List<AdresaDTO>>(AdresaDTO.pretvori(this.adresaService.vratiSve()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdresaDTO> vratiJednu(@PathVariable("id") Long id) {
		return new ResponseEntity<AdresaDTO>(new AdresaDTO(this.adresaService.vratiJednu(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdresaDTO> kreiraj(@RequestBody AdresaDTO adresaDTO) {
		return new ResponseEntity<AdresaDTO>(new AdresaDTO(this.adresaService.kreiraj(new Adresa(adresaDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("id") Long id) {
		this.adresaService.obrisi(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
