package com.booking.application.service.hotel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Opcija;
import com.booking.application.repository.hotel.OpcijaRepository;
import com.booking.application.utils.VremeDatumUtils;

@Service
public class OpcijaService {

	@Autowired
	private OpcijaRepository opcijaRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Opcija> vratiOpcijeHotela(Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		return hotel.getOpcije();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Opcija vratiOpciju(Long opcijaId) {
		Optional<Opcija> opcija = this.opcijaRepository.findById(opcijaId);
		if(opcija.isPresent()) {
			return opcija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Opcija vratiOpcijuHotela(Long hotelId, Long opcijaId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		Opcija opcija = this.vratiOpciju(opcijaId);
		if(hotel.getOpcije().contains(opcija)) {
			return opcija;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Opcija kreiraj(Opcija novaOpcija, Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		novaOpcija.setHotel(hotel);
		Opcija kreiranaOpcija = this.opcijaRepository.save(novaOpcija);
		return kreiranaOpcija;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Opcija azuriraj(Opcija novaOpcija, Long hotelId) {
		Opcija opcija = this.vratiOpcijuHotela(hotelId, novaOpcija.getId());
		if(!this.dozvoljenaIzmena(opcija)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		opcija.prekopiraj(novaOpcija);
		this.opcijaRepository.save(opcija);
		return opcija;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long hotelId, Long opcijaId) {
		Opcija opcija = this.vratiOpcijuHotela(hotelId, opcijaId);
		if(this.dozvoljenaIzmena(opcija)) {
			this.opcijaRepository.delete(opcija);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean dozvoljenaIzmena(Opcija opcija) {
		return opcija.getZakupi().isEmpty();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public double izracunajCenu(Opcija opcija, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		long brojDana = VremeDatumUtils.razlikaUDanima(pocetniDatum, krajnjiDatum);
		return opcija.getCena() * brojDana;
	}
	
}
