package com.booking.application.service.avionskakompanija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.application.repository.avionskakompanija.LetRepository;

@Service
public class LetService {

	@Autowired
	private LetRepository letRepository;
	
	@Autowired
	private AvionskaKompanijaService avionskaKompanijaService;
	
}
