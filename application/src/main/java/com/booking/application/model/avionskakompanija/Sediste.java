package com.booking.application.model.avionskakompanija;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.booking.application.dto.avionskakompanija.SedisteDTO;

@Entity
public class Sediste {

	public static final int PODRAZUMEVANI_BROJ_SEDISTA = 30;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
	private KlasaSedista klasa;
    
    @Column(nullable = false)
    @Min(10)
    private double cena;
    
    @Column(nullable = true)
    private String imePutnika;
    
    @Column(nullable = true)
    private String prezimePutnika;
    
    @Column(nullable = true)
    private String brojPasosa;
    
    @Column(nullable = false)
    private boolean potvrdjeno;
    
    @ManyToOne
    private Let let;
    
    @ManyToOne
    private KategorijaPrtljaga kategorijaPrtljaga;
    
    @ManyToOne
    private AvionskaKarta avionskaKarta;
    
    public Sediste() { }
    
    public Sediste(SedisteDTO sedisteNaLetuDTO) {
    	this.id = sedisteNaLetuDTO.getId();
    	this.klasa = sedisteNaLetuDTO.getKlasa();
    	this.cena = sedisteNaLetuDTO.getCena();
    	this.imePutnika = sedisteNaLetuDTO.getImePutnika();
    	this.prezimePutnika = sedisteNaLetuDTO.getPrezimePutnika();
    	this.brojPasosa = sedisteNaLetuDTO.getBrojPasosa();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KlasaSedista getKlasa() {
		return klasa;
	}

	public void setKlasa(KlasaSedista klasa) {
		this.klasa = klasa;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Let getLet() {
		return let;
	}

	public void setLet(Let let) {
		this.let = let;
	}

	public KategorijaPrtljaga getKategorijaPrtljaga() {
		return kategorijaPrtljaga;
	}

	public void setKategorijaPrtljaga(KategorijaPrtljaga kategorijaPrtljaga) {
		this.kategorijaPrtljaga = kategorijaPrtljaga;
	}

	public AvionskaKarta getAvionskaKarta() {
		return avionskaKarta;
	}

	public void setAvionskaKarta(AvionskaKarta avionskaKarta) {
		this.avionskaKarta = avionskaKarta;
	}

	public String getImePutnika() {
		return imePutnika;
	}

	public void setImePutnika(String imePutnika) {
		this.imePutnika = imePutnika;
	}

	public String getPrezimePutnika() {
		return prezimePutnika;
	}

	public void setPrezimePutnika(String prezimePutnika) {
		this.prezimePutnika = prezimePutnika;
	}

	public String getBrojPasosa() {
		return brojPasosa;
	}

	public void setBrojPasosa(String brojPasosa) {
		this.brojPasosa = brojPasosa;
	}

	public boolean isPotvrdjeno() {
		return potvrdjeno;
	}

	public void setPotvrdjeno(boolean potvrdjeno) {
		this.potvrdjeno = potvrdjeno;
	}
    
}
