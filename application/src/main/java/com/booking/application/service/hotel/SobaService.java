package com.booking.application.service.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.hotel.PretragaSobeDTO;
import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Soba;
import com.booking.application.repository.hotel.CenovnikSobeRepository;
import com.booking.application.repository.hotel.SobaRepository;

@Service
public class SobaService {

	@Autowired
	private SobaRepository sobaRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private CenovnikSobeRepository cenovnikSobeRepository;
	
	@Autowired
	private ZakupSobaService zakupService;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Soba> vratiSobeHotela(Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		return hotel.getSobe();
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Soba vratiSobu(Long sobaId) {
		Optional<Soba> soba = this.sobaRepository.findById(sobaId);
		if(soba.isPresent()) {
			return soba.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Soba vratiSobuHotela(Long hotelId, Long sobaId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		Soba soba = this.vratiSobu(sobaId);
		if(hotel.getSobe().contains(soba)) {
			return soba;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Soba kreiraj(Soba novaSoba, Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		novaSoba.setHotel(hotel);
		Soba kreiranaSoba = this.sobaRepository.save(novaSoba);
		return kreiranaSoba;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Soba azuriraj(Soba novaSoba, Long hotelId) {
		Soba soba = this.vratiSobuHotela(hotelId, novaSoba.getId());
		if(!this.dozvoljenaIzmena(soba)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		soba.prekopiraj(novaSoba);
		this.sobaRepository.save(soba);
		return soba;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long hotelId, Long sobaId) {
		Soba soba = this.vratiSobuHotela(hotelId, sobaId);
		if(this.dozvoljenaIzmena(soba)) {
			this.cenovnikSobeRepository.deleteAll(soba.getCenovnici());
			this.sobaRepository.delete(soba);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean dozvoljenaIzmena(Soba soba) {
		return soba.getZakupi().isEmpty();
	}

	public List<Soba> pretrazi(PretragaSobeDTO pretragaDTO, Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		List<Soba> rezultat = new ArrayList<Soba>();
		for(Soba soba : hotel.getSobe()) {
			if(!soba.getTip().equals(pretragaDTO.getTip())) continue;
			if(soba.getBrojKreveta() < pretragaDTO.getBrojGostiju()) continue;
			if(!zakupService.sobaJeSlobodna(soba, pretragaDTO.getPocetniDatum(), pretragaDTO.getKrajnjiDatum())) continue;
			rezultat.add(soba);
		}
		return rezultat;
	}
	
}
