package com.booking.application.service.hotel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.hotel.OpcijaDTO;
import com.booking.application.dto.hotel.ZakupSobeDTO;
import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Opcija;
import com.booking.application.model.hotel.Soba;
import com.booking.application.model.hotel.ZakupSobe;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;
import com.booking.application.repository.hotel.HotelRepository;
import com.booking.application.repository.hotel.ZakupSobaRepository;
import com.booking.application.service.opsti.RezervacijaService;
import com.booking.application.utils.VremeDatumUtils;

@Service
public class ZakupSobaService {

	private static final int BROJ_DANA_ZA_POPUST = 7;
	private static final double POPUST_PO_DANU = 0.5;
	private static final double MAKSIMUM_POPUSTA = 20.0;
	private static final int MINIMUM_DANA_ZA_OTKAZIVANJE = 2;

	@Autowired
	private ZakupSobaRepository zakupSobaRepository;

	@Autowired
	private CenovnikSobeService cenovnikSobeService;

	@Autowired
	private SobaService sobaService;

	@Autowired
	private OpcijaService opcijaService;

	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private HotelRepository hotelRepository;

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private ZakupSobe vratiJedan(Long zakupId) {
		Optional<ZakupSobe> zakup = this.zakupSobaRepository.findById(zakupId);
		if(zakup.isPresent()) {
			return zakup.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<ZakupSobe> vratiBrzeRezervacije(Long hotelId) {
		List<ZakupSobe> rezultat = new ArrayList<ZakupSobe>();
		for(ZakupSobe zakup : this.zakupSobaRepository.findAll()) {
			if(zakup.getTip().equals(TipZakupa.BRZ) && zakup.getRezervacija() == null) {
				rezultat.add(zakup);
			}
		}
		return rezultat;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ZakupSobe napraviBrzuRezervaciju(ZakupSobeDTO zakupDTO) {
		Soba soba = this.sobaService.vratiSobu(zakupDTO.getSoba().getId());
		if(!this.sobaJeSlobodna(soba, zakupDTO.getPocetniDatum(), zakupDTO.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		ZakupSobe noviZakupSoba = this.postaviPocetneVrednosti();
		noviZakupSoba.setTip(TipZakupa.BRZ);
		noviZakupSoba.setOpcije(this.preuzmiOpcije(zakupDTO.getOpcije()));
		noviZakupSoba.setCenaZakupa(noviZakupSoba.getCenaZakupa() + this.izracunajCenuOpcija(noviZakupSoba));
		noviZakupSoba.setSoba(soba);
		noviZakupSoba.setCenaZakupa(noviZakupSoba.getCenaZakupa() + this.cenovnikSobeService.izracunajCenu(soba, noviZakupSoba.getPocetniDatum(), noviZakupSoba.getKrajnjiDatum()));
		noviZakupSoba.setDodatniPopust(this.izracunajDodatniPopus(noviZakupSoba));
		ZakupSobe kreiraniZakupSoba = this.zakupSobaRepository.save(noviZakupSoba);
		return kreiraniZakupSoba;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Rezervacija napraviRezervaciju(ZakupSobeDTO zakupSobeDTO, Long rezervacijaId) {
		Soba soba = this.sobaService.vratiSobu(zakupSobeDTO.getSoba().getId());
		if(!this.sobaJeSlobodna(soba, zakupSobeDTO.getPocetniDatum(), zakupSobeDTO.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Rezervacija rezervacija = this.rezervacijaService.vratiJednu(rezervacijaId);
		if(rezervacija.isKompletirana()) throw new ResponseStatusException(HttpStatus.CONFLICT);
		LocalDate krajRezervacije = rezervacija.getAvionskaKarta().getLet().getVremeSletanja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(!zakupSobeDTO.getPocetniDatum().isAfter(krajRezervacije)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		if(!zakupSobeDTO.getKrajnjiDatum().isAfter(krajRezervacije)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		ZakupSobe zakupSobe = this.postaviPocetneVrednosti();
		zakupSobe.setTip(TipZakupa.REDOVAN);
		zakupSobe.setOpcije(this.preuzmiOpcije(zakupSobeDTO.getOpcije()));
		zakupSobe.setCenaZakupa(zakupSobe.getCenaZakupa() + this.izracunajCenuOpcija(zakupSobe));
		zakupSobe.setSoba(soba);
		zakupSobe.setPocetniDatum(zakupSobeDTO.getPocetniDatum());
		zakupSobe.setKrajnjiDatum(zakupSobeDTO.getKrajnjiDatum());
		zakupSobe.setCenaZakupa(zakupSobe.getCenaZakupa() + this.cenovnikSobeService.izracunajCenu(soba, zakupSobe.getPocetniDatum(), zakupSobe.getKrajnjiDatum()));
		zakupSobe.setDodatniPopust(this.izracunajDodatniPopus(zakupSobe));
		zakupSobe.setRezervacija(rezervacija);
		rezervacija.setZakupSoba(zakupSobe);
		this.zakupSobaRepository.save(zakupSobe);
		return this.rezervacijaService.sacuvajRezervaciju(rezervacija);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean sobaJeSlobodna(Soba soba, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		for(ZakupSobe zakup : soba.getZakupi()) {
			if(!VremeDatumUtils.slobodanTermin(zakup.getPocetniDatum(), zakup.getKrajnjiDatum(), pocetniDatum, krajnjiDatum)) {
				return false;
			}
		}
		return true;
	}

	private ZakupSobe postaviPocetneVrednosti() {
		ZakupSobe zakup = new ZakupSobe();
		zakup.setCenaZakupa(0);
		zakup.setDodatniPopust(0);
		return zakup;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private List<Opcija> preuzmiOpcije(List<OpcijaDTO> opcijeDTO) {
		List<Opcija> rezultat = new ArrayList<Opcija>();
		for(OpcijaDTO opcijaDTO : opcijeDTO) {
			rezultat.add(this.opcijaService.vratiOpciju(opcijaDTO.getId()));
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private double izracunajCenuOpcija(ZakupSobe zakup) {
		double rezultat = 0;
		for(Opcija opcija : zakup.getOpcije()) {
			rezultat += this.opcijaService.izracunajCenu(opcija, zakup.getPocetniDatum(), zakup.getKrajnjiDatum());
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private double izracunajDodatniPopus(ZakupSobe zakup) {
		long razlikaUDanima = VremeDatumUtils.razlikaUDanima(zakup.getPocetniDatum(), zakup.getKrajnjiDatum());
		if(razlikaUDanima > BROJ_DANA_ZA_POPUST) {
			return Math.min((razlikaUDanima - BROJ_DANA_ZA_POPUST) * POPUST_PO_DANU, MAKSIMUM_POPUSTA);
		} else {
			return 0;
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisiZakup(Long hotelId, Long sobaId, Long zakupId, boolean otkazanLet) {
		Soba soba = this.sobaService.vratiSobuHotela(hotelId, sobaId);
		ZakupSobe zakup = this.vratiJedan(zakupId);
		if(soba.getZakupi().contains(zakup)) {
			if(otkazanLet || dozvoljenoOtkazivanje(zakup)) {
				this.zakupSobaRepository.delete(zakup);
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public static boolean dozvoljenoOtkazivanje(ZakupSobe zakup) {
		return VremeDatumUtils.razlikaUDanima(LocalDate.now(), zakup.getPocetniDatum()) >= MINIMUM_DANA_ZA_OTKAZIVANJE;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ZakupSobe vratiBrziZakupSoba(Long zakupSoba) {
		ZakupSobe zakup = this.vratiJedan(zakupSoba);
		if(zakup.getRezervacija() == null) {
			return zakup;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ZakupSobe oceniZakup(Long zakupId, int ocena) {
		ZakupSobe zakup = this.vratiJedan(zakupId);
		if(zakup.getOcena() != 0 || zakup.getRezervacija().getAvionskaKarta().getLet().getVremePoletanja().after(new Date())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			if(ocena <= 5 && ocena >= 1) {
				zakup.setOcena(ocena);
				postaviNovuOcenu(zakup.getSoba().getHotel());
				this.zakupSobaRepository.save(zakup);
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
		}
		return zakup;
	}

	private void postaviNovuOcenu(Hotel hotel) {
		double ukupno = 0.0;
		int broj = 0;
		for(Soba soba : hotel.getSobe()) {
			for(ZakupSobe zakup : soba.getZakupi()) {
				if(zakup.getOcena() != 0) {
					broj++;
					ukupno += zakup.getOcena();
				}
			}
		}
		hotel.setOcena(ukupno / broj);
		this.hotelRepository.save(hotel);
	}
	
}
