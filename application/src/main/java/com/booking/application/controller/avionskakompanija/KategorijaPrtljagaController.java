package com.booking.application.controller.avionskakompanija;

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

import com.booking.application.dto.avionskakompanija.KategorijaPrtljagaDTO;
import com.booking.application.model.avionskakompanija.KategorijaPrtljaga;
import com.booking.application.service.avionskakompanija.KategorijaPrtljagaService;

@RestController
@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/prtljazi")
public class KategorijaPrtljagaController {

	@Autowired
	private KategorijaPrtljagaService kategorijaPrtljagaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KategorijaPrtljagaDTO>> vratiKategorijeKompanije(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<List<KategorijaPrtljagaDTO>>(KategorijaPrtljagaDTO.transformisi(this.kategorijaPrtljagaService.vratiKategorijeKompanije(kompanijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kategorija-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KategorijaPrtljagaDTO> vratiKategorijuKompanije(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("kategorija-id") Long kategorijaId) {
		return new ResponseEntity<KategorijaPrtljagaDTO>(new KategorijaPrtljagaDTO(this.kategorijaPrtljagaService.vratiKategorijuKompanije(kompanijaId, kategorijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KategorijaPrtljagaDTO> kreiraj(@RequestBody KategorijaPrtljagaDTO kategorijaPrtljagaDTO,
			@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<KategorijaPrtljagaDTO>(new KategorijaPrtljagaDTO(this.kategorijaPrtljagaService.kreiraj(new KategorijaPrtljaga(kategorijaPrtljagaDTO), kompanijaId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KategorijaPrtljagaDTO> azuriraj(@RequestBody KategorijaPrtljagaDTO kategorijaPrtljagaDTO,
			@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<KategorijaPrtljagaDTO>(new KategorijaPrtljagaDTO(this.kategorijaPrtljagaService.azuriraj(new KategorijaPrtljaga(kategorijaPrtljagaDTO), kompanijaId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{kategorija-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("kategorija-id") Long kategorijaId) {
		this.kategorijaPrtljagaService.obrisi(kompanijaId, kategorijaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
