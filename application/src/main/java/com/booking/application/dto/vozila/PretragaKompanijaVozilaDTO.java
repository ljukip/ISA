package com.booking.application.dto.vozila;

import java.time.LocalDate;

import com.booking.application.dto.opsti.DestinacijaDTO;

public class PretragaKompanijaVozilaDTO {

	private String naziv;
	private DestinacijaDTO destinacija;
	private LocalDate pocetak;
	private LocalDate kraj;
	
	public PretragaKompanijaVozilaDTO() { }

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public DestinacijaDTO getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(DestinacijaDTO destinacija) {
		this.destinacija = destinacija;
	}

	public LocalDate getPocetak() {
		return pocetak;
	}

	public void setPocetak(LocalDate pocetak) {
		this.pocetak = pocetak;
	}

	public LocalDate getKraj() {
		return kraj;
	}

	public void setKraj(LocalDate kraj) {
		this.kraj = kraj;
	}
	
}
