package com.booking.application.service.hotel;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Soba;
import com.booking.application.repository.hotel.SobaRepository;

@Service
public class SobaService {

	@Autowired
	private SobaRepository sobaRepository;
	
	@Autowired
	private HotelService hotelService;
	
	public List<Soba> vratiSobeHotela(Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		return hotel.getSobe();
	}
	
	private Soba vratiSobu(Long sobaId) {
		Optional<Soba> soba = this.sobaRepository.findById(sobaId);
		if(soba.isPresent()) {
			return soba.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Soba vratiSobuHotela(Long hotelId, Long sobaId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		Soba soba = this.vratiSobu(sobaId);
		if(hotel.getSobe().contains(soba)) {
			return soba;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Soba kreiraj(Soba novaSoba, Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		novaSoba.setHotel(hotel);
		Soba kreiranaSoba = this.sobaRepository.save(novaSoba);
		return kreiranaSoba;
	}
	
	public Soba azuriraj(Soba novaSoba, Long hotelId) {
		Soba soba = this.vratiSobuHotela(hotelId, novaSoba.getId());
		if(!this.dozvoljenaIzmena(soba)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		soba.prekopiraj(novaSoba);
		this.sobaRepository.save(soba);
		return soba;
	}
	
	public void obrisi(Long hotelId, Long sobaId) {
		Soba soba = this.vratiSobuHotela(hotelId, sobaId);
		if(this.dozvoljenaIzmena(soba)) {
			this.sobaRepository.delete(soba);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	private boolean dozvoljenaIzmena(Soba soba) {
		return soba.getZakupi().isEmpty();
	}
	
}
