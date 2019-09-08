package com.booking.application.model.korisnici;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.vozila.KompanijaVozila;

@Entity
public class AdminKompanije {

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
	@Enumerated(EnumType.STRING)
	private TipAdmina tip;
	
	@ManyToOne
	private AvionskaKompanija avionskaKompanija;
	
	@ManyToOne
	private Hotel hotel;
	
	@ManyToOne
	private KompanijaVozila kompanijaVozila;
	
	public AdminKompanije() { }

	public AdminKompanije(KorisnikDTO adminDTO) {
		this.id = adminDTO.getId();
		this.ime = adminDTO.getIme();
		this.prezime = adminDTO.getPrezime();
		this.email = adminDTO.getEmail();
		this.lozinka = adminDTO.getLozinka();
		this.grad = adminDTO.getGrad();
		this.telefon = adminDTO.getTelefon();
		this.tip = adminDTO.getTip();
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

	public TipAdmina getTip() {
		return tip;
	}

	public void setTip(TipAdmina tip) {
		this.tip = tip;
	}

	public AvionskaKompanija getAvionskaKompanija() {
		return avionskaKompanija;
	}

	public void setAvionskaKompanija(AvionskaKompanija avionskaKompanija) {
		this.avionskaKompanija = avionskaKompanija;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public KompanijaVozila getKompanijaVozila() {
		return kompanijaVozila;
	}

	public void setKompanijaVozila(KompanijaVozila kompanijaVozila) {
		this.kompanijaVozila = kompanijaVozila;
	}

	public void prekopiraj(AdminKompanije adminKompanije) {
		this.id = adminKompanije.getId();
		this.ime = adminKompanije.getIme();
		this.prezime = adminKompanije.getPrezime();
		this.lozinka = adminKompanije.getLozinka();
		this.grad = adminKompanije.getGrad();
		this.telefon = adminKompanije.getTelefon();
	}

}
