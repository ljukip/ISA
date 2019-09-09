package com.booking.application.service.avionskakompanija;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.avionskakompanija.Avion;
import com.booking.application.model.avionskakompanija.KlasaSedista;
import com.booking.application.model.avionskakompanija.SedisteAviona;
import com.booking.application.repository.avionskakompanija.SedisteAvionaRepository;

@Service
public class SedisteAvionaService {

	@Autowired
	private SedisteAvionaRepository sedisteAvionaRepository;
	
	@Autowired
	private AvionService avionService;

	public List<SedisteAviona> vratiSedistaAviona(Long kompanijaId, Long avionId) {
		Avion avion = this.avionService.vratiAvionKompanije(kompanijaId, avionId);
		return avion.getSedista();
	}
	
	private SedisteAviona vratiJedno(Long sedisteId) {
		Optional<SedisteAviona> sediste = this.sedisteAvionaRepository.findById(sedisteId);
		if(sediste.isPresent()) {
			return sediste.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public SedisteAviona vratiSedisteAviona(Long kompanijaId, Long avionId, Long sedisteId) {
		Avion avion = this.avionService.vratiAvionKompanije(kompanijaId, avionId);
		SedisteAviona sediste = this.vratiJedno(sedisteId);
		if(sediste.getAvion().equals(avion)) {
			return sediste;
		} else {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}
	}

	public List<SedisteAviona> kreiraj(Long kompanijaId, 
			Long avionId, 
			int brojRedova, 
			int brojKolona,
			KlasaSedista klasa) {
		Avion avion = this.avionService.vratiAvionKompanije(kompanijaId, avionId);
		if(avion.getSedista().isEmpty()) {
			List<SedisteAviona> sedista = this.napraviMatricu(brojRedova, brojKolona, klasa);
			for(SedisteAviona sediste : sedista) {
				sediste.setAvion(avion);
			}
			this.sedisteAvionaRepository.saveAll(sedista);
			return sedista;
		} else {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
	}
	
	private List<SedisteAviona> napraviMatricu(int brojRedova, int brojKolona, KlasaSedista klasa) {
		List<SedisteAviona> rezultat = new ArrayList<SedisteAviona>();
		for(int i = 1; i <= brojRedova; i++) {
			for(int j = 1; j <= brojKolona; j++) {
				SedisteAviona sediste = new SedisteAviona();
				sediste.setRed(i);
				sediste.setKolona(j);
				sediste.setKlasa(klasa);
				rezultat.add(sediste);
			}
		}
		return rezultat;
	}

	public SedisteAviona azuriraj(Long kompanijaId, Long avionId, SedisteAviona novoSediste) {
		SedisteAviona staroSediste = this.vratiSedisteAviona(kompanijaId, avionId, novoSediste.getId());
		if(!this.dozvoljenaIzmena(staroSediste)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		staroSediste.prekopiraj(novoSediste);
		this.sedisteAvionaRepository.save(staroSediste);
		return staroSediste;
	}
	
	public void obrisi(Long kompanijaId, Long avionId, Long sedisteId) {
		SedisteAviona sediste = this.vratiSedisteAviona(kompanijaId, avionId, sedisteId);
		if(!this.dozvoljenaIzmena(sediste)) {
			throw new ResponseStatusException(HttpStatus.CONFLICT);
		}
		this.sedisteAvionaRepository.delete(sediste);
	}
	
	private boolean dozvoljenaIzmena(SedisteAviona sediste) {
		return sediste.getAvion().getLetovi().isEmpty();
	}
	
}
