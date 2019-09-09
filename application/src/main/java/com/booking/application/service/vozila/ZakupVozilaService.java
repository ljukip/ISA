package com.booking.application.service.vozila;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.model.vozila.ZakupVozila;
import com.booking.application.repository.vozila.ZakupVozilaRepository;
import com.booking.application.service.opsti.RezervacijaService;
import com.booking.application.service.vremedatum.VremeDatumUtils;

@Service
public class ZakupVozilaService {

	private static final int BROJ_DANA_ZA_POPUST = 5;
	private static final double POPUST_PO_DANU = 0.25;
	private static final double MAKSIMUM_POPUSTA = 7.5;
	private static final int MINIMUM_DANA_ZA_OTKAZIVANJE = 2;
	
	@Autowired
	private ZakupVozilaRepository zakupVozilaRepository;

	@Autowired
	private KompanijaVozilaService kompanijaVozilaService;
	
	@Autowired
	private VoziloService voziloService;
	
	@Autowired
	private VremeDatumUtils vremeDatumUtils;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	private ZakupVozila vratiJedan(Long zakupId) {
		Optional<ZakupVozila> zakup = this.zakupVozilaRepository.findById(zakupId);
		if(zakup.isPresent()) {
			return zakup.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public List<ZakupVozila> vratiBrzeRezervacije(Long kompanijaId) {
		KompanijaVozila kompanija = this.kompanijaVozilaService.vratiJednu(kompanijaId);
		List<ZakupVozila> rezultat = new ArrayList<ZakupVozila>();
		for(Garaza garaza : kompanija.getGaraze()) {
			for(Vozilo vozilo : garaza.getVozila()) {
				for(ZakupVozila zakup : vozilo.getZakupi()) {
					if(zakup.getRezervacija() == null) {
						rezultat.add(zakup);
					}
				}
			}
		}
		return rezultat;
	}

	public ZakupVozila napraviBrzuRezervaciju(Long kompanijaId, Long garazaId, Long voziloId, ZakupVozila zakup) {
		Vozilo vozilo = this.voziloService.vratiVoziloGaraze(kompanijaId, garazaId, voziloId);
		if(!this.voziloJeSlobodno(vozilo, zakup.getPocetniDatum(), zakup.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		zakup = this.postaviPocetneVrednosti(zakup);
		zakup.setTip(TipZakupa.BRZ);
		zakup.setCenaZakupa(this.izracunajCenuZakupa(zakup));
		zakup.setDodatniPopust(this.izracunajDodatniPopus(zakup));
		zakup.setVozilo(vozilo);
		ZakupVozila kreiraniZakup = this.zakupVozilaRepository.save(zakup);
		return kreiraniZakup;
	}
	
	public ZakupVozila napraviRezervaciju(Long kompanijaId, Long garazaId, Long voziloId, ZakupVozila zakup, Long rezervacijaId) {
		Vozilo vozilo = this.voziloService.vratiVoziloGaraze(kompanijaId, garazaId, voziloId);
		if(!this.voziloJeSlobodno(vozilo, zakup.getPocetniDatum(), zakup.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		zakup = this.postaviPocetneVrednosti(zakup);
		zakup.setTip(TipZakupa.REDOVAN);
		zakup.setCenaZakupa(this.izracunajCenuZakupa(zakup));
		zakup.setDodatniPopust(this.izracunajDodatniPopus(zakup));
		zakup.setVozilo(vozilo);
		Rezervacija rezervacija = this.rezervacijaService.vratiJednu(rezervacijaId);
		zakup.setRezervacija(rezervacija);
		rezervacija.setZakupVozila(zakup);
		ZakupVozila kreiraniZakup = this.zakupVozilaRepository.save(zakup);
		return kreiraniZakup;
	}

	private boolean voziloJeSlobodno(Vozilo vozilo, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		for(ZakupVozila zakup : vozilo.getZakupi()) {
			if(!this.vremeDatumUtils.slobodanTermin(zakup.getPocetniDatum(), zakup.getKrajnjiDatum(), pocetniDatum, krajnjiDatum)) {
				return false;
			}
		}
		return true;
	}
	
	private ZakupVozila postaviPocetneVrednosti(ZakupVozila zakup) {
		zakup.setCenaZakupa(0);
		zakup.setDodatniPopust(0);
		return zakup;
	}
	
	private double izracunajCenuZakupa(ZakupVozila zakup) {
		return this.vremeDatumUtils.razlikaUDanima(zakup.getPocetniDatum(), zakup.getKrajnjiDatum()) * zakup.getVozilo().getCenaPoDanu();
	}
	
	private double izracunajDodatniPopus(ZakupVozila zakup) {
		long razlikaUDanima = this.vremeDatumUtils.razlikaUDanima(zakup.getPocetniDatum(), zakup.getKrajnjiDatum());
		if(razlikaUDanima > BROJ_DANA_ZA_POPUST) {
			return Math.max((razlikaUDanima - BROJ_DANA_ZA_POPUST) * POPUST_PO_DANU, MAKSIMUM_POPUSTA);
		} else {
			return 0;
		}
	}
	
	public void obrisiZakup(Long kompanijaId, Long garazaId, Long voziloId, Long zakupId, boolean otkazanLet) {
		Vozilo vozilo = this.voziloService.vratiVoziloGaraze(kompanijaId, garazaId, voziloId);
		ZakupVozila zakup = this.vratiJedan(zakupId);
		if(vozilo.getZakupi().contains(zakup)) {
			if(otkazanLet || this.vremeDatumUtils.razlikaUDanima(LocalDate.now(), zakup.getPocetniDatum()) >= MINIMUM_DANA_ZA_OTKAZIVANJE) {
				this.zakupVozilaRepository.delete(zakup);
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}
	
}
