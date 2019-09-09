package com.booking.application.controller.opsti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.service.opsti.DestinacijaService;

@RestController
@RequestMapping(value = "/destinacije")
public class DestinacijaController {

	@Autowired
	private DestinacijaService destinacijaService;
	
}
