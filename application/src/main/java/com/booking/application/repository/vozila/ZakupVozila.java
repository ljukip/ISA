package com.booking.application.model.vozila;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import com.booking.application.dto.vozila.ZakupVozilaDTO;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;

@Entity
public class ZakupVozila {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate pocetniDatum;
	
	@Column(nullable = false)
	private LocalDate krajnjiDatum;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double cenaZakupa;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double dodatniPopust;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double popustNaTip;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipZakupa tip;
	
	@Column(nullable = true)
	private double ocena;
	
	@ManyToOne
	private Vozilo vozilo;
	
	@OneToOne
	private Rezervacija rezervacija;
	
	public ZakupVozila() { }

	public ZakupVozila(ZakupVozilaDTO zakupDTO) {
		this.id = zakupDTO.getId();
		this.pocetniDatum = zakupDTO.getPocetniDatum();
		this.krajnjiDatum = zakupDTO.getKrajnjiDatum();
		this.cenaZakupa = zakupDTO.getCenaZakupa();
		this.dodatniPopust = zakupDTO.getDodatniPopust();
		this.popustNaTip = zakupDTO.getPopustNaTip();
		this.tip = zakupDTO.getTip();
		this.ocena = zakupDTO.getOcena();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public double getCenaZakupa() {
		return cenaZakupa;
	}

	public void setCenaZakupa(double cenaZakupa) {
		this.cenaZakupa = cenaZakupa;
	}

	public double getDodatniPopust() {
		return dodatniPopust;
	}

	public void setDodatniPopust(double dodatniPopust) {
		this.dodatniPopust = dodatniPopust;
	}

	public double getPopustNaTip() {
		return popustNaTip;
	}

	public void setPopustNaTip(double popustNaTip) {
		this.popustNaTip = popustNaTip;
	}

	public TipZakupa getTip() {
		return tip;
	}

	public void setTip(TipZakupa tip) {
		this.tip = tip;
	}

	public Vozilo getVozilo() {
		return vozilo;
	}

	public void setVozilo(Vozilo vozilo) {
		this.vozilo = vozilo;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	
}
