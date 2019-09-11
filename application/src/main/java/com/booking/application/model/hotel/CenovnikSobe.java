package com.booking.application.model.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.booking.application.dto.hotel.CenovnikSobeDTO;

@Entity
public class CenovnikSobe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
	private LocalDate pocetniDatum;
	@Column(nullable = false)
	private LocalDate krajnjiDatum;
	@Column(nullable = false)
	@Min(value = 0)
	private double cena;
	
	@ManyToOne
	private Soba soba;

	public CenovnikSobe() { }
	
	public CenovnikSobe(CenovnikSobeDTO cenovnikSobeDTO) {
		this.id = cenovnikSobeDTO.getId();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.pocetniDatum = LocalDate.parse(cenovnikSobeDTO.getPocetniDatum(), formatter);
		this.krajnjiDatum = LocalDate.parse(cenovnikSobeDTO.getKrajnjiDatum(), formatter);
		this.cena = cenovnikSobeDTO.getCena();
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

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void prekopiraj(CenovnikSobe noviCenovnik) {
		this.pocetniDatum = noviCenovnik.getPocetniDatum();
		this.krajnjiDatum = noviCenovnik.getKrajnjiDatum();
		this.cena = noviCenovnik.getCena();
	}
	
}
