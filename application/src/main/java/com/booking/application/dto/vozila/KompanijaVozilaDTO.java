package com.booking.application.dto.vozila;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.vozila.KompanijaVozila;

public class KompanijaVozilaDTO {

    private Long id;
	private String naziv;
	private String opis;
	private AdresaDTO adresa;
	
	public KompanijaVozilaDTO() { }
	
	public KompanijaVozilaDTO(KompanijaVozila kompanija) {
		this.id = kompanija.getId();
		this.naziv = kompanija.getNaziv();
		this.opis = kompanija.getOpis();
		this.adresa = new AdresaDTO(kompanija.getAdresa());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}
	
	public static List<KompanijaVozilaDTO> transformisi(List<KompanijaVozila> kompanije) {
		List<KompanijaVozilaDTO> rezultat = new ArrayList<KompanijaVozilaDTO>();
		for(KompanijaVozila kompanija : kompanije) {
			rezultat.add(new KompanijaVozilaDTO(kompanija));
		}
		return rezultat;
	}
	
}
