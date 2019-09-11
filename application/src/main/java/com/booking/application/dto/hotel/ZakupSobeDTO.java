package com.booking.application.dto.hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.hotel.ZakupSobe;
import com.booking.application.model.opsti.TipZakupa;
import com.booking.application.service.hotel.ZakupSobaService;

public class ZakupSobeDTO {

	private Long id;
	private LocalDate pocetniDatum;
	private LocalDate krajnjiDatum;
	private double cenaZakupa;
	private double dodatniPopust;
	private double popustNaTip;
	private TipZakupa tip;
	private SobaDTO sobe;
	private List<OpcijaDTO> opcije = new ArrayList<OpcijaDTO>();
	private boolean dozvoljenoOtkazivanje;
	private double ocena;
	
	public ZakupSobeDTO() { }
	
	public ZakupSobeDTO(ZakupSobe zakup) {
		this.id = zakup.getId();
		this.pocetniDatum = zakup.getPocetniDatum();
		this.krajnjiDatum = zakup.getKrajnjiDatum();
		this.cenaZakupa = zakup.getCenaZakupa();
		this.dodatniPopust = zakup.getDodatniPopust();
		this.popustNaTip = zakup.getPopustNaTip();
		this.tip = zakup.getTip();
		this.sobe = new SobaDTO(zakup.getSoba());
		this.opcije = OpcijaDTO.transformisi(zakup.getOpcije());
		this.dozvoljenoOtkazivanje = ZakupSobaService.dozvoljenoOtkazivanje(zakup);
		this.ocena = zakup.getOcena();
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

	public List<OpcijaDTO> getOpcije() {
		return opcije;
	}

	public void setOpcije(List<OpcijaDTO> opcije) {
		this.opcije = opcije;
	}
	
	public static List<ZakupSobeDTO> transformisi(List<ZakupSobe> zakupi) {
		List<ZakupSobeDTO> rezultat = new ArrayList<ZakupSobeDTO>();
		for(ZakupSobe zakup : zakupi) {
			rezultat.add(new ZakupSobeDTO(zakup));
		}
		return rezultat;
	}

	public TipZakupa getTip() {
		return tip;
	}

	public void setTip(TipZakupa tip) {
		this.tip = tip;
	}

	public SobaDTO getSoba() {
		return sobe;
	}

	public void setSoba(SobaDTO soba) {
		this.sobe = soba;
	}

	public boolean isDozvoljenoOtkazivanje() {
		return dozvoljenoOtkazivanje;
	}

	public void setDozvoljenoOtkazivanje(boolean dozvoljenoOtkazivanje) {
		this.dozvoljenoOtkazivanje = dozvoljenoOtkazivanje;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	
}
