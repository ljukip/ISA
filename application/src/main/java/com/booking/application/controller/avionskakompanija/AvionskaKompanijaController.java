package com.booking.application.controller.avionskakompanija;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
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

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.dto.avionskakompanija.AvionskaKompanijaDTO;
import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.service.avionskakompanija.AvionskaKartaService;
import com.booking.application.service.avionskakompanija.AvionskaKompanijaService;
import com.booking.application.service.korisnici.AdminKompanijeService;

@RestController
@RequestMapping(value = "/avionske-kompanije")
public class AvionskaKompanijaController {

	@Autowired
	private AvionskaKompanijaService avionskaKompanijaService;
	
	@Autowired
	private AdminKompanijeService adminKompanijeService;
	
	@Autowired
	private AvionskaKartaService avionskaKartaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AvionskaKompanijaDTO>> vratiSve(Pageable page) {
		return new ResponseEntity<List<AvionskaKompanijaDTO>>(AvionskaKompanijaDTO.transformisi(this.avionskaKompanijaService.vratiSve(page)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKompanijaDTO> vratiJednu(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<AvionskaKompanijaDTO>(new AvionskaKompanijaDTO(this.avionskaKompanijaService.vratiJednu(kompanijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKompanijaDTO> kreiraj(@RequestBody AvionskaKompanijaDTO avionskaKompanijaDTO) {
		return new ResponseEntity<AvionskaKompanijaDTO>(new AvionskaKompanijaDTO(this.avionskaKompanijaService.kreiraj(new AvionskaKompanija(avionskaKompanijaDTO), avionskaKompanijaDTO.getAdresaDTO())), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKompanijaDTO> azuriraj(@RequestBody AvionskaKompanijaDTO avionskaKompanijaDTO) {
		return new ResponseEntity<AvionskaKompanijaDTO>(new AvionskaKompanijaDTO(this.avionskaKompanijaService.azuriraj(new AvionskaKompanija(avionskaKompanijaDTO), avionskaKompanijaDTO.getAdresaDTO())), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("kompanija-id") Long kompanijaId) {
		this.avionskaKompanijaService.obrisi(kompanijaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}/brze")
	public ResponseEntity<List<AvionskaKartaDTO>> vratiBrzeRezervacijaLetova(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<List<AvionskaKartaDTO>>(AvionskaKartaDTO.transformisi(this.avionskaKartaService.vratiBrzeRezervacije()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}/admini", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiAdmineKompanije(@PathVariable("hotel-id") Long kompanijaId) {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiAdmineKompanije(this.adminKompanijeService.vratiAdmineAvionskeKompanije(kompanijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}/prihodi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> izracunajPrihodZaPeriod(@RequestParam("pocetak") String pocetakString, @RequestParam("kraj") String krajString, @PathVariable("kompanija-id") Long kompanijaId) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date pocetak = format.parse(pocetakString);
			Date kraj = format.parse(krajString);
			return new ResponseEntity<Double>(this.avionskaKompanijaService.izracunajPrihod(pocetak, kraj, kompanijaId), HttpStatus.OK);
		} catch(ParseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/{kompanija-id}/statistika", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HashMap<LocalDate, Integer>> izracunajProdateKarteZaPeriod(@RequestParam("pocetak") String pocetakString, @RequestParam("kraj") String krajString, @PathVariable("kompanija-id") Long kompanijaId) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date pocetak = formatter.parse(pocetakString);
			Date kraj = formatter.parse(krajString);
			return new ResponseEntity<HashMap<LocalDate, Integer>>(this.avionskaKompanijaService.izracunajStatistiku(pocetak, kraj, kompanijaId), HttpStatus.OK);
		} catch(ParseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
}
