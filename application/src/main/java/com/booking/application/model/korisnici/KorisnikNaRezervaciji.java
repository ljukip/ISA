package com.booking.application.model.korisnici;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.booking.application.model.opsti.Rezervacija;

@Entity
public class KorisnikNaRezervaciji {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    @Min(value = 1)
    @Max(value = 5)
    private int ocena;
    @Column(nullable = false)
    private boolean vlasnik;
    
    @ManyToOne
    private Korisnik korisnik;
    
    @ManyToOne
    private Rezervacija rezervacija;
    
    public KorisnikNaRezervaciji() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOcena() {
		return ocena;
	}

	public void setOcena(int ocena) {
		this.ocena = ocena;
	}

	public boolean isVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(boolean vlasnik) {
		this.vlasnik = vlasnik;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
    
}
