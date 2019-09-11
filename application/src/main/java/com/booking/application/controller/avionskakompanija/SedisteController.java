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

import com.booking.application.dto.avionskakompanija.SedisteDTO;
import com.booking.application.service.avionskakompanija.SedisteService;

@RestController
@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/letovi/{let-id}/sedista")
public class SedisteController {

	@Autowired
	private SedisteService sedisteService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<List<SedisteDTO>>> vratiSedistaLeta(@PathVariable("let-id") Long letId) {
		return new ResponseEntity<List<List<SedisteDTO>>>(SedisteDTO.transformisiZaLet(this.sedisteService.vratiSedistaLeta(letId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<List<SedisteDTO>>> dodajSediste(@PathVariable("let-id") Long letId) {
		return new ResponseEntity<List<List<SedisteDTO>>>(SedisteDTO.transformisiZaLet(this.sedisteService.dodajSediste(letId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{sediste-id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<List<SedisteDTO>>> izmeniSediste(@PathVariable("sediste-id") Long sedisteId, @RequestBody SedisteDTO sedisteDTO) {
		return new ResponseEntity<List<List<SedisteDTO>>>(SedisteDTO.transformisiZaLet(this.sedisteService.izmeniSediste(sedisteDTO, sedisteId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{sediste-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<List<SedisteDTO>>> obrisiSediste(@PathVariable("let-id") Long letId) {
		return new ResponseEntity<List<List<SedisteDTO>>>(SedisteDTO.transformisiZaLet(this.sedisteService.obrisiSediste(letId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{sediste-id}/potvrdi", method = RequestMethod.GET)
	public ResponseEntity<Void> potvrdiPoziv(@PathVariable("sediste-id") Long sedisteId) {
		this.sedisteService.potvrdiSediste(sedisteId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{sediste-id}/otkazi", method = RequestMethod.GET)
	public ResponseEntity<Void> otkaziPoziv(@PathVariable("sediste-id") Long sedisteId) {
		this.sedisteService.otkaziSediste(sedisteId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
