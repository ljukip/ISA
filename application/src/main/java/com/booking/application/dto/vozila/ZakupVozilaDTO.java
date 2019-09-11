package com.booking.application.dto.vozila;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.opsti.TipZakupa;
import com.booking.application.model.vozila.ZakupVozila;
import com.booking.application.service.vozila.ZakupVozilaService;

public class ZakupVozilaDTO {

	private Long id;
	private LocalDate pocetniDatum;
	private LocalDate krajnjiDatum;
	private double cenaZakupa;
	private double dodatniPopust;
	private double popustNaTip;
	private TipZakupa tip;
	private VoziloDTO voziloDTO;
	private boolean dozvoljenoOtkazivanje;
	private double ocena;
	
	public ZakupVozilaDTO() { }
	
	public ZakupVozilaDTO(ZakupVozila zakup) {
		this.id = zakup.getId();
		this.pocetniDatum = zakup.getPocetniDatum();
		this.krajnjiDatum = zakup.getKrajnjiDatum();
		this.cenaZakupa = zakup.getCenaZakupa();
		this.dodatniPopust = zakup.getDodatniPopust();
		this.popustNaTip = zakup.getPopustNaTip();
		this.tip = zakup.getTip();
		this.voziloDTO = new VoziloDTO(zakup.getVozilo());
		this.dozvoljenoOtkazivanje = ZakupVozilaService.dozvoljenoOtkazivanje(zakup);
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

	public TipZakupa getTip() {
		return tip;
	}

	public void setTip(TipZakupa tip) {
		this.tip = tip;
	}

	public VoziloDTO getVoziloDTO() {
		return voziloDTO;
	}

	public void setVoziloDTO(VoziloDTO voziloDTO) {
		this.voziloDTO = voziloDTO;
	}
	
	public static List<ZakupVozilaDTO> transformisi(List<ZakupVozila> zakupi) {
		List<ZakupVozilaDTO> rezultat = new ArrayList<ZakupVozilaDTO>();
		for(ZakupVozila zakup : zakupi) {
			rezultat.add(new ZakupVozilaDTO(zakup));
		}
		return rezultat;
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
