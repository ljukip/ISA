package com.booking.application.service.vozila;

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

import com.booking.application.dto.vozila.ZakupVozilaDTO;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.model.vozila.ZakupVozila;
import com.booking.application.repository.vozila.KompanijaVozilaRepository;
import com.booking.application.repository.vozila.ZakupVozilaRepository;
import com.booking.application.service.opsti.RezervacijaService;
import com.booking.application.utils.VremeDatumUtils;

@Service
public class ZakupVozilaService {

	private static final int BROJ_DANA_ZA_POPUST = 5;
	private static final double POPUST_PO_DANU = 0.25;
	private static final double MAKSIMUM_POPUSTA = 7.5;
	private static final int MINIMUM_DANA_ZA_OTKAZIVANJE = 2;

	@Autowired
	private ZakupVozilaRepository zakupVozilaRepository;

	@Autowired
	private VoziloService voziloService;

	@Autowired
	private RezervacijaService rezervacijaService;
	
	@Autowired
	private KompanijaVozilaRepository kompanijaRepository;

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private ZakupVozila vratiJedan(Long zakupId) {
		Optional<ZakupVozila> zakup = this.zakupVozilaRepository.findById(zakupId);
		if(zakup.isPresent()) {
			return zakup.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<ZakupVozila> vratiBrzeRezervacije(Long kompanijaId) {
		List<ZakupVozila> rezultat = new ArrayList<ZakupVozila>();
		for(ZakupVozila zakup : this.zakupVozilaRepository.findAll()) {
			if(zakup.getTip().equals(TipZakupa.BRZ) && zakup.getRezervacija() == null) {
				rezultat.add(zakup);
			}
		}
		return rezultat;
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public ZakupVozila napraviBrzuRezervaciju(Long kompanijaId, Long garazaId, Long voziloId, ZakupVozila zakupDTO) {
		Vozilo vozilo = this.voziloService.vratiVoziloGaraze(kompanijaId, garazaId, voziloId);
		if(!this.voziloJeSlobodno(vozilo, zakupDTO.getPocetniDatum(), zakupDTO.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		ZakupVozila zakup = this.postaviPocetneVrednosti();
		zakup.setTip(TipZakupa.BRZ);
		zakup.setCenaZakupa(this.izracunajCenuZakupa(zakup));
		zakup.setDodatniPopust(this.izracunajDodatniPopus(zakup));
		zakup.setVozilo(vozilo);
		ZakupVozila kreiraniZakup = this.zakupVozilaRepository.save(zakup);
		return kreiraniZakup;
	}

	@Transactional(readOnly = false, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public Rezervacija napraviRezervaciju(ZakupVozilaDTO zakupDTO, Long rezervacijaId) {
		Vozilo vozilo = this.voziloService.vratiJednoVozilo(zakupDTO.getVoziloDTO().getId());
		if(!this.voziloJeSlobodno(vozilo, zakupDTO.getPocetniDatum(), zakupDTO.getKrajnjiDatum())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		Rezervacija rezervacija = this.rezervacijaService.vratiJednu(rezervacijaId);
		if(rezervacija.isKompletirana()) throw new ResponseStatusException(HttpStatus.CONFLICT);
		LocalDate krajRezervacije = rezervacija.getAvionskaKarta().getLet().getVremeSletanja().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		if(!zakupDTO.getPocetniDatum().isAfter(krajRezervacije)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		if(!zakupDTO.getKrajnjiDatum().isAfter(krajRezervacije)) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		ZakupVozila zakup = this.postaviPocetneVrednosti();
		zakup.setTip(TipZakupa.REDOVAN);
		zakup.setPocetniDatum(zakupDTO.getPocetniDatum());
		zakup.setKrajnjiDatum(zakupDTO.getKrajnjiDatum());
		zakup.setVozilo(vozilo);
		zakup.setCenaZakupa(this.izracunajCenuZakupa(zakup));
		zakup.setDodatniPopust(this.izracunajDodatniPopus(zakup));
		zakup.setRezervacija(rezervacija);
		rezervacija.setZakupVozila(zakup);
		this.zakupVozilaRepository.save(zakup);
		return rezervacijaService.sacuvajRezervaciju(rezervacija);
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public boolean voziloJeSlobodno(Vozilo vozilo, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		for(ZakupVozila zakup : vozilo.getZakupi()) {
			if(!VremeDatumUtils.slobodanTermin(zakup.getPocetniDatum(), zakup.getKrajnjiDatum(), pocetniDatum, krajnjiDatum)) {
				return false;
			}
		}
		return true;
	}

	private ZakupVozila postaviPocetneVrednosti() {
		ZakupVozila zakup = new ZakupVozila();
		zakup.setCenaZakupa(0);
		zakup.setDodatniPopust(0);
		return zakup;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private double izracunajCenuZakupa(ZakupVozila zakup) {
		return VremeDatumUtils.razlikaUDanima(zakup.getPocetniDatum(), zakup.getKrajnjiDatum()) * zakup.getVozilo().getCenaPoDanu();
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private double izracunajDodatniPopus(ZakupVozila zakup) {
		long razlikaUDanima = VremeDatumUtils.razlikaUDanima(zakup.getPocetniDatum(), zakup.getKrajnjiDatum());
		if(razlikaUDanima > BROJ_DANA_ZA_POPUST) {
			return Math.max((razlikaUDanima - BROJ_DANA_ZA_POPUST) * POPUST_PO_DANU, MAKSIMUM_POPUSTA);
		} else {
			return 0;
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisiZakup(Long kompanijaId, Long garazaId, Long voziloId, Long zakupId, boolean otkazanLet) {
		Vozilo vozilo = this.voziloService.vratiVoziloGaraze(kompanijaId, garazaId, voziloId);
		ZakupVozila zakup = this.vratiJedan(zakupId);
		if(vozilo.getZakupi().contains(zakup)) {
			if(otkazanLet || dozvoljenoOtkazivanje(zakup)) {
				this.zakupVozilaRepository.delete(zakup);
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT);
			}
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public static boolean dozvoljenoOtkazivanje(ZakupVozila zakup) {
		return VremeDatumUtils.razlikaUDanima(LocalDate.now(), zakup.getPocetniDatum()) >= MINIMUM_DANA_ZA_OTKAZIVANJE;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ZakupVozila vratiBrziZakupVozila(Long zakupId) {
		ZakupVozila zakup = this.vratiJedan(zakupId);
		if(zakup.getRezervacija() == null) {
			return zakup;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ZakupVozila oceniZakup(Long zakupId, int ocena) {
		ZakupVozila zakup = this.vratiJedan(zakupId);
		if(zakup.getOcena() != 0 || zakup.getRezervacija().getAvionskaKarta().getLet().getVremePoletanja().after(new Date())) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			if(ocena <= 5 && ocena >= 1) {
				zakup.setOcena(ocena);
				this.zakupVozilaRepository.save(zakup);
				this.postaviNovuOcenu(zakup.getVozilo().getGaraza().getKompanija());
			} else {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
		}
		return zakup;
	}

	private void postaviNovuOcenu(KompanijaVozila kompanija) {
		double ukupno = 0.0;
		int broj = 0;
		for(Garaza garaza : kompanija.getGaraze()) {
			for(Vozilo vozilo : garaza.getVozila()) {
				for(ZakupVozila zakup : vozilo.getZakupi()) {
					if(zakup.getOcena() != 0) {
						broj++;
						ukupno += zakup.getOcena();
					}
				}
			}
		}
		kompanija.setOcena(ukupno / broj);
		this.kompanijaRepository.save(kompanija);
	}
	
}
