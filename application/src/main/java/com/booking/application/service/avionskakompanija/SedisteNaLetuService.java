package com.booking.application.service.avionskakompanija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.application.repository.avionskakompanija.SedisteNaLetuRepository;

@Service
public class SedisteNaLetuService {

	@Autowired
	private SedisteNaLetuRepository sedisteNaLetuRepository;
	
	@Autowired
	private LetService letService;
	
}
