package com.booking.application.dto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.hotel.ZakupSoba;
import com.booking.application.model.opsti.TipZakupa;

public class ZakupSobaDTO {

	private Long id;
	private LocalDate pocetniDatum;
	private LocalDate krajnjiDatum;
	private double cenaZakupa;
	private double dodatniPopust;
	private double popustNaTip;
	private TipZakupa tip;
	private List<SobaDTO> sobe = new ArrayList<SobaDTO>();
	private List<OpcijaDTO> opcije = new ArrayList<OpcijaDTO>();
	
	public ZakupSobaDTO() { }
	
	public ZakupSobaDTO(ZakupSoba zakup) {
		this.id = zakup.getId();
		this.pocetniDatum = zakup.getPocetniDatum();
		this.krajnjiDatum = zakup.getKrajnjiDatum();
		this.cenaZakupa = zakup.getCenaZakupa();
		this.dodatniPopust = zakup.getDodatniPopust();
		this.popustNaTip = zakup.getPopustNaTip();
		this.tip = zakup.getTip();
		this.sobe = SobaDTO.transformisi(zakup.getSobe());
		this.opcije = OpcijaDTO.transformisi(zakup.getOpcije());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPocetniDatum() {
		return pocetniDatum;
	}

	public void setPocetniDatum(LocalDate pocetniDatum) {
		this.pocetniDatum = pocetniDatum;
	}

	public LocalDate getKrajnjiDatum() {
		return krajnjiDatum;
	}

	public void setKrajnjiDatum(LocalDate krajnjiDatum) {
		this.krajnjiDatum = krajnjiDatum;
	}

	public double getCenaZakupa() {
		return cenaZakupa;
	}

	public void setCenaZakupa(double cenaZakupa) {
		this.cenaZakupa = cenaZakupa;
	}

	public double getDodatniPopust() {
		return dodatniPopust;
	}

	public void setDodatniPopust(double dodatniPopust) {
		this.dodatniPopust = dodatniPopust;
	}

	public double getPopustNaTip() {
		return popustNaTip;
	}

	public void setPopustNaTip(double popustNaTip) {
		this.popustNaTip = popustNaTip;
	}

	public List<SobaDTO> getSobe() {
		return sobe;
	}

	public void setSobe(List<SobaDTO> sobe) {
		this.sobe = sobe;
	}

	public List<OpcijaDTO> getOpcije() {
		return opcije;
	}

	public void setOpcije(List<OpcijaDTO> opcije) {
		this.opcije = opcije;
	}
	
	public static List<ZakupSobaDTO> transformisi(List<ZakupSoba> zakupi) {
		List<ZakupSobaDTO> rezultat = new ArrayList<ZakupSobaDTO>();
		for(ZakupSoba zakup : zakupi) {
			rezultat.add(new ZakupSobaDTO(zakup));
		}
		return rezultat;
	}

	public TipZakupa getTip() {
		return tip;
	}

	public void setTip(TipZakupa tip) {
		this.tip = tip;
	}
	
}
