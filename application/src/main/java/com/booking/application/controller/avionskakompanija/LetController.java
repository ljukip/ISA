package com.booking.application.controller.avionskakompanija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.service.avionskakompanija.LetService;

@RestController
@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/letovi")
public class LetController {

	@Autowired
	private LetService letService;
	
}
