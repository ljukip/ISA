package com.booking.application.model.opsti;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.model.avionskakompanija.AvionskaKarta;
import com.booking.application.model.hotel.ZakupSobe;
import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.korisnici.PozivNaRezervaciju;
import com.booking.application.model.vozila.ZakupVozila;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private boolean kompletirana;
    
    @OneToOne
    private ZakupSobe zakupSoba;
    
    @OneToOne
    private ZakupVozila zakupVozila;
    
    @OneToOne
    private AvionskaKarta avionskaKarta;
    
    @ManyToOne
    private Korisnik vlasnik;
    
    @ManyToMany(mappedBy = "gostujuceRezervacije")
    private List<Korisnik> korisnici;
    
    @OneToMany(mappedBy = "rezervacija")
    private List<PozivNaRezervaciju> pozivi;
    
    public Rezervacija() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ZakupSobe getZakupSoba() {
		return zakupSoba;
	}

	public void setZakupSoba(ZakupSobe zakupSoba) {
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

	public boolean isKompletirana() {
		return kompletirana;
	}

	public void setKompletirana(boolean kompletirana) {
		this.kompletirana = kompletirana;
	}

	public List<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(List<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}

	public Korisnik getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(Korisnik vlasnik) {
		this.vlasnik = vlasnik;
	}
	
}
