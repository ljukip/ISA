package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.avionskakompanija.AvionskaKarta;
import com.booking.application.model.opsti.TipZakupa;

public class AvionskaKartaDTO {

    private Long id;
	private double cena;
	private double ocena;
	private LetDTO letDTO;
	private List<SedisteDTO> sedistaDTO;
	private TipZakupa tip;
	
	public AvionskaKartaDTO() { }
	
	public AvionskaKartaDTO(AvionskaKarta avionskaKarta) {
		this.id = avionskaKarta.getId();
		this.cena = avionskaKarta.getCena();
		this.letDTO = new LetDTO(avionskaKarta.getLet());
		this.ocena = avionskaKarta.getOcena();
		this.sedistaDTO = SedisteDTO.transformisi(avionskaKarta.getSedista());
		this.tip = avionskaKarta.getTip();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public List<SedisteDTO> getSedistaDTO() {
		return sedistaDTO;
	}

	public void setSedistaDTO(List<SedisteDTO> sedistaDTO) {
		this.sedistaDTO = sedistaDTO;
	}

	public LetDTO getLetDTO() {
		return letDTO;
	}

	public void setLetDTO(LetDTO letDTO) {
		this.letDTO = letDTO;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}

	public TipZakupa getTip() {
		return tip;
	}

	public void setTip(TipZakupa tip) {
		this.tip = tip;
	}
	
	public static List<AvionskaKartaDTO> transformisi(List<AvionskaKarta> karte) {
		List<AvionskaKartaDTO> rezultat = new ArrayList<AvionskaKartaDTO>();
		for(AvionskaKarta karta : karte) {
			rezultat.add(new AvionskaKartaDTO(karta));
		}
		return rezultat;
	}
	
}
