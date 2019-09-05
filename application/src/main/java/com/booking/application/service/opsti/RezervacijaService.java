package com.booking.application.service.opsti;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.repository.opsti.RezervacijaRepository;

@Service
public class RezervacijaService {

	@Autowired
	private RezervacijaRepository rezervacijaRepository;

	public Rezervacija vratiJednu(Long rezervacijaId) {
		Optional<Rezervacija> rezervacija = this.rezervacijaRepository.findById(rezervacijaId);
		if(rezervacija.isPresent()) {
			return rezervacija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
}
