package com.booking.application.model.avionskakompanija;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.booking.application.dto.avionskakompanija.AvionDTO;

@Entity
public class Avion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 32, nullable = false)
	private String naziv;
	@Column(length = 512, nullable = true)
	private String opis;
	
	@ManyToOne
	private AvionskaKompanija avionskaKompanija;
	
	@OneToMany(mappedBy = "avion")
	private List<Let> letovi;
	
	@OneToMany(mappedBy = "avion")
	private List<SedisteAviona> sedista;
	
	public Avion() { }
	
	public Avion(AvionDTO avionDTO) {
		this.id = avionDTO.getId();
		this.naziv = avionDTO.getNaziv();
		this.opis = avionDTO.getOpis();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public AvionskaKompanija getAvionskaKompanija() {
		return avionskaKompanija;
	}

	public void setAvionskaKompanija(AvionskaKompanija avionskaKompanija) {
		this.avionskaKompanija = avionskaKompanija;
	}

	public void prekopiraj(Avion novi) {
		this.id = novi.getId();
		this.naziv = novi.getNaziv();
		this.opis = novi.getOpis();
	}

	public List<Let> getLetovi() {
		return letovi;
	}

	public void setLetovi(List<Let> letovi) {
		this.letovi = letovi;
	}

	public List<SedisteAviona> getSedista() {
		return sedista;
	}

	public void setSedista(List<SedisteAviona> sedista) {
		this.sedista = sedista;
	}
	
}
