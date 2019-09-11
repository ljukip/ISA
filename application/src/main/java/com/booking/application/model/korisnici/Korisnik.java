package com.booking.application.model.korisnici;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.dto.korisnici.RegistracijaDTO;
import com.booking.application.model.opsti.Rezervacija;

@Entity
public class Korisnik {

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
	@Column(nullable = false)
	private boolean aktiviran;
	
	@OneToMany(mappedBy = "vlasnik")
	private List<Rezervacija> rezervacije;
	
	@ManyToMany
	@JoinTable(name = "spoj_korisnik_gostujuce_rezervacije", 
	   joinColumns = @JoinColumn(name = "korisnik_id"), 
	   inverseJoinColumns = @JoinColumn(name = "rezervacija_id"))
	private List<Rezervacija> gostujuceRezervacije;
	
	@OneToMany(mappedBy = "poslao")
	private List<ZahtevZaPrijateljstvo> poslatiZahtevi;
	
	@OneToMany(mappedBy = "primio")
	private List<ZahtevZaPrijateljstvo> primljeniZahtevi;
	
	@OneToMany(mappedBy = "poslao")
	private List<PozivNaRezervaciju> poslatiPozivi;
	
	@OneToMany(mappedBy = "primio")
	private List<PozivNaRezervaciju> primljeniPozivi;
	
	@OneToMany(mappedBy = "prijatelj1")
	private List<Prijateljstvo> prijateljstva1;
	
	@OneToMany(mappedBy = "prijatelj2")
	private List<Prijateljstvo> prijateljstva2;
	
	public Korisnik() { }
	
	public Korisnik(KorisnikDTO korisnikDTO) {
		this.id = korisnikDTO.getId();
		this.ime = korisnikDTO.getIme();
		this.prezime = korisnikDTO.getPrezime();
		this.email = korisnikDTO.getEmail();
		this.lozinka = korisnikDTO.getLozinka();
		this.grad = korisnikDTO.getGrad();
		this.telefon = korisnikDTO.getTelefon();
	}

	public Korisnik(RegistracijaDTO registracijaDTO) {
		this.id = registracijaDTO.getId();
		this.ime = registracijaDTO.getIme();
		this.prezime = registracijaDTO.getPrezime();
		this.email = registracijaDTO.getEmail();
		this.lozinka = registracijaDTO.getLozinka();
		this.grad = registracijaDTO.getMesto();
		this.telefon = registracijaDTO.getBrojTelefona();
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

	public List<ZahtevZaPrijateljstvo> getPoslatiZahtevi() {
		return poslatiZahtevi;
	}

	public void setPoslatiZahtevi(List<ZahtevZaPrijateljstvo> poslatiZahtevi) {
		this.poslatiZahtevi = poslatiZahtevi;
	}

	public List<ZahtevZaPrijateljstvo> getPrimljeniZahtevi() {
		return primljeniZahtevi;
	}

	public void setPrimljeniZahtevi(List<ZahtevZaPrijateljstvo> primljeniZahtevi) {
		this.primljeniZahtevi = primljeniZahtevi;
	}

	public List<PozivNaRezervaciju> getPoslatiPozivi() {
		return poslatiPozivi;
	}

	public void setPoslatiPozivi(List<PozivNaRezervaciju> poslatiPozivi) {
		this.poslatiPozivi = poslatiPozivi;
	}

	public List<PozivNaRezervaciju> getPrimljeniPozivi() {
		return primljeniPozivi;
	}

	public void setPrimljeniPozivi(List<PozivNaRezervaciju> primljeniPozivi) {
		this.primljeniPozivi = primljeniPozivi;
	}

	public List<Prijateljstvo> getPrijateljstva1() {
		return prijateljstva1;
	}

	public void setPrijateljstva1(List<Prijateljstvo> prijateljstva1) {
		this.prijateljstva1 = prijateljstva1;
	}

	public List<Prijateljstvo> getPrijateljstva2() {
		return prijateljstva2;
	}

	public void setPrijateljstva2(List<Prijateljstvo> prijateljstva2) {
		this.prijateljstva2 = prijateljstva2;
	}

	public void prekopiraj(Korisnik korisnik) {
		this.ime = korisnik.getIme();
		this.prezime = korisnik.getPrezime();
		this.lozinka = korisnik.getLozinka();
		this.grad = korisnik.getGrad();
		this.telefon = korisnik.getTelefon();
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	public void setRezervacije(List<Rezervacija> rezervacije) {
		this.rezervacije = rezervacije;
	}

	public List<Rezervacija> getGostujuceRezervacije() {
		return gostujuceRezervacije;
	}

	public void setGostujuceRezervacije(List<Rezervacija> gostujuceRezervacije) {
		this.gostujuceRezervacije = gostujuceRezervacije;
	}

	public boolean isAktiviran() {
		return aktiviran;
	}

	public void setAktiviran(boolean aktiviran) {
		this.aktiviran = aktiviran;
	}
	
}
