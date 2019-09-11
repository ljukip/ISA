package com.booking.application.controller.hotel;

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

import com.booking.application.dto.hotel.ZakupSobeDTO;
import com.booking.application.service.hotel.ZakupSobaService;

@RestController
@RequestMapping(value = "/hoteli/{hotel-id}/sobe/{soba-id}/zakupi")
public class ZakupSobaController {

	@Autowired
	private ZakupSobaService zakupSobaService;
	
	@RequestMapping(value = "/brze", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZakupSobeDTO> napraviBrzuRezervaciju(@RequestBody ZakupSobeDTO zakupDTO) {
		return new ResponseEntity<ZakupSobeDTO>(new ZakupSobeDTO(this.zakupSobaService.napraviBrzuRezervaciju(zakupDTO)), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/{zakup-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisiZakup(@PathVariable("hotel-id") Long hotelId,
			@PathVariable("soba-id") Long sobaId,
			@PathVariable("zakup-id") Long zakupId) {
		this.zakupSobaService.obrisiZakup(hotelId, sobaId, zakupId, false);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{zakup-id}", method= RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ZakupSobeDTO> oceniZakup(@RequestParam("ocena") int ocena, @PathVariable("zakup-id") Long zakupId) {
		return new ResponseEntity<ZakupSobeDTO>(new ZakupSobeDTO(this.zakupSobaService.oceniZakup(zakupId, ocena)), HttpStatus.OK);
	}
	
}
