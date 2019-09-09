package com.booking.application.model.avionskakompanija;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.dto.avionskakompanija.AvionskaKompanijaDTO;
import com.booking.application.model.korisnici.AdminKompanije;
import com.booking.application.model.opsti.Adresa;

@Entity
public class AvionskaKompanija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 32, nullable = false)
	private String naziv;
	@Column(length = 512, nullable = true)
	private String opis;
	
	@OneToOne
	private Adresa adresa;
	
	@OneToMany(mappedBy = "avionskaKompanija")
	private List<Avion> avioni;
	
	@OneToMany(mappedBy = "avionskaKompanija")
	private List<Let> letovi;
	
	@OneToMany(mappedBy = "avionskaKompanija")
	private List<KategorijaPrtljaga> kategorijePrtljaga;
	
	@OneToMany(mappedBy = "avionskaKompanija")
	private List<AdminKompanije> admini;
	
	public AvionskaKompanija() { }

	public AvionskaKompanija(AvionskaKompanijaDTO avionskaKompanijaDTO) {
		this.id = avionskaKompanijaDTO.getId();
		this.naziv = avionskaKompanijaDTO.getNaziv();
		this.opis = avionskaKompanijaDTO.getOpis();
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

	public List<AdminKompanije> getAdmini() {
		return admini;
	}

	public void setAdmini(List<AdminKompanije> admini) {
		this.admini = admini;
	}

	public void prekopiraj(AvionskaKompanija novaKompanija) {
		this.id = novaKompanija.getId();
		this.naziv = novaKompanija.getNaziv();
		this.opis = novaKompanija.getOpis();
	}

	public List<Avion> getAvioni() {
		return avioni;
	}

	public void setAvioni(List<Avion> avioni) {
		this.avioni = avioni;
	}

	public List<Let> getLetovi() {
		return letovi;
	}

	public void setLetovi(List<Let> letovi) {
		this.letovi = letovi;
	}

	public List<KategorijaPrtljaga> getKategorijePrtljaga() {
		return kategorijePrtljaga;
	}

	public void setKategorijePrtljaga(List<KategorijaPrtljaga> kategorijePrtljaga) {
		this.kategorijePrtljaga = kategorijePrtljaga;
	}
	
}
