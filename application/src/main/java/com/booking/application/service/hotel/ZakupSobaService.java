package com.booking.application.service.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.dto.hotel.OpcijaDTO;
import com.booking.application.dto.hotel.SobaDTO;
import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.hotel.Opcija;
import com.booking.application.model.hotel.Soba;
import com.booking.application.model.hotel.ZakupSoba;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;
import com.booking.application.repository.hotel.ZakupSobaRepository;
import com.booking.application.service.opsti.RezervacijaService;
import com.booking.application.service.vremedatum.VremeDatumUtils;

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
	private HotelService hotelService;

	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private VremeDatumUtils vremeDatumUtils;

	private ZakupSoba vratiJedan(Long zakupId) {
		Optional<ZakupSoba> zakup = this.zakupSobaRepository.findById(zakupId);
		if(zakup.isPresent()) {
			return zakup.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	public List<ZakupSoba> vratiBrzeRezervacije(Long hotelId) {
		Hotel hotel = this.hotelService.vratiJedan(hotelId);
		Set<ZakupSoba> rezultat = new HashSet<ZakupSoba>();
		for(Soba soba : hotel.getSobe()) {
			for(ZakupSoba zakup : soba.getZakupi()) {
				if(zakup.getRezervacija() == null) { 
					rezultat.add(zakup); 
				}
			}
		}
		return new ArrayList<ZakupSoba>(rezultat);
	}

	public ZakupSoba napraviBrzuRezervaciju(Long hotelId, ZakupSoba noviZakupSoba, List<SobaDTO> sobeDTO, List<OpcijaDTO> opcijeDTO) {
		List<Soba> sobe = this.preuzmiSobe(sobeDTO, hotelId);
		if(!this.sobeSuSlobodne(sobe, noviZakupSoba.getPocetniDatum(), noviZakupSoba.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		noviZakupSoba = this.postaviPocetneVrednosti(noviZakupSoba);
		noviZakupSoba.setTip(TipZakupa.BRZ);
		noviZakupSoba.setOpcije(this.preuzmiOpcije(opcijeDTO, hotelId));
		noviZakupSoba.setCenaZakupa(noviZakupSoba.getCenaZakupa() + this.izracunajCenuOpcija(noviZakupSoba));
		noviZakupSoba.setSobe(sobe);
		noviZakupSoba.setCenaZakupa(noviZakupSoba.getCenaZakupa() + this.izracunajCenuSoba(noviZakupSoba));
		noviZakupSoba.setDodatniPopust(this.izracunajDodatniPopus(noviZakupSoba));
		ZakupSoba kreiraniZakupSoba = this.zakupSobaRepository.save(noviZakupSoba);
		return kreiraniZakupSoba;
	}

	public ZakupSoba napraviRezervaciju(Long hotelId, ZakupSoba noviZakupSoba, List<SobaDTO> sobeDTO, List<OpcijaDTO> opcijeDTO, Long rezervacijaId) {
		List<Soba> sobe = this.preuzmiSobe(sobeDTO, hotelId);
		if(!this.sobeSuSlobodne(sobe, noviZakupSoba.getPocetniDatum(), noviZakupSoba.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		noviZakupSoba = this.postaviPocetneVrednosti(noviZakupSoba);
		noviZakupSoba.setTip(TipZakupa.REDOVAN);
		noviZakupSoba.setOpcije(this.preuzmiOpcije(opcijeDTO, hotelId));
		noviZakupSoba.setCenaZakupa(noviZakupSoba.getCenaZakupa() + this.izracunajCenuOpcija(noviZakupSoba));
		noviZakupSoba.setSobe(sobe);
		noviZakupSoba.setCenaZakupa(noviZakupSoba.getCenaZakupa() + this.izracunajCenuSoba(noviZakupSoba));
		noviZakupSoba.setDodatniPopust(this.izracunajDodatniPopus(noviZakupSoba));
		Rezervacija rezervacija = this.rezervacijaService.vratiJednu(rezervacijaId);
		noviZakupSoba.setRezervacija(rezervacija);
		rezervacija.setZakupSoba(noviZakupSoba);
		ZakupSoba kreiraniZakupSoba = this.zakupSobaRepository.save(noviZakupSoba);
		return kreiraniZakupSoba;
	}

	private boolean sobeSuSlobodne(List<Soba> sobe, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		for(Soba soba : sobe) {
			if(!this.sobaJeSlobodna(soba, pocetniDatum, krajnjiDatum)) {
				return false;
			}
		}
		return true;
	}

	private boolean sobaJeSlobodna(Soba soba, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		for(ZakupSoba zakup : soba.getZakupi()) {
			if(!this.vremeDatumUtils.slobodanTermin(zakup.getPocetniDatum(), zakup.getKrajnjiDatum(), pocetniDatum, krajnjiDatum)) {
				return false;
			}
		}
		return true;
	}

	private ZakupSoba postaviPocetneVrednosti(ZakupSoba zakup) {
		zakup.setCenaZakupa(0);
		zakup.setDodatniPopust(0);
		return zakup;
	}

	private List<Soba> preuzmiSobe(List<SobaDTO> sobeDTO, Long hotelId) {
		List<Soba> rezultat = new ArrayList<Soba>();
		for(SobaDTO sobaDTO : sobeDTO) {
			rezultat.add(this.sobaService.vratiSobuHotela(hotelId, sobaDTO.getId()));
		}
		return rezultat;
	}

	private double izracunajCenuSoba(ZakupSoba zakup) {
		double rezultat = 0;
		for(Soba soba : zakup.getSobe()) {
			rezultat += this.cenovnikSobeService.izracunajCenu(soba, zakup.getPocetniDatum(), zakup.getKrajnjiDatum());
		}
		return rezultat;
	}

	private List<Opcija> preuzmiOpcije(List<OpcijaDTO> opcijeDTO, Long hotelId) {
		List<Opcija> rezultat = new ArrayList<Opcija>();
		for(OpcijaDTO opcijaDTO : opcijeDTO) {
			rezultat.add(this.opcijaService.vratiOpcijuHotela(hotelId, opcijaDTO.getId()));
		}
		return rezultat;
	}

	private double izracunajCenuOpcija(ZakupSoba zakup) {
		double rezultat = 0;
		for(Opcija opcija : zakup.getOpcije()) {
			rezultat += this.opcijaService.izracunajCenu(opcija, zakup.getPocetniDatum(), zakup.getKrajnjiDatum());
		}
		return rezultat;
	}

	private double izracunajDodatniPopus(ZakupSoba zakup) {
		long razlikaUDanima = this.vremeDatumUtils.razlikaUDanima(zakup.getPocetniDatum(), zakup.getKrajnjiDatum());
		if(razlikaUDanima > BROJ_DANA_ZA_POPUST) {
			return Math.min((razlikaUDanima - BROJ_DANA_ZA_POPUST) * POPUST_PO_DANU, MAKSIMUM_POPUSTA);
		} else {
			return 0;
		}
	}

	public void obrisiZakup(Long hotelId, Long sobaId, Long zakupId, boolean otkazanLet) {
		Soba soba = this.sobaService.vratiSobuHotela(hotelId, sobaId);
		ZakupSoba zakup = this.vratiJedan(zakupId);
		if(soba.getZakupi().contains(zakup)) {
			if(otkazanLet || this.vremeDatumUtils.razlikaUDanima(LocalDate.now(), zakup.getPocetniDatum()) >= MINIMUM_DANA_ZA_OTKAZIVANJE) {
				this.zakupSobaRepository.delete(zakup);
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

}
