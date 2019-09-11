package com.booking.application.dto.vozila;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.vozila.TipVozila;
import com.booking.application.model.vozila.Vozilo;

public class VoziloDTO {

    private Long id;
	private int brojPutnika;
	private double cenaPoDanu;
	private TipVozila tip;
	private GarazaDTO garazaDTO;
	private String model;
	private String marka;
	private int godinaProizvodnje;
	
	public VoziloDTO() { }
	
	public VoziloDTO(Vozilo vozilo) {
		this.id = vozilo.getId();
		this.brojPutnika = vozilo.getBrojPutnika();
		this.cenaPoDanu = vozilo.getCenaPoDanu();
		this.tip = vozilo.getTip();
		this.garazaDTO = vozilo.getGaraza() != null ? new GarazaDTO(vozilo.getGaraza()) : null;
		this.model = vozilo.getModel();
		this.marka = vozilo.getMarka();
		this.godinaProizvodnje = vozilo.getGodinaProizvodnje();
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
	
	public static List<VoziloDTO> transformisi(List<Vozilo> vozila) {
		List<VoziloDTO> rezultat = new ArrayList<VoziloDTO>();
		for(Vozilo vozilo : vozila) {
			rezultat.add(new VoziloDTO(vozilo));
		}
		return rezultat;
	}

	public GarazaDTO getGarazaDTO() {
		return garazaDTO;
	}

	public void setGarazaDTO(GarazaDTO garazaDTO) {
		this.garazaDTO = garazaDTO;
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
