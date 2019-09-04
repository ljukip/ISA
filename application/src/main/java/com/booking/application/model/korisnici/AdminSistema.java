package com.booking.application.model.korisnici;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.booking.application.dto.korisnici.KorisnikDTO;

@Entity
public class AdminSistema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(length = 32, nullable = false)
	@Pattern(regexp = "^[A-Za-z]*$")
	private String ime;
	@Column(length = 32, nullable = false)
	@Pattern(regexp = "^[A-Za-z]*$")
	private String prezime;
	@Column(length = 32, nullable = false, unique = true, updatable = false)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;
	@Column(length = 32, nullable = false)
	@Pattern(regexp = "^[A-Za-z0-9]*$")
	private String lozinka;
	@Column(length = 32, nullable = false)
	@Pattern(regexp = "^[A-Za-z ]*$")
	private String grad;
	@Column(length = 32, nullable = false, unique = true)
	@Pattern(regexp = "^[0-9]{9,10}$")
	private String telefon;
	
	public AdminSistema() { }

	public AdminSistema(KorisnikDTO adminSistemaDTO) {
		this.id = adminSistemaDTO.getId();
		this.ime = adminSistemaDTO.getIme();
		this.prezime = adminSistemaDTO.getPrezime();
		this.email = adminSistemaDTO.getEmail();
		this.lozinka = adminSistemaDTO.getLozinka();
		this.grad = adminSistemaDTO.getGrad();
		this.telefon = adminSistemaDTO.getTelefon();
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public void prekopiraj(AdminSistema noviAdmin) {
		this.ime = noviAdmin.getIme();
		this.prezime = noviAdmin.getPrezime();
		this.lozinka = noviAdmin.getLozinka();
		this.grad = noviAdmin.getGrad();
		this.telefon = noviAdmin.getTelefon();
	}
	
}
