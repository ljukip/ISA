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

import com.booking.application.dto.avionskakompanija.AvionDTO;
import com.booking.application.model.avionskakompanija.Avion;
import com.booking.application.service.avionskakompanija.AvionService;

@RestController
@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/avioni")
public class AvionController {

	@Autowired
	private AvionService avionService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AvionDTO>> vratiSve(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<List<AvionDTO>>(AvionDTO.transformisi(this.avionService.vratiAvioneKompanije(kompanijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{avion-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionDTO> vratiJednu(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("avion-id") Long avionId) {
		return new ResponseEntity<AvionDTO>(new AvionDTO(this.avionService.vratiAvionKompanije(kompanijaId, avionId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionDTO> kreiraj(@RequestBody AvionDTO avionDTO,
			@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<AvionDTO>(new AvionDTO(this.avionService.kreiraj(kompanijaId, new Avion(avionDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionDTO> azuriraj(@RequestBody AvionDTO avionDTO,
			@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<AvionDTO>(new AvionDTO(this.avionService.azuriraj(kompanijaId, new Avion(avionDTO))), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{avion-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("avion-id") Long avionId) {
		this.avionService.obrisi(kompanijaId, avionId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
