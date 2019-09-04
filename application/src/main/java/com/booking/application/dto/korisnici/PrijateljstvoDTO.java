package com.booking.application.dto.korisnici;

import java.util.Date;

import com.booking.application.model.korisnici.Prijateljstvo;

public class PrijateljstvoDTO {

    private Long id;
    private Date vremeKreiranja;
    private KorisnikDTO prijatelj1DTO;
    private KorisnikDTO prijatelj2DTO;
	
	public PrijateljstvoDTO() { }
	
	public PrijateljstvoDTO(Prijateljstvo prijateljstvo) {
		this.id = prijateljstvo.getId();
		this.vremeKreiranja = prijateljstvo.getVremeKreiranja();
		this.prijatelj1DTO = new KorisnikDTO(prijateljstvo.getPrijatelj1());
		this.prijatelj2DTO = new KorisnikDTO(prijateljstvo.getPrijatelj2());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVremeKreiranja() {
		return vremeKreiranja;
	}

	public void setVremeKreiranja(Date vremeKreiranja) {
		this.vremeKreiranja = vremeKreiranja;
	}

	public KorisnikDTO getPrijatelj1DTO() {
		return prijatelj1DTO;
	}

	public void setPrijatelj1DTO(KorisnikDTO prijatelj1dto) {
		prijatelj1DTO = prijatelj1dto;
	}

	public KorisnikDTO getPrijatelj2DTO() {
		return prijatelj2DTO;
	}

	public void setPrijatelj2DTO(KorisnikDTO prijatelj2dto) {
		prijatelj2DTO = prijatelj2dto;
	}

}
