package com.booking.application.model.avionskakompanija;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;

@Entity
public class AvionskaKarta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(nullable = false)
	private double cena;
	
	@Column(nullable = true)
	private double ocena;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipZakupa tip;
	
	@ManyToOne
	private Let let;
	
	@OneToMany(mappedBy = "avionskaKarta", fetch = FetchType.EAGER)
	private List<Sediste> sedista;
	
	@OneToOne
	private Rezervacija rezervacija;
	
	public AvionskaKarta() { }
	
	public AvionskaKarta(AvionskaKartaDTO avionskaKartaDTO) {
		this.id = avionskaKartaDTO.getId();
		this.cena = avionskaKartaDTO.getCena();
		this.ocena = avionskaKartaDTO.getOcena();
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

	public Let getLet() {
		return let;
	}

	public void setLet(Let let) {
		this.let = let;
	}

	public List<Sediste> getSedista() {
		return sedista;
	}

	public void setSedista(List<Sediste> sedista) {
		this.sedista = sedista;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public TipZakupa getTip() {
		return tip;
	}

	public void setTip(TipZakupa tip) {
		this.tip = tip;
	}
	
}
