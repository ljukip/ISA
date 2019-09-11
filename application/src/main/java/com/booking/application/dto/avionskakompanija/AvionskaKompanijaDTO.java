package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;

public class AvionskaKompanijaDTO {

    private Long id;
	private String naziv;
	private String opis;
	private double prosecnaOcena;
	private AdresaDTO adresaDTO;
	
	public AvionskaKompanijaDTO() { }
	
	public AvionskaKompanijaDTO(AvionskaKompanija avionskaKompanija) {
		this.id = avionskaKompanija.getId();
		this.naziv = avionskaKompanija.getNaziv();
		this.opis = avionskaKompanija.getOpis();
		this.adresaDTO = new AdresaDTO(avionskaKompanija.getAdresa());
		this.prosecnaOcena = avionskaKompanija.getOcena();
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

	public AdresaDTO getAdresaDTO() {
		return adresaDTO;
	}

	public void setAdresaDTO(AdresaDTO adresaDTO) {
		this.adresaDTO = adresaDTO;
	}

	public static List<AvionskaKompanijaDTO> transformisi(List<AvionskaKompanija> avionskeKompanije) {
		List<AvionskaKompanijaDTO> rezultat = new ArrayList<AvionskaKompanijaDTO>();
		for(AvionskaKompanija avionskaKompanija : avionskeKompanije) {
			rezultat.add(new AvionskaKompanijaDTO(avionskaKompanija));
		}
		return rezultat;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double ocena) {
		this.prosecnaOcena = ocena;
	}
	
}
