package com.booking.application.controller.avionskakompanija;

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

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.dto.opsti.RezervacijaDTO;
import com.booking.application.service.avionskakompanija.AvionskaKartaService;

@RestController
public class AvionskaKartaController {

	@Autowired
	private AvionskaKartaService avionskaKartaService;
	
	@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/letovi/{let-id}/karte", method = RequestMethod.POST)
	public ResponseEntity<RezervacijaDTO> rezervisiSedista(@RequestBody AvionskaKartaDTO kartaDTO, @PathVariable("let-id") Long let, @RequestParam("korisnik") Long korisnik) {
		return new ResponseEntity<RezervacijaDTO>(new RezervacijaDTO(this.avionskaKartaService.rezervisi(kartaDTO, let, korisnik)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/letovi/{let-id}/karte/{karta-id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKartaDTO> oceniZakup(@RequestParam("ocena") int ocena, @PathVariable("karta-id") Long zakupId) {
		return new ResponseEntity<AvionskaKartaDTO>(new AvionskaKartaDTO(this.avionskaKartaService.oceniKartu(zakupId, ocena)), HttpStatus.OK);
	}
	
}
