package com.booking.application.controller.opsti;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.avionskakompanija.LetDTO;
import com.booking.application.dto.opsti.DestinacijaDTO;
import com.booking.application.service.opsti.DestinacijaService;

@RestController
@RequestMapping(value = "/destinacije")
public class DestinacijaController {

	@Autowired
	private DestinacijaService destinacijaService;
	
	@RequestMapping(value = "/{id}/poletanja", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LetDTO>> vratiPoletanja(@PathVariable("id") Long id) {
		return new ResponseEntity<List<LetDTO>>(LetDTO.transformisi(this.destinacijaService.vratiLetoveIzDestinacije(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}/sletanja", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LetDTO>> vratiSletanja(@PathVariable("id") Long id) {
		return new ResponseEntity<List<LetDTO>>(LetDTO.transformisi(this.destinacijaService.vratiLetoveNaDestinaciju(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<DestinacijaDTO>> vratiSveDestinacije() {
		return new ResponseEntity<List<DestinacijaDTO>>(DestinacijaDTO.transformisi(this.destinacijaService.vratiSve()), HttpStatus.OK);
	}
	
}
