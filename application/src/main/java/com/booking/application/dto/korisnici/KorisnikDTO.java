package com.booking.application.dto.korisnici;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.korisnici.AdminKompanije;
import com.booking.application.model.korisnici.AdminSistema;
import com.booking.application.model.korisnici.Korisnik;
import com.booking.application.model.korisnici.TipAdmina;

public class KorisnikDTO {

    private Long id;
	private String ime;
	private String prezime;
	private String email;
	private String lozinka;
	private String grad;
	private String telefon;
	private TipAdmina tipAdmina;
	private TipKorisnika tipKorisnika;
	private boolean aktiviran;
	
	public KorisnikDTO() { }

	public KorisnikDTO(AdminSistema adminSistema) {
		this.id = adminSistema.getId();
		this.ime = adminSistema.getIme();
		this.prezime = adminSistema.getPrezime();
		this.email = adminSistema.getEmail();
		this.lozinka = adminSistema.getLozinka();
		this.grad = adminSistema.getGrad();
		this.telefon = adminSistema.getTelefon();
		this.tipKorisnika = TipKorisnika.ADMIN_SISTEMA;
		this.aktiviran = true;
	}

	public KorisnikDTO(AdminKompanije admin) {
		this.id = admin.getId();
		this.ime = admin.getIme();
		this.prezime = admin.getPrezime();
		this.email = admin.getEmail();
		this.lozinka = admin.getLozinka();
		this.grad = admin.getGrad();
		this.telefon = admin.getTelefon();
		this.tipAdmina = admin.getTip();
		this.tipKorisnika = TipKorisnika.ADMIN_KOMPANIJE;
		this.aktiviran = admin.isAktiviran();
	}
	
	public KorisnikDTO(Korisnik korisnik) {
		this.id = korisnik.getId();
		this.ime = korisnik.getIme();
		this.prezime = korisnik.getPrezime();
		this.email = korisnik.getEmail();
		this.lozinka = korisnik.getLozinka();
		this.grad = korisnik.getGrad();
		this.telefon = korisnik.getTelefon();
		this.tipKorisnika = TipKorisnika.KORISNIK;
		this.aktiviran = korisnik.isAktiviran();
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

	public TipAdmina getTipAdmina() {
		return tipAdmina;
	}

	public void setTipAdmina(TipAdmina tip) {
		this.tipAdmina = tip;
	}
	
	public static List<KorisnikDTO> transformisiAdmineSistema(List<AdminSistema> admini) {
		List<KorisnikDTO> rezultat = new ArrayList<KorisnikDTO>();
		for(AdminSistema admin : admini) {
			rezultat.add(new KorisnikDTO(admin));
		}
		return rezultat;
	}

	public static List<KorisnikDTO> transformisiAdmineKompanije(List<AdminKompanije> admini) {
		List<KorisnikDTO> rezultat = new ArrayList<KorisnikDTO>();
		for(AdminKompanije admin : admini) {
			rezultat.add(new KorisnikDTO(admin));
		}
		return rezultat;
	}
	
	public static List<KorisnikDTO> transformisiKorisnike(List<Korisnik> korisnici) {
		List<KorisnikDTO> rezultat = new ArrayList<KorisnikDTO>();
		for(Korisnik korisnik : korisnici) {
			rezultat.add(new KorisnikDTO(korisnik));
		}
		return rezultat;
	}

	public TipKorisnika getTipKorisnika() {
		return tipKorisnika;
	}

	public void setTipKorisnika(TipKorisnika tipKorisnika) {
		this.tipKorisnika = tipKorisnika;
	}

	public boolean isAktiviran() {
		return aktiviran;
	}

	public void setAktiviran(boolean aktiviran) {
		this.aktiviran = aktiviran;
	}
	
}
