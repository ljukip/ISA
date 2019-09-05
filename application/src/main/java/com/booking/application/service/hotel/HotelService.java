package com.booking.application.service.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Soba;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.repository.hotel.HotelRepository;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	
	public List<Hotel> vratiSve(Pageable page) {
		Page<Hotel> pageOfHotel = this.hotelRepository.findAll(page);
		List<Hotel> listOfHotel = new ArrayList<Hotel>();
		pageOfHotel.forEach(item -> {
			listOfHotel.add(item);
		});
		
		return listOfHotel;
	}
	
	public Hotel vratiJedan(Long id) {
		Optional<Hotel> hotel = this.hotelRepository.findById(id);
		if(hotel.isPresent()) {
			return hotel.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Hotel kreiraj(Hotel noviHotel) {
		Hotel kreiraniHotel = this.hotelRepository.save(noviHotel);
		return kreiraniHotel;
	}
	
	public Hotel azuriraj(Hotel noviHotel) {
		Hotel hotel = this.vratiJedan(noviHotel.getId());
		hotel.prekopiraj(noviHotel);
		this.hotelRepository.save(hotel);
		return hotel;
	}
	
	public void obrisi(Long id) {
		Hotel hotel = this.vratiJedan(id);
		if(this.dozvoljenaIzmena(hotel)) {
			this.hotelRepository.delete(hotel);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	private boolean dozvoljenaIzmena(Hotel hotel) {
		for(Soba soba : hotel.getSobe()) {
			if(!soba.getZakupi().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
	public Hotel postaviAdresu(Long hotelId, Long adresaId) {
		Hotel hotel = this.vratiJedan(hotelId);
		if(!this.dozvoljenaIzmena(hotel)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Adresa staraAdresa = hotel.getAdresa();
		staraAdresa.setHotel(null);
		this.hotelRepository.save(hotel);
		return hotel;
	}
	
}
