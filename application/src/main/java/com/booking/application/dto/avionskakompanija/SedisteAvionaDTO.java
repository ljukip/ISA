package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.avionskakompanija.KlasaSedista;
import com.booking.application.model.avionskakompanija.SedisteAviona;

public class SedisteAvionaDTO {

    private Long id;
    private int red;
	private int kolona;
	private KlasaSedista klasa;
	
	public SedisteAvionaDTO() { }
	
	public SedisteAvionaDTO(SedisteAviona sediste) {
		this.id = sediste.getId();
		this.red = sediste.getRed();
		this.kolona = sediste.getKolona();
		this.klasa = sediste.getKlasa();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getKolona() {
		return kolona;
	}

	public void setKolona(int kolona) {
		this.kolona = kolona;
	}

	public KlasaSedista getKlasa() {
		return klasa;
	}

	public void setKlasa(KlasaSedista klasa) {
		this.klasa = klasa;
	}
	
	public static List<SedisteAvionaDTO> transformisi(List<SedisteAviona> sedista) {
		List<SedisteAvionaDTO> rezultat = new ArrayList<SedisteAvionaDTO>();
		for(SedisteAviona sediste : sedista) {
			rezultat.add(new SedisteAvionaDTO(sediste));
		}
		return rezultat;
	}
	
}
