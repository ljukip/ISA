package com.booking.application.controller.vozila;

import java.util.List;

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

import com.booking.application.dto.vozila.GarazaDTO;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.service.vozila.GarazaService;

@RestController
@RequestMapping(value = "/kompanije-vozila/{kompanija-id}/garaze")
public class GarazaController {

	@Autowired
	private GarazaService garazaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GarazaDTO>> vratiGarazeKompanije(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<List<GarazaDTO>>(GarazaDTO.transformisi(this.garazaService.vratiGarazeKompanije(kompanijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{garaza-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GarazaDTO> vratiGarazuKompanije(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId) {
		return new ResponseEntity<GarazaDTO>(new GarazaDTO(this.garazaService.vratiGarazuKompanije(kompanijaId, garazaId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GarazaDTO> kreiraj(@RequestBody GarazaDTO garaza, @PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<GarazaDTO>(new GarazaDTO(this.garazaService.kreiraj(new Garaza(garaza), kompanijaId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{garaza-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("kompanija-id") Long kompanijaId, @PathVariable("garaza-id") Long garazaId) {
		this.garazaService.obrisi(kompanijaId, garazaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{garaza-id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GarazaDTO> postaviAdresu(@RequestParam("adresa-id") Long adresaId,
			@PathVariable("id") Long garazaId,
			@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<GarazaDTO>(new GarazaDTO(this.garazaService.postaviAdresu(kompanijaId, garazaId, adresaId)), HttpStatus.OK);
	}
	
}
