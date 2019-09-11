package com.booking.application.controller.hotel;

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

import com.booking.application.dto.hotel.HotelDTO;
import com.booking.application.dto.hotel.PretragaHotelaDTO;
import com.booking.application.dto.hotel.ZakupSobeDTO;
import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.model.hotel.Hotel;
import com.booking.application.service.hotel.HotelService;
import com.booking.application.service.hotel.ZakupSobaService;
import com.booking.application.service.korisnici.AdminKompanijeService;

@RestController
@RequestMapping(value = "/hoteli")
public class HotelController {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private ZakupSobaService zakupSobaService;

	@Autowired
	private AdminKompanijeService adminKompanijeService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelDTO>> vratiSve(Pageable page) {
		return new ResponseEntity<List<HotelDTO>>(HotelDTO.transformisi(this.hotelService.vratiSve(page)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelDTO> vratiJednog(@PathVariable("id") Long id) {
		return new ResponseEntity<HotelDTO>(new HotelDTO(this.hotelService.vratiJedan(id)), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelDTO> kreiraj(@RequestBody HotelDTO hotelDTO) {
		return new ResponseEntity<HotelDTO>(new HotelDTO(this.hotelService.kreiraj(new Hotel(hotelDTO), hotelDTO.getAdresaDTO())), HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelDTO> azuriraj(@RequestBody HotelDTO hotelDTO) {
		return new ResponseEntity<HotelDTO>(new HotelDTO(this.hotelService.azuriraj(new Hotel(hotelDTO), hotelDTO.getAdresaDTO())), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("id") Long id) {
		this.hotelService.obrisi(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{hotel-id}/brze", method = RequestMethod.GET)
	public ResponseEntity<List<ZakupSobeDTO>> vratiBrzeRezervacijeHotela(@PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<List<ZakupSobeDTO>>(ZakupSobeDTO.transformisi(this.zakupSobaService.vratiBrzeRezervacije(hotelId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{hotel-id}/admini", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<KorisnikDTO>> vratiAdmineKompanije(@PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<List<KorisnikDTO>>(KorisnikDTO.transformisiAdmineKompanije(this.adminKompanijeService.vratiAdmineHotela(hotelId)), HttpStatus.OK);
	}

	@RequestMapping(value = "/{hotel-id}/prihodi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Double> izracunajPrihodZaPeriod(@RequestParam("pocetak") String pocetakString, @RequestParam("kraj") String krajString, @PathVariable("hotel-id") Long hotelId) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate pocetak = LocalDate.parse(pocetakString, formatter);
			LocalDate kraj = LocalDate.parse(krajString, formatter);
			return new ResponseEntity<Double>(this.hotelService.izracunajPrihod(pocetak, kraj, hotelId), HttpStatus.OK);
		} catch(DateTimeParseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{hotel-id}/statistika", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> izracunajStatistikuZaPeriod(@RequestParam("pocetak") String pocetakString, @RequestParam("kraj") String krajString, @PathVariable("hotel-id") Long hotelId) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate pocetak = LocalDate.parse(pocetakString, formatter);
			LocalDate kraj = LocalDate.parse(krajString, formatter);
			return new ResponseEntity<List<String>>(this.hotelService.izracunajStatistiku(pocetak, kraj, hotelId), HttpStatus.OK);
		} catch(DateTimeParseException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/pretraga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelDTO>> pretraga(@RequestBody PretragaHotelaDTO pretragaHotelaDTO) {
		return new ResponseEntity<List<HotelDTO>>(HotelDTO.transformisi(this.hotelService.pretrazi(pretragaHotelaDTO)), HttpStatus.OK);
	}
	
}
