package com.booking.application.model.korisnici;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.booking.application.model.opsti.Rezervacija;

@Entity
public class PozivNaRezervaciju {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date vremeSlanja;
    
    @ManyToOne
    private Korisnik poslao;
    
    @ManyToOne
    private Korisnik primio;
	
    @ManyToOne
    private Rezervacija rezervacija;
    
    public PozivNaRezervaciju() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVremeSlanja() {
		return vremeSlanja;
	}

	public void setVremeSlanja(Date vremeSlanja) {
		this.vremeSlanja = vremeSlanja;
	}

	public Korisnik getPoslao() {
		return poslao;
	}

	public void setPoslao(Korisnik poslao) {
		this.poslao = poslao;
	}

	public Korisnik getPrimio() {
		return primio;
	}

	public void setPrimio(Korisnik primio) {
		this.primio = primio;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}
    
}
