package com.booking.application.dto.avionskakompanija;

import java.util.List;

import com.booking.application.model.avionskakompanija.AvionskaKarta;

public class AvionskaKartaDTO {

    private Long id;
	private double cena;
	private LetDTO polazniLetDTO;
	private List<SedisteNaLetuDTO> sedistaNaPolaznomLetuDTO;
	private LetDTO povratniLetDTO;
	private List<SedisteNaLetuDTO> sedistaNaPovratnomLetuDTO;
	
	public AvionskaKartaDTO() { }
	
	public AvionskaKartaDTO(AvionskaKarta avionskaKarta) {
		this.id = avionskaKarta.getId();
		this.cena = avionskaKarta.getCena();
		this.polazniLetDTO = new LetDTO(avionskaKarta.getPolazniLet());
		this.sedistaNaPolaznomLetuDTO = SedisteNaLetuDTO.transformisi(avionskaKarta.getSedistaNaPolaznomLetu());
		this.povratniLetDTO = new LetDTO(avionskaKarta.getPovratniLet());
		this.sedistaNaPovratnomLetuDTO = SedisteNaLetuDTO.transformisi(avionskaKarta.getSedistaNaPovratnomLetu());
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

	public LetDTO getPolazniLetDTO() {
		return polazniLetDTO;
	}

	public void setPolazniLetDTO(LetDTO polazniLetDTO) {
		this.polazniLetDTO = polazniLetDTO;
	}

	public List<SedisteNaLetuDTO> getSedistaNaPolaznomLetuDTO() {
		return sedistaNaPolaznomLetuDTO;
	}

	public void setSedistaNaPolaznomLetuDTO(List<SedisteNaLetuDTO> sedistaNaPolaznomLetuDTO) {
		this.sedistaNaPolaznomLetuDTO = sedistaNaPolaznomLetuDTO;
	}

	public LetDTO getPovratniLetDTO() {
		return povratniLetDTO;
	}

	public void setPovratniLetDTO(LetDTO povratniLetDTO) {
		this.povratniLetDTO = povratniLetDTO;
	}

	public List<SedisteNaLetuDTO> getSedistaNaPovratnomLetuDTO() {
		return sedistaNaPovratnomLetuDTO;
	}

	public void setSedistaNaPovratnomLetuDTO(List<SedisteNaLetuDTO> sedistaNaPovratnomLetuDTO) {
		this.sedistaNaPovratnomLetuDTO = sedistaNaPovratnomLetuDTO;
	}
	
}
