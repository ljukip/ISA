package com.booking.application.controller.hotel;

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

import com.booking.application.dto.hotel.HotelDTO;
import com.booking.application.dto.hotel.ZakupSobaDTO;
import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.model.hotel.Hotel;
import com.booking.application.service.hotel.HotelService;
import com.booking.application.service.hotel.ZakupSobaService;

@RestController
@RequestMapping(value = "/hoteli")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private ZakupSobaService zakupSobaService;

	
	
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
		return new ResponseEntity<HotelDTO>(new HotelDTO(this.hotelService.kreiraj(new Hotel(hotelDTO))), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelDTO> azuriraj(@RequestBody HotelDTO hotelDTO) {
		return new ResponseEntity<HotelDTO>(new HotelDTO(this.hotelService.azuriraj(new Hotel(hotelDTO))), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("id") Long id) {
		this.hotelService.obrisi(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelDTO> postaviAdresu(@RequestParam("adresa-id") Long adresaId,
			@PathVariable("id") Long hotelId) {
		return new ResponseEntity<HotelDTO>(new HotelDTO(this.hotelService.postaviAdresu(hotelId, adresaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{hotel-id}/brze")
	public ResponseEntity<List<ZakupSobaDTO>> vratiBrzeRezervacijeHotela(@PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<List<ZakupSobaDTO>>(ZakupSobaDTO.transformisi(this.zakupSobaService.vratiBrzeRezervacije(hotelId)), HttpStatus.OK);
	}
	
	
	
}
