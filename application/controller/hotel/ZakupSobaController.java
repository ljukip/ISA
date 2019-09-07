package com.booking.application.controller.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.dto.hotel.ZakupSobaDTO;
import com.booking.application.model.hotel.ZakupSoba;
import com.booking.application.service.hotel.ZakupSobaService;

@RestController
@RequestMapping(value = "/hoteli/{hotel-id}/sobe/{soba-id}/zakupi")
public class ZakupSobaController {

	@Autowired
	private ZakupSobaService zakupSobaService;
	
	@RequestMapping(value = "/brze", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZakupSobaDTO> napraviBrzuRezervaciju(@PathVariable("hotel-id") Long hotelId,
			@RequestBody ZakupSobaDTO zakupDTO) {
		return new ResponseEntity<ZakupSobaDTO>(new ZakupSobaDTO(this.zakupSobaService.napraviBrzuRezervaciju(hotelId, new ZakupSoba(zakupDTO), zakupDTO.getSobe(), zakupDTO.getOpcije())), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{zakup-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisiZakup(@PathVariable("hotel-id") Long hotelId,
			@PathVariable("soba-id") Long sobaId,
			@PathVariable("zakup-id") Long zakupId) {
		this.zakupSobaService.obrisiZakup(hotelId, sobaId, zakupId, false);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
