package com.booking.application.model.vozila;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.dto.vozila.GarazaDTO;
import com.booking.application.model.opsti.Adresa;

@Entity
public class Garaza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private KompanijaVozila kompanija;
    
    @OneToOne
    private Adresa adresa;
    
    @OneToMany(mappedBy = "garaza")
    private List<Vozilo> vozila;
    
    public Garaza() { }

	public Garaza(GarazaDTO garaza) {
		this.id = garaza.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KompanijaVozila getKompanija() {
		return kompanija;
	}

	public void setKompanija(KompanijaVozila kompanija) {
		this.kompanija = kompanija;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public List<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(List<Vozilo> vozila) {
		this.vozila = vozila;
	}

}
