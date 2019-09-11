package com.booking.application.controller.vozila;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.dto.vozila.KompanijaVozilaDTO;
import com.booking.application.dto.vozila.PretragaKompanijaVozilaDTO;
import com.booking.application.dto.vozila.ZakupVozilaDTO;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.service.korisnici.AdminKompanijeService;
import com.booking.application.service.vozila.KompanijaVozilaService;
import com.booking.application.service.vozila.ZakupVozilaService;

@RestController
@RequestMapping(value = "/kompanije-vozila")
public class KompanijaVozilaController {

	@Autowired
	private KompanijaVozilaService kompanijaVozilaService;
	
	@Autowired
	private ZakupVozilaService zakupVozilaService;
	
	@Autowired
	private AdminKompanijeService adminKompanijeService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KompanijaVozilaDTO>> vratiSve(Pageable page) {
		return new ResponseEntity<List<KompanijaVozilaDTO>>(KompanijaVozilaDTO.transformisi(this.kompanijaVozilaService.vratiSve(page)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KompanijaVozilaDTO> vratiJednu(@PathVariable("id") Long id) {
		return new ResponseEntity<KompanijaVozilaDTO>(new KompanijaVozilaDTO(this.kompanijaVozilaService.vratiJednu(id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KompanijaVozilaDTO> kreiraj(@RequestBody KompanijaVozilaDTO kompanijaDTO) {
		return new ResponseEntity<KompanijaVozilaDTO>(new KompanijaVozilaDTO(this.kompanijaVozilaService.kreiraj(new KompanijaVozila(kompanijaDTO), kompanijaDTO.getAdresa())), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KompanijaVozilaDTO> azuriraj(@RequestBody KompanijaVozilaDTO kompanijaDTO) {
		return new ResponseEntity<KompanijaVozilaDTO>(new KompanijaVozilaDTO(this.kompanijaVozilaService.azuriraj(new KompanijaVozila(kompanijaDTO), kompanijaDTO.getAdresa())), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("id") Long id) {
		this.kompanijaVozilaService.obrisi(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}/brze", method = RequestMethod.GET)
	public ResponseEntity<List<ZakupVozilaDTO>> vratiBrzeRezervacijeVozila(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<List<ZakupVozilaDTO>>(ZakupVozilaDTO.transformisi(this.zakupVozilaService.vratiBrzeRezervacije(kompanijaId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{kompanija-id}/admini", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiAdmineKompanije(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiAdmineKompanije(this.adminKompanijeService.vratiAdmineHotela(kompanijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}/prihodi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> izracunajPrihodZaPeriod(@RequestParam("pocetak") String pocetakString, @RequestParam("kraj") String krajString, @PathVariable("kompanija-id") Long kompanijaId) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate pocetak = LocalDate.parse(pocetakString, formatter);
			LocalDate kraj = LocalDate.parse(krajString, formatter);
			return new ResponseEntity<Double>(this.kompanijaVozilaService.izracunajPrihod(pocetak, kraj, kompanijaId), HttpStatus.OK);
		} catch(DateTimeParseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{kompanija-id}/statistika", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> izracunajStatistikuZaPeriod(@RequestParam("pocetak") String pocetakString, @RequestParam("kraj") String krajString, @PathVariable("kompanija-id") Long kompanijaId) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate pocetak = LocalDate.parse(pocetakString, formatter);
			LocalDate kraj = LocalDate.parse(krajString, formatter);
			return new ResponseEntity<List<String>>(this.kompanijaVozilaService.izracunajStatistiku(pocetak, kraj, kompanijaId), HttpStatus.OK);
		} catch(DateTimeParseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/pretraga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KompanijaVozilaDTO>> pretraga(@RequestBody PretragaKompanijaVozilaDTO pretragaDTO) {
		return new ResponseEntity<List<KompanijaVozilaDTO>>(KompanijaVozilaDTO.transformisi(this.kompanijaVozilaService.pretrazi(pretragaDTO)), HttpStatus.OK);
	}
	
}
