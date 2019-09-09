package com.booking.application.service.avionskakompanija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.application.repository.avionskakompanija.AvionskaKartaRepository;

@Service
public class AvionskaKartaService {

	@Autowired
	private AvionskaKartaRepository avionskaKartaRepository;
	
}
