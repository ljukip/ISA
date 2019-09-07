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

import com.booking.application.dto.hotel.CenovnikSobeDTO;
import com.booking.application.model.hotel.CenovnikSobe;
import com.booking.application.service.hotel.CenovnikSobeService;

@RestController
@RequestMapping(value = "/hoteli/{hotel-id}/sobe/{soba-id}/cenovnici")
public class CenovnikSobeController {

	@Autowired
	private CenovnikSobeService cenovnikSobeService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenovnikSobeDTO>> vratiCenovnikeSobe(@PathVariable("hotel-id") Long hotelId,
													@PathVariable("soba-id") Long sobaId) {
		return new ResponseEntity<List<CenovnikSobeDTO>>(CenovnikSobeDTO.transformisi(this.cenovnikSobeService.vratiCenovnikeSobe(sobaId, hotelId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{cenovnik-id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikSobeDTO> vratiCenovnikSobe(@PathVariable("hotel-id") Long hotelId,
											 @PathVariable("soba-id") Long sobaId,
											 @PathVariable("cenovnik-id") Long cenovnikId) {
		return new ResponseEntity<CenovnikSobeDTO>(new CenovnikSobeDTO(this.cenovnikSobeService.vratiCenovnikSobe(hotelId, sobaId, cenovnikId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikSobeDTO> kreiraj(@PathVariable("hotel-id") Long hotelId,
								   @PathVariable("soba-id") Long sobaId,
								   @RequestBody CenovnikSobeDTO cenovnikSobeDTO) {
		return new ResponseEntity<CenovnikSobeDTO>(new CenovnikSobeDTO(this.cenovnikSobeService.kreiraj(new CenovnikSobe(cenovnikSobeDTO), hotelId, sobaId)), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CenovnikSobeDTO> azuriraj(@PathVariable("hotel-id") Long hotelId,
								   @PathVariable("soba-id") Long sobaId,
								   @RequestBody CenovnikSobeDTO cenovnikSobeDTO) {
		return new ResponseEntity<CenovnikSobeDTO>(new CenovnikSobeDTO(this.cenovnikSobeService.azuriraj(new CenovnikSobe(cenovnikSobeDTO), hotelId, sobaId)), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{cenovnik-id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> obrisi(@PathVariable("hotel-id") Long hotelId,
								   @PathVariable("soba-id") Long sobaId,
								   @PathVariable("cenovnik-id") Long cenovnikId) {
		this.cenovnikSobeService.obrisi(hotelId, sobaId, cenovnikId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}
