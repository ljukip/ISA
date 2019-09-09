package com.booking.application.model.avionskakompanija;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.model.opsti.Rezervacija;

@Entity
public class AvionskaKarta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
	private double cena;
	
	@ManyToOne
	private Let polazniLet;
	
	@OneToMany(mappedBy = "polaznaAvionskaKarta")
	private List<SedisteNaLetu> sedistaNaPolaznomLetu;
	
	@ManyToOne
	private Let povratniLet;
	
	@OneToMany(mappedBy = "povratnaAvionskaKarta")
	private List<SedisteNaLetu> sedistaNaPovratnomLetu;
	
	@OneToOne
	private Rezervacija rezervacija;
	
	public AvionskaKarta() { }
	
	public AvionskaKarta(AvionskaKartaDTO avionskaKartaDTO) {
		this.id = avionskaKartaDTO.getId();
		this.cena = avionskaKartaDTO.getCena();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

	public Let getPolazniLet() {
		return polazniLet;
	}

	public void setPolazniLet(Let polazniLet) {
		this.polazniLet = polazniLet;
	}

	public List<SedisteNaLetu> getSedistaNaPolaznomLetu() {
		return sedistaNaPolaznomLetu;
	}

	public void setSedistaNaPolaznomLetu(List<SedisteNaLetu> sedistaNaPolaznomLetu) {
		this.sedistaNaPolaznomLetu = sedistaNaPolaznomLetu;
	}

	public Let getPovratniLet() {
		return povratniLet;
	}

	public void setPovratniLet(Let povratniLet) {
		this.povratniLet = povratniLet;
	}

	public List<SedisteNaLetu> getSedistaNaPovratnomLetu() {
		return sedistaNaPovratnomLetu;
	}

	public void setSedistaNaPovratnomLetu(List<SedisteNaLetu> sedistaNaPovratnomLetu) {
		this.sedistaNaPovratnomLetu = sedistaNaPovratnomLetu;
	}
	
}
