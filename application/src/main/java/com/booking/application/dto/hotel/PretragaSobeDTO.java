package com.booking.application.dto.hotel;

import java.time.LocalDate;

import com.booking.application.model.hotel.TipSobe;

public class PretragaSobeDTO {

	private LocalDate pocetniDatum;
	private LocalDate krajnjiDatum;
	private int brojGostiju;
	private TipSobe tip;
	private double pocetnaCena;
	private double krajnjaCena;
	
	public PretragaSobeDTO() { }

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

	public int getBrojGostiju() {
		return brojGostiju;
	}

	public void setBrojGostiju(int brojGostiju) {
		this.brojGostiju = brojGostiju;
	}

	public TipSobe getTip() {
		return tip;
	}

	public void setTip(TipSobe tip) {
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
	
}
