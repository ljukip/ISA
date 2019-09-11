package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booking.application.dto.opsti.DestinacijaDTO;
import com.booking.application.model.avionskakompanija.Let;
import com.booking.application.model.avionskakompanija.TipLeta;
import com.fasterxml.jackson.annotation.JsonFormat;

public class LetDTO {

    private Long id;
    private double duzina;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd hh:mm")
	private Date vremePoletanja;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd hh:mm")
	private Date vremeSletanja;
	private DestinacijaDTO polazisteDTO;
	private DestinacijaDTO odredisteDTO;
	private String presedanja;
	private double cena;
	private TipLeta tip;
	private Long vremePutovanja;
	
	public LetDTO() { }
	
	public LetDTO(Let let) {
		this.id = let.getId();
		this.duzina = let.getDuzina();
		this.vremePoletanja = let.getVremePoletanja();
		this.vremeSletanja = let.getVremeSletanja();
		this.cena = let.getCena();
		this.polazisteDTO = new DestinacijaDTO(let.getPolaziste());
		this.odredisteDTO = new DestinacijaDTO(let.getOdrediste());
		this.presedanja = let.getPresedanja();
		this.tip = let.getTip();
		this.vremePutovanja = let.getVremePutovanja();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getDuzina() {
		return duzina;
	}

	public void setDuzina(double duzina) {
		this.duzina = duzina;
	}

	public Date getVremePoletanja() {
		return vremePoletanja;
	}

	public void setVremePoletanja(Date vremePoletanja) {
		this.vremePoletanja = vremePoletanja;
	}

	public Date getVremeSletanja() {
		return vremeSletanja;
	}

	public void setVremeSletanja(Date vremeSletanja) {
		this.vremeSletanja = vremeSletanja;
	}
	
	public DestinacijaDTO getPolazisteDTO() {
		return polazisteDTO;
	}

	public void setPolazisteDTO(DestinacijaDTO polazisteDTO) {
		this.polazisteDTO = polazisteDTO;
	}

	public DestinacijaDTO getOdredisteDTO() {
		return odredisteDTO;
	}

	public void setOdredisteDTO(DestinacijaDTO odredisteDTO) {
		this.odredisteDTO = odredisteDTO;
	}

	public String getPresedanja() {
		return presedanja;
	}

	public void setPresedanjaDTO(String presedanja) {
		this.presedanja = presedanja;
	}
	
	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	public static List<LetDTO> transformisi(List<Let> letovi) {
		List<LetDTO> rezultat = new ArrayList<LetDTO>();
		for(Let let : letovi) {
			rezultat.add(new LetDTO(let));
		}
		return rezultat;
	}

	public TipLeta getTip() {
		return tip;
	}

	public void setTip(TipLeta tip) {
		this.tip = tip;
	}

	public void setPresedanja(String presedanja) {
		this.presedanja = presedanja;
	}

	public Long getVremePutovanja() {
		return vremePutovanja;
	}

	public void setVremePutovanja(Long vremePutovanja) {
		this.vremePutovanja = vremePutovanja;
	}

}
