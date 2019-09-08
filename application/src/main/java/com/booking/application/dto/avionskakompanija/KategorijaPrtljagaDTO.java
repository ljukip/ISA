package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.avionskakompanija.KategorijaPrtljaga;

public class KategorijaPrtljagaDTO {

    private Long id;
	private String naziv;
	private double cena;
	private double kolicina;
	private AvionskaKompanijaDTO avionskaKompanijaDTO;
	
	public KategorijaPrtljagaDTO() { }
	
	public KategorijaPrtljagaDTO(KategorijaPrtljaga kategorijaPrtljaga) {
		this.id = kategorijaPrtljaga.getId();
		this.naziv = kategorijaPrtljaga.getNaziv();
		this.cena = kategorijaPrtljaga.getCena();
		this.kolicina = kategorijaPrtljaga.getKolicina();
		this.avionskaKompanijaDTO = new AvionskaKompanijaDTO(kategorijaPrtljaga.getAvionskaKompanija());
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

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public AvionskaKompanijaDTO getAvionskaKompanija() {
		return avionskaKompanijaDTO;
	}

	public void setAvionskaKompanija(AvionskaKompanijaDTO avionskaKompanijaDTO) {
		this.avionskaKompanijaDTO = avionskaKompanijaDTO;
	}

	public static List<KategorijaPrtljagaDTO> transformisi(List<KategorijaPrtljaga> kategorije) {
		List<KategorijaPrtljagaDTO> rezultat = new ArrayList<KategorijaPrtljagaDTO>();
		for(KategorijaPrtljaga kategorija : kategorije) {
			rezultat.add(new KategorijaPrtljagaDTO(kategorija));
		}
		return rezultat;
	}
	
}
