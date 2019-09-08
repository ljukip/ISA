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

import com.booking.application.dto.avionskakompanija.SedisteAvionaDTO;

@Entity
public class SedisteAviona {

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
	
	@ManyToOne
	private Avion avion;
    
	public SedisteAviona() { }
	
	public SedisteAviona(SedisteAvionaDTO sedisteDTO) {
		this.id = sedisteDTO.getId();
		this.red = sedisteDTO.getRed();
		this.kolona = sedisteDTO.getKolona();
		this.klasa = sedisteDTO.getKlasa();
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

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public KlasaSedista getKlasa() {
		return klasa;
	}

	public void setKlasa(KlasaSedista klasa) {
		this.klasa = klasa;
	}

	public void prekopiraj(SedisteAviona novoSediste) {
		this.red = novoSediste.getRed();
		this.kolona = novoSediste.getKolona();
		this.klasa = novoSediste.getKlasa();
	}
	
}
