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

import com.booking.application.dto.hotel.PretragaSobeDTO;
import com.booking.application.dto.hotel.SobaDTO;
import com.booking.application.model.hotel.Soba;
import com.booking.application.service.hotel.SobaService;

@RestController
@RequestMapping(value = "/hoteli/{hotel-id}/sobe")
public class SobaController {

	@Autowired
	private SobaService sobaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SobaDTO>> vratiSobeHotela(@PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<List<SobaDTO>>(SobaDTO.transformisi(this.sobaService.vratiSobeHotela(hotelId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SobaDTO> vratiJednuSobu(@PathVariable("id") Long id, @PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<SobaDTO>(new SobaDTO(this.sobaService.vratiSobuHotela(hotelId, id)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SobaDTO> kreiraj(@RequestBody SobaDTO sobaDTO, @PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<SobaDTO>(new SobaDTO(this.sobaService.kreiraj(new Soba(sobaDTO), hotelId)), HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SobaDTO> azuriraj(@RequestBody SobaDTO sobaDTO, @PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<SobaDTO>(new SobaDTO(this.sobaService.azuriraj(new Soba(sobaDTO), hotelId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{soba-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("hotel-id") Long hotelId,
			@PathVariable("soba-id") Long sobaId) {
		this.sobaService.obrisi(hotelId, sobaId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/pretraga", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SobaDTO>> pretrazi(@RequestBody PretragaSobeDTO pretragaDTO, @PathVariable("hotel-id") Long hotelId) {
		return new ResponseEntity<List<SobaDTO>>(SobaDTO.transformisi(this.sobaService.pretrazi(pretragaDTO, hotelId)), HttpStatus.OK);
	}
	
}
