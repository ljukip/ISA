package com.booking.application.dto.vozila;

import java.time.LocalDate;

import com.booking.application.model.vozila.TipVozila;

public class PretragaVozilaDTO {

	private LocalDate pocetniDatum;
	private LocalDate krajnjiDatum;
	private TipVozila tip;
	private double pocetnaCena;
	private double krajnjaCena;
	private int brojPutnika;
	
	public PretragaVozilaDTO() { }

	public LocalDate getPocetniDatum() {
		return pocetniDatum;
	}

	public void setPocetniDatum(LocalDate pocetniDatum) {
		this.pocetniDatum = pocetniDatum;
	}

	public LocalDate getKrajnjiDatum() {
		return krajnjiDatum;
	}

	public void setKrajnjiDatum(LocalDate krajnjiDatum) {
		this.krajnjiDatum = krajnjiDatum;
	}

	public TipVozila getTip() {
		return tip;
	}

	public void setTip(TipVozila tip) {
		this.tip = tip;
	}

	public double getPocetnaCena() {
		return pocetnaCena;
	}

	public void setPocetnaCena(double pocetnaCena) {
		this.pocetnaCena = pocetnaCena;
	}

	public double getKrajnjaCena() {
		return krajnjaCena;
	}

	public void setKrajnjaCena(double krajnjaCena) {
		this.krajnjaCena = krajnjaCena;
	}

	public int getBrojPutnika() {
		return brojPutnika;
	}

	public void setBrojPutnika(int brojPutnika) {
		this.brojPutnika = brojPutnika;
	}
	
}
