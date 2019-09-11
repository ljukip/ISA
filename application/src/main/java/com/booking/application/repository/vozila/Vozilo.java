package com.booking.application.model.vozila;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.booking.application.dto.vozila.VoziloDTO;

@Entity
public class Vozilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Min(value = 2)
    @Max(value = 7)
	private int brojPutnika;
    
    @Column(nullable = false)
    @Min(value = 1)
	private double cenaPoDanu;
    
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipVozila tip;
	
	@Column(nullable = false)
	private String model;
	
	@Column(nullable = false)
	private String marka;
	
	@Column(nullable = false)
	private int godinaProizvodnje;
	
	@ManyToOne
	private Garaza garaza;
	
	@OneToMany(mappedBy = "vozilo")
	private List<ZakupVozila> zakupi;
	
	public Vozilo() { }

	public Vozilo(VoziloDTO voziloDTO) {
		this.id = voziloDTO.getId();
		this.brojPutnika = voziloDTO.getBrojPutnika();
		this.cenaPoDanu = voziloDTO.getCenaPoDanu();
		this.tip = voziloDTO.getTip();
		this.model = voziloDTO.getModel();
		this.marka = voziloDTO.getMarka();
		this.godinaProizvodnje = voziloDTO.getGodinaProizvodnje();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojPutnika() {
		return brojPutnika;
	}

	public void setBrojPutnika(int brojPutnika) {
		this.brojPutnika = brojPutnika;
	}

	public double getCenaPoDanu() {
		return cenaPoDanu;
	}

	public void setCenaPoDanu(double cenaPoDanu) {
		this.cenaPoDanu = cenaPoDanu;
	}

	public TipVozila getTip() {
		return tip;
	}

	public void setTip(TipVozila tip) {
		this.tip = tip;
	}

	public Garaza getGaraza() {
		return garaza;
	}

	public void setGaraza(Garaza garaza) {
		this.garaza = garaza;
	}

	public List<ZakupVozila> getZakupi() {
		return zakupi;
	}

	public void setZakupi(List<ZakupVozila> zakupi) {
		this.zakupi = zakupi;
	}

	public void prekopiraj(Vozilo vozilo) {
		this.id = vozilo.getId();
		this.brojPutnika = vozilo.getBrojPutnika();
		this.cenaPoDanu = vozilo.getCenaPoDanu();
		this.tip = vozilo.getTip();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public int getGodinaProizvodnje() {
		return godinaProizvodnje;
	}

	public void setGodinaProizvodnje(int godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	
}
