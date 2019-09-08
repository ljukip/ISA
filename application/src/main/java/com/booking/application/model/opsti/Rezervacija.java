package com.booking.application.model.opsti;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import com.booking.application.model.hotel.ZakupSoba;
import com.booking.application.model.korisnici.PozivNaRezervaciju;

import com.booking.application.model.korisnici.KorisnikNaRezervaciji;
import com.booking.application.model.avionskakompanija.AvionskaKarta;
import com.booking.application.model.vozila.ZakupVozila;


@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @OneToMany(mappedBy = "rezervacija")
    private List<KorisnikNaRezervaciji> spojKorisnika;
    
    @OneToOne
    private ZakupSoba zakupSoba;

    @OneToOne
    private ZakupVozila zakupVozila;
    
    @OneToOne
    private AvionskaKarta avionskaKarta;

    @OneToMany(mappedBy = "rezervacija")
    private List<PozivNaRezervaciju> pozivi;
    
    
    public Rezervacija() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public List<KorisnikNaRezervaciji> getSpojKorisnika() {
		return spojKorisnika;
	}

	public void setSpojKorisnika(List<KorisnikNaRezervaciji> spojKorisnika) {
		this.spojKorisnika = spojKorisnika;
	}

	public ZakupSoba getZakupSoba() {
		return zakupSoba;
	}

	public void setZakupSoba(ZakupSoba zakupSoba) {
		this.zakupSoba = zakupSoba;
	}

	public ZakupVozila getZakupVozila() {
		return zakupVozila;
	}

	public void setZakupVozila(ZakupVozila zakupVozila) {
		this.zakupVozila = zakupVozila;
	}

	public AvionskaKarta getAvionskaKarta() {
		return avionskaKarta;
	}

	public void setAvionskaKarta(AvionskaKarta avionskaKarta) {
		this.avionskaKarta = avionskaKarta;
	}
	


	public List<PozivNaRezervaciju> getPozivi() {
		return pozivi;
	}

	public void setPozivi(List<PozivNaRezervaciju> pozivi) {
		this.pozivi = pozivi;
	}
	
}
