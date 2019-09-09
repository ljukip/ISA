package com.booking.application.controller.avionskakompanija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.application.service.avionskakompanija.SedisteNaLetuService;

@RestController
@RequestMapping(value = "/avionske-kompanije/{kompanija-id}/letovi/{let-id}/sedista")
public class SedisteNaLetuController {

	@Autowired
	private SedisteNaLetuService sedisteNaLetuService;
	
}
