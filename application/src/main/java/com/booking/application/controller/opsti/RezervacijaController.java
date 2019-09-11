package com.booking.application.controller.opsti;

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

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.dto.hotel.ZakupSobeDTO;
import com.booking.application.dto.opsti.RezervacijaDTO;
import com.booking.application.dto.vozila.ZakupVozilaDTO;
import com.booking.application.service.hotel.ZakupSobaService;
import com.booking.application.service.opsti.RezervacijaService;
import com.booking.application.service.vozila.ZakupVozilaService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RezervacijaController {

	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private ZakupVozilaService zakupVozilaService;
	
	@Autowired
	private ZakupSobaService zakupSobaService;
	
	@RequestMapping(value = "/rezervacije/{id}/potvrdi", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> potvrdiRezervaciju(@PathVariable("id") Long id) {
		return new ResponseEntity<RezervacijaDTO>(new RezervacijaDTO(this.rezervacijaService.kompletirajRezervaciju(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rezervacije/{id}/zakup-vozila", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> dodajZakupVozila(@RequestBody ZakupVozilaDTO zakupDTO, @PathVariable("id") Long id) {
		return new ResponseEntity<RezervacijaDTO>(new RezervacijaDTO(this.zakupVozilaService.napraviRezervaciju(zakupDTO, id)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/rezervacije/{id}/zakup-sobe", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RezervacijaDTO> dodajZakupSobe(@RequestBody ZakupSobeDTO zakupDTO, @PathVariable("id") Long id) {
		return new ResponseEntity<RezervacijaDTO>(new RezervacijaDTO(this.zakupSobaService.napraviRezervaciju(zakupDTO, id)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/korisnici/obicni/{id}/rezervacije", method = RequestMethod.GET)
	public ResponseEntity<List<RezervacijaDTO>> rezervacijaKorisnika(@PathVariable("id") Long id) {
		return new ResponseEntity<List<RezervacijaDTO>>(RezervacijaDTO.transformisi(this.rezervacijaService.rezervacijeKorisnika(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/korisnici/obicni/{id}/karte", method = RequestMethod.GET)
	public ResponseEntity<List<AvionskaKartaDTO>> istorijaAvionskihKarata(@PathVariable("id") Long id) {
		return new ResponseEntity<List<AvionskaKartaDTO>>(AvionskaKartaDTO.transformisi(this.rezervacijaService.preuzmiKarteKorisnika(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/korisnici/obicni/{id}/sobe", method = RequestMethod.GET)
	public ResponseEntity<List<ZakupSobeDTO>> istorijaZakupaSoba(@PathVariable("id") Long id) {
		return new ResponseEntity<List<ZakupSobeDTO>>(ZakupSobeDTO.transformisi(this.rezervacijaService.preuzmiZakupeSoba(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/korisnici/obicni/{id}/vozila", method = RequestMethod.GET)
	public ResponseEntity<List<ZakupVozilaDTO>> istorijaZakupaVozila(@PathVariable("id") Long id) {
		return new ResponseEntity<List<ZakupVozilaDTO>>(ZakupVozilaDTO.transformisi(this.rezervacijaService.preuzmiZakupeVozila(id)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rezervacije/{id}/brz-zakup-vozila/{zakup-id}", method = RequestMethod.PUT)
	public ResponseEntity<RezervacijaDTO> brzoRezervisiVozilo(@PathVariable("id") Long id, @PathVariable("zakup-id") Long zakupId) {
		return new ResponseEntity<RezervacijaDTO>(new RezervacijaDTO(this.rezervacijaService.dodajBrzuRezervacijuVozila(id, zakupId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/rezervacije/{id}/brz-zakup-sobe/{zakup-id}", method = RequestMethod.PUT)
	public ResponseEntity<RezervacijaDTO> brzoRezervisiSobu(@PathVariable("id") Long id, @PathVariable("zakup-id") Long zakupId) {
		return new ResponseEntity<RezervacijaDTO>(new RezervacijaDTO(this.rezervacijaService.dodajBrzuRezervacijuSobe(id, zakupId)), HttpStatus.CREATED);
	}
	
}
