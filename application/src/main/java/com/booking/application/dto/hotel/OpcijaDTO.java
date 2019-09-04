package com.booking.application.dto.hotel;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.hotel.Opcija;

public class OpcijaDTO {

    private long id;
	private String naziv;
	private double cena;
	
	public OpcijaDTO() { }
	
	public OpcijaDTO(Opcija opcija) {
		this.id = opcija.getId();
		this.naziv = opcija.getNaziv();
		this.cena = opcija.getCena();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
	
	public static List<OpcijaDTO> transformisi(List<Opcija> opcije) {
		List<OpcijaDTO> rezultat = new ArrayList<OpcijaDTO>();
		for(Opcija opcija : opcije) {
			rezultat.add(new OpcijaDTO(opcija));
		}
		return rezultat;
	}
	
}
