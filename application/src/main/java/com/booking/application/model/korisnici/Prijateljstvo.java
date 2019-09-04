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

@Entity
public class Prijateljstvo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date vremeKreiranja;
    
    @ManyToOne
    private Korisnik prijatelj1;
    
    @ManyToOne
    private Korisnik prijatelj2;
    
    public Prijateljstvo() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVremeKreiranja() {
		return vremeKreiranja;
	}

	public void setVremeKreiranja(Date vremeKreiranja) {
		this.vremeKreiranja = vremeKreiranja;
	}

	public Korisnik getPrijatelj1() {
		return prijatelj1;
	}

	public void setPrijatelj1(Korisnik prijatelj1) {
		this.prijatelj1 = prijatelj1;
	}

	public Korisnik getPrijatelj2() {
		return prijatelj2;
	}

	public void setPrijatelj2(Korisnik prijatelj2) {
		this.prijatelj2 = prijatelj2;
	}
    
}
