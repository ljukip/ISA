package com.booking.application.dto.korisnici;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.booking.application.model.korisnici.ZahtevZaPrijateljstvo;

public class ZahtevZaPrijateljstvoDTO {

    private Long id;
    private Date vremeSlanja;
    private KorisnikDTO poslao;
    private KorisnikDTO primio;
	
    public ZahtevZaPrijateljstvoDTO() { }
    
    public ZahtevZaPrijateljstvoDTO(ZahtevZaPrijateljstvo zahtev) {
    	this.id = zahtev.getId();
    	this.vremeSlanja = zahtev.getVremeSlanja();
    	this.poslao = new KorisnikDTO(zahtev.getPoslao());
    	this.primio = new KorisnikDTO(zahtev.getPrimio());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVremeSlanja() {
		return vremeSlanja;
	}

	public void setVremeSlanja(Date vremeSlanja) {
		this.vremeSlanja = vremeSlanja;
	}

	public KorisnikDTO getPoslao() {
		return poslao;
	}

	public void setPoslao(KorisnikDTO poslao) {
		this.poslao = poslao;
	}

	public KorisnikDTO getPrimio() {
		return primio;
	}

	public void setPrimio(KorisnikDTO primio) {
		this.primio = primio;
	}

	public static List<ZahtevZaPrijateljstvoDTO> transformisi(List<ZahtevZaPrijateljstvo> zahtevi) {
		List<ZahtevZaPrijateljstvoDTO> rezultat = new ArrayList<ZahtevZaPrijateljstvoDTO>();
		for(ZahtevZaPrijateljstvo zahtev : zahtevi) {
			rezultat.add(new ZahtevZaPrijateljstvoDTO(zahtev));
		}
		return rezultat;
	}
    
}
