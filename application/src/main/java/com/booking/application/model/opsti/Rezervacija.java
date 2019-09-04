package com.booking.application.model.opsti;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.model.korisnici.KorisnikNaRezervaciji;

@Entity
public class Rezervacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @OneToMany(mappedBy = "rezervacija")
    private List<KorisnikNaRezervaciji> spojKorisnika;
    
    
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

	
}
