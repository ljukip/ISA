package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.avionskakompanija.KlasaSedista;
import com.booking.application.model.avionskakompanija.SedisteNaLetu;

public class SedisteNaLetuDTO {

    private Long id;
    private int red;
    private int kolona;
	private KlasaSedista klasa;
    private double cena;
    private KategorijaPrtljagaDTO kategorijaPrtljagaDTO;
	
    public SedisteNaLetuDTO() { }
    
    public SedisteNaLetuDTO(SedisteNaLetu sediste) {
    	this.id = sediste.getId();
    	this.red = sediste.getRed();
    	this.kolona = sediste.getKolona();
    	this.klasa = sediste.getKlasa();
    	this.cena = sediste.getCena();
    	this.kategorijaPrtljagaDTO = new KategorijaPrtljagaDTO(sediste.getKategorijaPrtljaga());
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

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public KategorijaPrtljagaDTO getKategorijaPrtljagaDTO() {
		return kategorijaPrtljagaDTO;
	}

	public void setKategorijaPrtljagaDTO(KategorijaPrtljagaDTO kategorijaPrtljagaDTO) {
		this.kategorijaPrtljagaDTO = kategorijaPrtljagaDTO;
	}
    
	public static List<SedisteNaLetuDTO> transformisi(List<SedisteNaLetu> sedista) {
		List<SedisteNaLetuDTO> rezultat = new ArrayList<SedisteNaLetuDTO>();
		for(SedisteNaLetu sediste : sedista) {
			rezultat.add(new SedisteNaLetuDTO(sediste));
		}
		return rezultat;
	}
	
}
