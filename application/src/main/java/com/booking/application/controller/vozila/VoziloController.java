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
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.vozila.VoziloDTO;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.service.vozila.VoziloService;

@RestController
@RequestMapping(value = "/kompanije-vozila/{kompanija-id}/garaze/{garaza-id}/vozila")
public class VoziloController {

	@Autowired
	private VoziloService voziloService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<VoziloDTO>> vratiVozilaGaraza(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId) {
		return new ResponseEntity<List<VoziloDTO>>(VoziloDTO.transformisi(this.voziloService.vratiVozilaGaraza(kompanijaId, garazaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{vozilo-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VoziloDTO> vratiVoziloGaraza(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId,
			@PathVariable("vozilo-id") Long voziloId) {
		return new ResponseEntity<VoziloDTO>(new VoziloDTO(this.voziloService.vratiVoziloGaraze(kompanijaId, garazaId, voziloId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VoziloDTO> kreiraj(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId,
			@RequestBody VoziloDTO voziloDTO) {
		return new ResponseEntity<VoziloDTO>(new VoziloDTO(this.voziloService.kreiraj(new Vozilo(voziloDTO), kompanijaId, garazaId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<VoziloDTO> azuriraj(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId,
			@RequestBody VoziloDTO voziloDTO) {
		return new ResponseEntity<VoziloDTO>(new VoziloDTO(this.voziloService.azuriraj(new Vozilo(voziloDTO), kompanijaId, garazaId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{vozilo-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("kompanija-id") Long kompanijaId,
			@PathVariable("garaza-id") Long garazaId,
			@PathVariable("vozilo-id") Long voziloId) {
		this.voziloService.obrisi(kompanijaId, garazaId, voziloId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
