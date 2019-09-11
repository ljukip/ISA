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

import com.booking.application.dto.avionskakompanija.LetDTO;
import com.booking.application.dto.avionskakompanija.PretragaLetaDTO;
import com.booking.application.service.avionskakompanija.LetService;

@RestController
@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/letovi")
public class LetController {

	@Autowired
	private LetService letService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LetDTO>> vratiLetoveKompanije(@PathVariable("kompanija-id") Long kompanija) {
		return new ResponseEntity<List<LetDTO>>(LetDTO.transformisi(this.letService.vratiLetoveKompanije(kompanija)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{let-id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LetDTO> vratiJedan(@PathVariable("let-id") Long let, @PathVariable("kompanija-id") Long kompanija) {
		return new ResponseEntity<LetDTO>(new LetDTO(this.letService.vratiLetKompanije(let, kompanija)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LetDTO> kreirajLet(@RequestBody LetDTO letDTO, @PathVariable("kompanija-id") Long kompanija) {
		return new ResponseEntity<LetDTO>(new LetDTO(this.letService.kreirajLet(letDTO, kompanija)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{let-id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisiLet(@PathVariable("let-id") Long let, @PathVariable("kompanija-id") Long kompanija) {
		this.letService.obrisiLet(let, kompanija);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pretraga", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LetDTO>> pretrazi(@RequestBody PretragaLetaDTO pretragaDTO, @PathVariable("kompanija-id") Long kompanija) {
		return new ResponseEntity<List<LetDTO>>(LetDTO.transformisi(this.letService.pretraziLetove(pretragaDTO, kompanija)), HttpStatus.OK);
	}
	
}
