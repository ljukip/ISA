package com.booking.application.service.avionskakompanija;

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

import com.booking.application.dto.avionskakompanija.LetDTO;
import com.booking.application.dto.avionskakompanija.PretragaLetaDTO;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.avionskakompanija.Let;
import com.booking.application.model.opsti.Destinacija;
import com.booking.application.repository.avionskakompanija.LetRepository;
import com.booking.application.repository.avionskakompanija.SedisteRepository;
import com.booking.application.service.opsti.DestinacijaService;
import com.booking.application.utils.VremeDatumUtils;

@Service
public class LetService {

	@Autowired
	private LetRepository letRepository;
	
	@Autowired
	private AvionskaKompanijaService avionskaKompanijaService;
	
	@Autowired
	private DestinacijaService destinacijaService;
	
	@Autowired
	private SedisteService sedisteService;
	
	@Autowired
	private SedisteRepository sedisteRepository;
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Let vratiLet(Long id) {
		Optional<Let> let = this.letRepository.findById(id);
		if(let.isPresent()) {
			return let.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Let vratiLetKompanije(Long id, Long kompanija) {
		Let let = this.vratiLet(id);
		if(let.getAvionskaKompanija().getId().equals(kompanija)) {
			return let;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public Let kreirajLet(LetDTO letDTO, Long avionskaKompanija) {
		AvionskaKompanija kompanija = this.avionskaKompanijaService.vratiJednu(avionskaKompanija);
		Destinacija polaziste = this.destinacijaService.vratiJednu(letDTO.getPolazisteDTO().getId());
		Destinacija odrediste = this.destinacijaService.vratiJednu(letDTO.getOdredisteDTO().getId());
		if(polaziste.equals(odrediste)) throw new ResponseStatusException(HttpStatus.CONFLICT);
		if(letDTO.getVremePoletanja().before(new Date())) throw new ResponseStatusException(HttpStatus.CONFLICT);
		if(letDTO.getVremePoletanja().after(letDTO.getVremeSletanja())) throw new ResponseStatusException(HttpStatus.CONFLICT);
		Let let = new Let(letDTO);
		let.setVremePoletanja(letDTO.getVremePoletanja());
		let.setVremeSletanja(letDTO.getVremeSletanja());
		let.setVremePutovanja(VremeDatumUtils.razlikaUSatima(let.getVremePoletanja(), let.getVremeSletanja()));
		let.setDuzina(letDTO.getDuzina());
		let.setCena(letDTO.getCena());
		let.setTip(letDTO.getTip());
		let.setPolaziste(polaziste);
		let.setOdrediste(odrediste);
		let.setAvionskaKompanija(kompanija);
		let.setPresedanja(letDTO.getPresedanja());
		Let sacuvaniLet = this.letRepository.save(let);
		this.sedisteService.izgenerisiSedista(sacuvaniLet);
		return sacuvaniLet;
	}
	
	@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void obrisiLet(Long id, Long kompanija) {
		Let let = this.vratiLetKompanije(id, kompanija);
		if(let.getAvionskeKarte().isEmpty()) {
			this.sedisteRepository.deleteAll(let.getSedista());
			this.letRepository.delete(let);
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}

	@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public List<Let> vratiLetoveKompanije(Long kompanija) {
		AvionskaKompanija avionskaKompanija = this.avionskaKompanijaService.vratiJednu(kompanija);
		return avionskaKompanija.getLetovi();
	}

	public List<Let> pretraziLetove(PretragaLetaDTO pretragaDTO, Long kompanija) {
		AvionskaKompanija avionskaKompanija = this.avionskaKompanijaService.vratiJednu(kompanija);
		List<Let> rezultat = new ArrayList<Let>();
		for(Let let : avionskaKompanija.getLetovi()) {
			if(!let.getPolaziste().getGrad().equalsIgnoreCase(pretragaDTO.getGradPoletanja())) continue;
			if(!let.getOdrediste().getGrad().equalsIgnoreCase(pretragaDTO.getGradSletanja())) continue;
			if(!let.getVremePoletanja().after(pretragaDTO.getDatumPoletanja())) continue;
			if(!let.getVremeSletanja().before(pretragaDTO.getDatumSletanja())) continue;
			rezultat.add(let);
		}
		return rezultat;
	}
	
}
