package com.booking.application.controller.hotel;

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

import com.booking.application.dto.hotel.OpcijaDTO;
import com.booking.application.model.hotel.Opcija;
import com.booking.application.service.hotel.OpcijaService;

@RestController
@RequestMapping(value = "/hoteli/{hotel-id}/opcije")
public class OpcijaController {

	@Autowired
	private OpcijaService opcijaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<OpcijaDTO>> vratiOpcijeHotela(@PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<List<OpcijaDTO>>(OpcijaDTO.transformisi(this.opcijaService.vratiOpcijeHotela(hotelId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{opcija-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OpcijaDTO> vratiOpciju(@PathVariable("hotel-id") Long hotelId,
			@PathVariable("opcija-id") Long opcijaId) {
		return new ResponseEntity<OpcijaDTO>(new OpcijaDTO(this.opcijaService.vratiOpcijuHotela(hotelId, opcijaId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OpcijaDTO> kreiraj(@RequestBody OpcijaDTO opcijaDTO, 
			@PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<OpcijaDTO>(new OpcijaDTO(this.opcijaService.kreiraj(new Opcija(opcijaDTO), hotelId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OpcijaDTO> azuriraj(@RequestBody OpcijaDTO opcijaDTO, 
			@PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<OpcijaDTO>(new OpcijaDTO(this.opcijaService.azuriraj(new Opcija(opcijaDTO), hotelId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{opcija-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("opcija-id") Long opcijaId, 
			@PathVariable("hotel-id") Long hotelId) {
		this.opcijaService.obrisi(hotelId, opcijaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
