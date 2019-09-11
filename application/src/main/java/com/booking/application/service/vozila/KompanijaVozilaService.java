package com.booking.application.service.vozila;

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

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.dto.vozila.PretragaKompanijaVozilaDTO;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.model.vozila.Vozilo;
import com.booking.application.model.vozila.ZakupVozila;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.repository.vozila.KompanijaVozilaRepository;
import com.booking.application.service.opsti.AdresaService;

@Service
public class KompanijaVozilaService {

	@Autowired
	private KompanijaVozilaRepository kompanijaVozilaRepository;

	@Autowired
	private AdresaService adresaService;
	
	@Autowired
	private AdresaRepository adresaRepository;
	
	@Autowired
	private ZakupVozilaService zakupVozilaService;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<KompanijaVozila> vratiSve(Pageable page) {
		
		Page<KompanijaVozila> pageOfCompany = this.kompanijaVozilaRepository.findAll(page);
		List<KompanijaVozila> listOfCompany = new ArrayList<KompanijaVozila>();
		pageOfCompany.forEach(item -> {
			listOfCompany.add(item);
		});
		
		return listOfCompany;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KompanijaVozila vratiJednu(Long id) {
		Optional<KompanijaVozila> kompanija = this.kompanijaVozilaRepository.findById(id);
		if(kompanija.isPresent()) {
			return kompanija.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KompanijaVozila kreiraj(KompanijaVozila kompanijaVozila, AdresaDTO adresaDTO) {
		Adresa adresa = this.adresaService.kreiraj(new Adresa(adresaDTO));
		kompanijaVozila.setAdresa(adresa);
		kompanijaVozila.setOcena(0.0);
		KompanijaVozila kreiranaKompanija = this.kompanijaVozilaRepository.save(kompanijaVozila);
		adresa.setKompanijaVozila(kreiranaKompanija);
		this.adresaRepository.save(adresa);
		return kreiranaKompanija;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KompanijaVozila azuriraj(KompanijaVozila novaKompanija, AdresaDTO adresaDTO) {
		KompanijaVozila staraKompanija = this.vratiJednu(novaKompanija.getId());
		staraKompanija.prekopiraj(novaKompanija);
		this.kompanijaVozilaRepository.save(staraKompanija);
		staraKompanija.getAdresa().prekopiraj(adresaDTO);
		this.adresaRepository.save(staraKompanija.getAdresa());
		return staraKompanija;
	}

	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisi(Long id) {
		KompanijaVozila kompanija = this.vratiJednu(id);
		if(this.dozvoljenaIzmena(kompanija)) {
			Adresa adresa = kompanija.getAdresa();
			this.kompanijaVozilaRepository.delete(kompanija);
			adresa.setKompanijaVozila(null);
			this.adresaRepository.save(adresa);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean dozvoljenaIzmena(KompanijaVozila kompanija) {
		for(Garaza garaza : kompanija.getGaraze()) {
			for(Vozilo vozilo : garaza.getVozila()) {
				if(!vozilo.getZakupi().isEmpty()) {
					return false;
				}
			}
		}
		return true;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Double izracunajPrihod(LocalDate pocetak, LocalDate kraj, Long kompanijaId) {
		KompanijaVozila kompanija = this.vratiJednu(kompanijaId);
		Double prihod = 0.0;
		for(Garaza garaza : kompanija.getGaraze()) {
			for(Vozilo vozilo : garaza.getVozila()) {
				for(ZakupVozila zakup : vozilo.getZakupi()) {
					if(!(zakup.getPocetniDatum().isAfter(pocetak) && zakup.getKrajnjiDatum().isBefore(kraj))) continue;
					prihod += zakup.getCenaZakupa();
				}
			}
		}
		return prihod;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<String> izracunajStatistiku(LocalDate pocetak, LocalDate kraj, Long kompanijaId) {
		KompanijaVozila kompanija = this.vratiJednu(kompanijaId);
		HashMap<LocalDate, Integer> statistika = new HashMap<LocalDate, Integer>();
		for(Garaza garaza : kompanija.getGaraze()) {
			for(Vozilo vozilo : garaza.getVozila()) {
				for(ZakupVozila zakup : vozilo.getZakupi()) {
					if(!(zakup.getPocetniDatum().isAfter(pocetak) && zakup.getPocetniDatum().isBefore(kraj))) continue;
					LocalDate pocetniDatum = zakup.getPocetniDatum();
					if(statistika.containsKey(pocetniDatum)) {
						statistika.put(pocetniDatum, statistika.get(pocetniDatum) + 1);
					} else {
						statistika.put(pocetniDatum, 1);
					}
				}
			}
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<String> rezultat = new ArrayList<String>();
		for(LocalDate datum : statistika.keySet()) {
			rezultat.add(formatter.format(datum) + "=" + statistika.get(datum));
		}
		return rezultat;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<KompanijaVozila> pretrazi(PretragaKompanijaVozilaDTO pretragaDTO) {
		List<KompanijaVozila> rezultat = this.kompanijaVozilaRepository.findAll();
		if(!pretragaDTO.getNaziv().isEmpty()) rezultat.removeIf(x -> !(x.getNaziv().toUpperCase().contains(pretragaDTO.getNaziv().toUpperCase())));
		if(!pretragaDTO.getDestinacija().getGrad().isEmpty()) rezultat.removeIf(x -> !(x.getAdresa().getGrad().equalsIgnoreCase(pretragaDTO.getDestinacija().getGrad()) && x.getAdresa().getZemlja().equalsIgnoreCase(pretragaDTO.getDestinacija().getZemlja())));
		rezultat.removeIf(x -> !(this.imaBarJednoSlobodnoVozilo(x, pretragaDTO.getPocetak(), pretragaDTO.getKraj())));
		return rezultat;
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	private boolean imaBarJednoSlobodnoVozilo(KompanijaVozila kompanija, LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		for(Garaza garaza : kompanija.getGaraze()) {
			for(Vozilo vozilo : garaza.getVozila()) {
				if(zakupVozilaService.voziloJeSlobodno(vozilo, pocetniDatum, krajnjiDatum)) return true;
			}
		}
		return false;
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public KompanijaVozila vratiNeku() {
		List<KompanijaVozila> sve = this.kompanijaVozilaRepository.findAll();
		if(sve.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		} else {
			return sve.get(0);
		}
	}
	
}
