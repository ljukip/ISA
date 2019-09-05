package com.booking.application.service.hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Opcija;
import com.booking.application.repository.hotel.OpcijaRepository;
import com.booking.application.service.vremedatum.VremeDatumUtils;

@Service
public class OpcijaService {

	@Autowired
	private OpcijaRepository opcijaRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private VremeDatumUtils datumiUtils;
	
	public List<Opcija> vratiOpcijeHotela(Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		return hotel.getOpcije();
	}
	
	private Opcija vratiOpciju(Long opcijaId) {
		Optional<Opcija> opcija = this.opcijaRepository.findById(opcijaId);
		if(opcija.isPresent()) {
			return opcija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Opcija vratiOpcijuHotela(Long hotelId, Long opcijaId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		Opcija opcija = this.vratiOpciju(opcijaId);
		if(hotel.getOpcije().contains(opcija)) {
			return opcija;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public Opcija kreiraj(Opcija novaOpcija, Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		novaOpcija.setHotel(hotel);
		Opcija kreiranaOpcija = this.opcijaRepository.save(novaOpcija);
		return kreiranaOpcija;
	}
	
	public Opcija azuriraj(Opcija novaOpcija, Long hotelId) {
		Opcija opcija = this.vratiOpcijuHotela(hotelId, novaOpcija.getId());
		if(!this.dozvoljenaIzmena(opcija)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		opcija.prekopiraj(novaOpcija);
		this.opcijaRepository.save(opcija);
		return opcija;
	}
	
	public void obrisi(Long hotelId, Long opcijaId) {
		Opcija opcija = this.vratiOpcijuHotela(hotelId, opcijaId);
		if(this.dozvoljenaIzmena(opcija)) {
			this.opcijaRepository.delete(opcija);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	private boolean dozvoljenaIzmena(Opcija opcija) {
		return opcija.getZakupi().isEmpty();
	}
	
	public double izracunajCenu(Opcija opcija, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		long brojDana = this.datumiUtils.razlikaUDanima(pocetniDatum, krajnjiDatum);
		return opcija.getCena() * brojDana;
	}
	
}
