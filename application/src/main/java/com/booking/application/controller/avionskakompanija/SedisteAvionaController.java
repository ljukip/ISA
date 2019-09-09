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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.avionskakompanija.SedisteAvionaDTO;
import com.booking.application.model.avionskakompanija.KlasaSedista;
import com.booking.application.model.avionskakompanija.SedisteAviona;
import com.booking.application.service.avionskakompanija.SedisteAvionaService;

@RestController
@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/avioni/{avion-id}/sedista")
public class SedisteAvionaController {

	@Autowired
	private SedisteAvionaService sedisteAvionaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SedisteAvionaDTO>> vratiSedistaAviona(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("avion-id") Long avionId) {
		return new ResponseEntity<List<SedisteAvionaDTO>>(SedisteAvionaDTO.transformisi(this.sedisteAvionaService.vratiSedistaAviona(kompanijaId, avionId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{sediste-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SedisteAvionaDTO> vratiSedistaAviona(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("avion-id") Long avionId,
			@PathVariable("sediste-id") Long sedisteId) {
		return new ResponseEntity<SedisteAvionaDTO>(new SedisteAvionaDTO(this.sedisteAvionaService.vratiSedisteAviona(kompanijaId, avionId, sedisteId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SedisteAvionaDTO>> kreiraj(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("avion-id") Long avionId,
			@RequestParam("broj-redova") int brojRedova,
			@RequestParam("broj-kolona") int brojKolona,
			@RequestParam("klasa-sedista") KlasaSedista klasa) {
		return new ResponseEntity<List<SedisteAvionaDTO>>(SedisteAvionaDTO.transformisi(this.sedisteAvionaService.kreiraj(kompanijaId, avionId, brojRedova, brojKolona, klasa)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SedisteAvionaDTO> azuriraj(@RequestBody SedisteAvionaDTO sedisteDTO,
			@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("avion-id") Long avionId) {
		return new ResponseEntity<SedisteAvionaDTO>(new SedisteAvionaDTO(this.sedisteAvionaService.azuriraj(kompanijaId, avionId, new SedisteAviona(sedisteDTO))), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{sediste-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("avion-id") Long avionId,
			@PathVariable("sediste-id") Long sedisteId) {
		this.sedisteAvionaService.obrisi(kompanijaId, avionId, sedisteId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
