package com.booking.application.service.opsti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.application.repository.opsti.DestinacijaRepository;

@Service
public class DestinacijaService {

	@Autowired
	private DestinacijaRepository destinacijaRepository;
	
}
