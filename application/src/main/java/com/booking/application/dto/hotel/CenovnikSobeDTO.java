package com.booking.application.dto.hotel;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.hotel.CenovnikSobe;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CenovnikSobeDTO {

    private long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String pocetniDatum;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private String krajnjiDatum;
	private double cena;
	
	public CenovnikSobeDTO() { }

	public CenovnikSobeDTO(CenovnikSobe cenovnik) {
		this.id = cenovnik.getId();  
		this.pocetniDatum = cenovnik.getPocetniDatum().toString();
		this.krajnjiDatum = cenovnik.getKrajnjiDatum().toString();
		this.cena = cenovnik.getCena();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
	
	public String getPocetniDatum() {
		return pocetniDatum;
	}

	public void setPocetniDatum(String pocetniDatum) {
		this.pocetniDatum = pocetniDatum;
	}

	public String getKrajnjiDatum() {
		return krajnjiDatum;
	}

	public void setKrajnjiDatum(String krajnjiDatum) {
		this.krajnjiDatum = krajnjiDatum;
	}
	
	public static List<CenovnikSobeDTO> transformisi(List<CenovnikSobe> cenovnici) {
		List<CenovnikSobeDTO> rezultat = new ArrayList<CenovnikSobeDTO>();
		for(CenovnikSobe cenovnik : cenovnici) {
			rezultat.add(new CenovnikSobeDTO(cenovnik));
		}
		return rezultat;
	}
	
}
