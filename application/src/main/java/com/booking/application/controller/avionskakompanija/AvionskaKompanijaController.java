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

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.dto.avionskakompanija.AvionskaKompanijaDTO;
import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.service.avionskakompanija.AvionskaKompanijaService;
import com.booking.application.service.korisnici.AdminKompanijeService;

@RestController
@RequestMapping(value = "/avionske-kompanije")
public class AvionskaKompanijaController {

	@Autowired
	private AvionskaKompanijaService avionskaKompanijaService;
	
	@Autowired
	private AdminKompanijeService AdminKompanijeService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AvionskaKompanijaDTO>> vratiSve() {
		return new ResponseEntity<List<AvionskaKompanijaDTO>>(AvionskaKompanijaDTO.transformisi(this.avionskaKompanijaService.vratiSve()), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKompanijaDTO> vratiJednu(@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<AvionskaKompanijaDTO>(new AvionskaKompanijaDTO(this.avionskaKompanijaService.vratiJednu(kompanijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKompanijaDTO> kreiraj(@RequestBody AvionskaKompanijaDTO avionskaKompanijaDTO) {
		return new ResponseEntity<AvionskaKompanijaDTO>(new AvionskaKompanijaDTO(this.avionskaKompanijaService.kreiraj(new AvionskaKompanija(avionskaKompanijaDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKompanijaDTO> azuriraj(@RequestBody AvionskaKompanijaDTO avionskaKompanijaDTO) {
		return new ResponseEntity<AvionskaKompanijaDTO>(new AvionskaKompanijaDTO(this.avionskaKompanijaService.azuriraj(new AvionskaKompanija(avionskaKompanijaDTO))), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("kompanija-id") Long kompanijaId) {
		this.avionskaKompanijaService.obrisi(kompanijaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AvionskaKompanijaDTO> postaviAdresu(@RequestParam("adresa-id") Long adresaId,
			@PathVariable("kompanija-id") Long kompanijaId) {
		return new ResponseEntity<AvionskaKompanijaDTO>(new AvionskaKompanijaDTO(this.avionskaKompanijaService.postaviAdresu(kompanijaId, adresaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}/brze")
	public ResponseEntity<List<AvionskaKartaDTO>> vratiBrzeRezervacijeHotela(@PathVariable("kompanija-id") Long kompanijaId) {
		return null;
		//return new ResponseEntity<List<ZakupSobaDTO>>(ZakupSobaDTO.transformisi(this.zakupSobaService.vratiBrzeRezervacije(hotelId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{kompanija-id}/admini", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiAdmineKompanije(@PathVariable("hotel-id") Long kompanijaId) {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiAdmineKompanije(this.AdminKompanijeService.vratiAdmineAvionskeKompanije(kompanijaId)), HttpStatus.OK);
	}
	
}
