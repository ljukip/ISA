package com.booking.application.model.vozila;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.dto.vozila.KompanijaVozilaDTO;
import com.booking.application.model.korisnici.AdminKompanije;
import com.booking.application.model.opsti.Adresa;

@Entity
public class KompanijaVozila {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 32, nullable = false)
	private String naziv;
	@Column(length = 512, nullable = true)
	private String opis;
	
	@OneToOne
	private Adresa adresa;
	
	@OneToMany(mappedBy = "kompanijaVozila")
	private List<AdminKompanije> admini;
	
	@OneToMany(mappedBy = "kompanija")
	private List<Garaza> garaze;
	
	public KompanijaVozila() { }

	public KompanijaVozila(KompanijaVozilaDTO kompanijaDTO) {
		this.id = kompanijaDTO.getId();
		this.naziv = kompanijaDTO.getNaziv();
		this.opis = kompanijaDTO.getOpis();
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

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public List<Garaza> getGaraze() {
		return garaze;
	}

	public void setGaraze(List<Garaza> garaze) {
		this.garaze = garaze;
	}

	public void prekopiraj(KompanijaVozila novaKompanija) {
		this.id = novaKompanija.getId();
		this.naziv = novaKompanija.getNaziv();
		this.opis = novaKompanija.getOpis();
	}

	public List<AdminKompanije> getAdmini() {
		return admini;
	}

	public void setAdmini(List<AdminKompanije> admini) {
		this.admini = admini;
	}
	
}
