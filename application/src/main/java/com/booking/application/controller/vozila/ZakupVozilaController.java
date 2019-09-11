package com.booking.application.controller.vozila;

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

import com.booking.application.dto.vozila.ZakupVozilaDTO;
import com.booking.application.model.vozila.ZakupVozila;
import com.booking.application.service.vozila.ZakupVozilaService;

@RestController
@RequestMapping(value = "/kompanije-vozila/{kompanija-id}/garaze/{garaza-id}/vozila/{vozilo-id}/zakupi")
public class ZakupVozilaController {

	@Autowired
	private ZakupVozilaService zakupVozilaService;
	
	@RequestMapping(value = "/brze", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZakupVozilaDTO> napraviBrzuRezervaciju(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId,
			@PathVariable("vozilo-id") Long voziloId,
			@RequestBody ZakupVozilaDTO zakupDTO) {
		return new ResponseEntity<ZakupVozilaDTO>(new ZakupVozilaDTO(this.zakupVozilaService.napraviBrzuRezervaciju(kompanijaId, garazaId, voziloId, new ZakupVozila(zakupDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{zakup-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisiZakup(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId,
			@PathVariable("vozilo-id") Long voziloId,
			@PathVariable("zakup-id") Long zakupId) {
		this.zakupVozilaService.obrisiZakup(kompanijaId, garazaId, voziloId, zakupId, false);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{zakup-id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZakupVozilaDTO> oceniZakup(@RequestParam("ocena") int ocena, @PathVariable("zakup-id") Long zakupId) {
		return new ResponseEntity<ZakupVozilaDTO>(new ZakupVozilaDTO(this.zakupVozilaService.oceniZakup(zakupId, ocena)), HttpStatus.OK);
	}
	
}
