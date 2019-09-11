package com.booking.application.dto.korisnici;

public class RegistracijaDTO {

	private Long id;
	private String ime;
	private String prezime;
	private String lozinka;
	private String potvrdaLozinke;
	private String email;
	private String brojTelefona;
	private String mesto;
	
	public RegistracijaDTO() { }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getPotvrdaLozinke() {
		return potvrdaLozinke;
	}

	public void setPotvrdaLozinke(String potvrdaLozinke) {
		this.potvrdaLozinke = potvrdaLozinke;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	
}
