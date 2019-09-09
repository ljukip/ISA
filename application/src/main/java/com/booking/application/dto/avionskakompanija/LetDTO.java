package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booking.application.dto.opsti.DestinacijaDTO;
import com.booking.application.model.avionskakompanija.Let;

public class LetDTO {

    private Long id;
    private double duzina;
	private Date vremePoletanja;
	private Date vremeSletanja;
	private DestinacijaDTO polazisteDTO;
	private DestinacijaDTO odredisteDTO;
	private List<DestinacijaDTO> presedanjaDTO;
	private double cena;
	
	public LetDTO() { }
	
	public LetDTO(Let let) {
		this.id = let.getId();
		this.duzina = let.getDuzina();
		this.vremePoletanja = let.getVremePoletanja();
		this.vremeSletanja = let.getVremeSletanja();
		this.cena = let.getCena();
		this.polazisteDTO = new DestinacijaDTO(let.getPolaziste());
		this.odredisteDTO = new DestinacijaDTO(let.getOdrediste());
		this.presedanjaDTO = DestinacijaDTO.transformisi(let.getPresedanja());
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

	public List<DestinacijaDTO> getPresedanjaDTO() {
		return presedanjaDTO;
	}

	public void setPresedanjaDTO(List<DestinacijaDTO> presedanjaDTO) {
		this.presedanjaDTO = presedanjaDTO;
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

}
