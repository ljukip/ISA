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

import com.booking.application.dto.avionskakompanija.SedisteNaLetuDTO;

@Entity
public class SedisteNaLetu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Min(1)
    private int red;
    @Column(nullable = false)
    @Min(1)
    private int kolona;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
	private KlasaSedista klasa;
    @Column(nullable = false)
    @Min(10)
    private double cena;
    
    @ManyToOne
    private Let let;
    
    @ManyToOne
    private KategorijaPrtljaga kategorijaPrtljaga;
    
    @ManyToOne
    private AvionskaKarta polaznaAvionskaKarta;
    
    @ManyToOne
    private AvionskaKarta povratnaAvionskaKarta;
    
    public SedisteNaLetu() { }
    
    public SedisteNaLetu(SedisteNaLetuDTO sedisteNaLetuDTO) {
    	this.id = sedisteNaLetuDTO.getId();
    	this.red = sedisteNaLetuDTO.getRed();
    	this.kolona = sedisteNaLetuDTO.getKolona();
    	this.klasa = sedisteNaLetuDTO.getKlasa();
    	this.cena = sedisteNaLetuDTO.getCena();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getKolona() {
		return kolona;
	}

	public void setKolona(int kolona) {
		this.kolona = kolona;
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

	public AvionskaKarta getPolaznaAvionskaKarta() {
		return polaznaAvionskaKarta;
	}

	public void setPolaznaAvionskaKarta(AvionskaKarta polaznaAvionskaKarta) {
		this.polaznaAvionskaKarta = polaznaAvionskaKarta;
	}

	public AvionskaKarta getPovratnaAvionskaKarta() {
		return povratnaAvionskaKarta;
	}

	public void setPovratnaAvionskaKarta(AvionskaKarta povratnaAvionskaKarta) {
		this.povratnaAvionskaKarta = povratnaAvionskaKarta;
	}
    
}
