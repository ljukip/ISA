package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.avionskakompanija.Avion;

public class AvionDTO {

    private Long id;
	private String naziv;
	private String opis;
	private AvionskaKompanijaDTO avionskaKompanijaDTO;
	
	public AvionDTO() { }
	
	public AvionDTO(Avion avion) {
		this.id = avion.getId();
		this.naziv = avion.getNaziv();
		this.opis = avion.getOpis();
		this.avionskaKompanijaDTO = new AvionskaKompanijaDTO(avion.getAvionskaKompanija());
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

	public AvionskaKompanijaDTO getAvionskaKompanijaDTO() {
		return avionskaKompanijaDTO;
	}

	public void setAvionskaKompanijaDTO(AvionskaKompanijaDTO avionskaKompanijaDTO) {
		this.avionskaKompanijaDTO = avionskaKompanijaDTO;
	}

	public static List<AvionDTO> transformisi(List<Avion> avioni) {
		List<AvionDTO> rezultat = new ArrayList<AvionDTO>();
		for(Avion avion : avioni) {
			rezultat.add(new AvionDTO(avion));
		}
		return rezultat;
	}
	
}
