package com.booking.application.model.avionskakompanija;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.booking.application.dto.avionskakompanija.KategorijaPrtljagaDTO;

@Entity
public class KategorijaPrtljaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 32, nullable = false)
	private String naziv;
	@Column(nullable = false)
	@Min(5)
	private double cena;
	@Column(nullable = false)
	@Min(20)
	private double kolicina;
	
	@ManyToOne
	private AvionskaKompanija avionskaKompanija;
	
	@OneToMany(mappedBy = "kategorijaPrtljaga")
	private List<SedisteNaLetu> sedista;
	
	public KategorijaPrtljaga() { }
	
	public KategorijaPrtljaga(KategorijaPrtljagaDTO kategorijaPrtljagaDTO) {
		this.id = kategorijaPrtljagaDTO.getId();
		this.naziv = kategorijaPrtljagaDTO.getNaziv();
		this.cena = kategorijaPrtljagaDTO.getCena();
		this.kolicina = kategorijaPrtljagaDTO.getKolicina();
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

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getKolicina() {
		return kolicina;
	}

	public void setKolicina(double kolicina) {
		this.kolicina = kolicina;
	}

	public AvionskaKompanija getAvionskaKompanija() {
		return avionskaKompanija;
	}

	public void setAvionskaKompanija(AvionskaKompanija avionskaKompanija) {
		this.avionskaKompanija = avionskaKompanija;
	}

	public List<SedisteNaLetu> getSedista() {
		return sedista;
	}

	public void setSedista(List<SedisteNaLetu> sedista) {
		this.sedista = sedista;
	}

	public void prekopiraj(KategorijaPrtljaga novaKategorija) {
		this.naziv = novaKategorija.getNaziv();
		this.cena = novaKategorija.getCena();
		this.kolicina = novaKategorija.getKolicina();
	}
	
}
