package com.booking.application.service.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.hotel.PretragaHotelaDTO;
import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Soba;
import com.booking.application.model.hotel.ZakupSobe;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.repository.hotel.HotelRepository;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.service.opsti.AdresaService;

@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	@Autowired
	private ZakupSobaService zakupSobaService;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Hotel> vratiSve(Pageable page) {
		Page<Hotel> pageOfHotel = this.hotelRepository.findAll(page);
		List<Hotel> listOfHotel = new ArrayList<Hotel>();
		pageOfHotel.forEach(item -> {
			listOfHotel.add(item);
		});
		
		return listOfHotel;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Hotel vratiJedan(Long id) {
		Optional<Hotel> hotel = this.hotelRepository.findById(id);
		if(hotel.isPresent()) {
			return hotel.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Hotel kreiraj(Hotel noviHotel, AdresaDTO adresaDTO) {
		Adresa adresa = this.adresaService.kreiraj(new Adresa(adresaDTO));
		noviHotel.setOcena(0.0);
		noviHotel.setAdresa(adresa);
		Hotel kreiraniHotel = this.hotelRepository.save(noviHotel);
		adresa.setHotel(kreiraniHotel);
		this.adresaRepository.save(adresa);
		return kreiraniHotel;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Hotel azuriraj(Hotel noviHotel, AdresaDTO adresaDTO) {
		Hotel hotel = this.vratiJedan(noviHotel.getId());
		hotel.prekopiraj(noviHotel);
		this.hotelRepository.save(hotel);
		hotel.getAdresa().prekopiraj(adresaDTO);
		this.adresaRepository.save(hotel.getAdresa());
		return hotel;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long id) {
		Hotel hotel = this.vratiJedan(id);
		if(this.dozvoljenaIzmena(hotel)) {
			this.hotelRepository.delete(hotel);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean dozvoljenaIzmena(Hotel hotel) {
		for(Soba soba : hotel.getSobe()) {
			if(!soba.getZakupi().isEmpty()) {
				return false;
			}
		}
		return true;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Double izracunajPrihod(LocalDate pocetak, LocalDate kraj, Long hotelId) {
		Hotel hotel = this.vratiJedan(hotelId);
		Double prihod = 0.0;
		for(Soba soba : hotel.getSobe()) {
			for(ZakupSobe zakup : soba.getZakupi()) {
				if(!(zakup.getPocetniDatum().isAfter(pocetak) && zakup.getPocetniDatum().isBefore(kraj))) continue;
				prihod += zakup.getCenaZakupa();
			}
		}
		return prihod;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<String> izracunajStatistiku(LocalDate pocetak, LocalDate kraj, Long hotelId) {
		Hotel hotel = this.vratiJedan(hotelId);
		HashMap<LocalDate, Integer> statistika = new HashMap<LocalDate, Integer>();
		for(Soba soba : hotel.getSobe()) {
			for(ZakupSobe zakup : soba.getZakupi()) {
				if(!(zakup.getPocetniDatum().isAfter(pocetak) && zakup.getPocetniDatum().isBefore(kraj))) continue;
				LocalDate pocetniDatum = zakup.getPocetniDatum();
				if(statistika.containsKey(pocetniDatum)) {
					statistika.put(pocetniDatum, statistika.get(pocetniDatum) + 1);
				} else {
					statistika.put(pocetniDatum, 1);
				}
			}
		}
		List<String> rezultat = new ArrayList<String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		for(LocalDate datum : statistika.keySet()) {
			rezultat.add(formatter.format(datum) + "=" + statistika.get(datum));
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Hotel> pretrazi(PretragaHotelaDTO pretragaHotelaDTO) {
		List<Hotel> rezultat = this.hotelRepository.findAll();
		if(!pretragaHotelaDTO.getNaziv().isEmpty()) rezultat.removeIf(x -> (x.getNaziv().equalsIgnoreCase(pretragaHotelaDTO.getNaziv())));
		if(!pretragaHotelaDTO.getDestinacija().getGrad().isEmpty()) rezultat.removeIf(x -> !(x.getAdresa().getGrad().equalsIgnoreCase(pretragaHotelaDTO.getDestinacija().getGrad()) && x.getAdresa().getZemlja().equalsIgnoreCase(pretragaHotelaDTO.getDestinacija().getZemlja())));
		rezultat.removeIf(x -> this.barJednaSobaJeSlobodna(x, pretragaHotelaDTO.getPocetak() , pretragaHotelaDTO.getKraj()));
		return rezultat;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean barJednaSobaJeSlobodna(Hotel hotel, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		for(Soba soba : hotel.getSobe()) {
			if(zakupSobaService.sobaJeSlobodna(soba, pocetniDatum, krajnjiDatum)) return true;
		}
		return false;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Hotel vratiNeki() {
		List<Hotel> sve = this.hotelRepository.findAll();
		if(sve.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			return sve.get(0);
		}
	}
	
}
