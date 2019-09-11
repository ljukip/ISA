package com.booking.application.dto.opsti;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.dto.avionskakompanija.AvionskaKartaDTO;
import com.booking.application.dto.hotel.ZakupSobeDTO;
import com.booking.application.dto.korisnici.KorisnikDTO;
import com.booking.application.dto.vozila.ZakupVozilaDTO;
import com.booking.application.model.opsti.Rezervacija;

public class RezervacijaDTO {

	private Long id;
	private boolean kompletirana;
	private KorisnikDTO vlasnik;
	private AvionskaKartaDTO karta;
	private ZakupSobeDTO zakupSobe;
	private ZakupVozilaDTO zakupVozila;
	
	public RezervacijaDTO() { }
	
	public RezervacijaDTO(Rezervacija rezervacija) {
		this.id = rezervacija.getId();
		this.kompletirana = rezervacija.isKompletirana();
		if(rezervacija.getVlasnik() != null) this.vlasnik = new KorisnikDTO(rezervacija.getVlasnik());
		if(rezervacija.getAvionskaKarta() != null) this.karta = new AvionskaKartaDTO(rezervacija.getAvionskaKarta());
		if(rezervacija.getZakupSoba() != null) this.zakupSobe = new ZakupSobeDTO(rezervacija.getZakupSoba());
		if(rezervacija.getZakupVozila() != null) this.zakupVozila = new ZakupVozilaDTO(rezervacija.getZakupVozila());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isKompletirana() {
		return kompletirana;
	}

	public void setKompletirana(boolean kompletirana) {
		this.kompletirana = kompletirana;
	}

	public KorisnikDTO getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(KorisnikDTO vlasnik) {
		this.vlasnik = vlasnik;
	}

	public AvionskaKartaDTO getKarta() {
		return karta;
	}

	public void setKarta(AvionskaKartaDTO karta) {
		this.karta = karta;
	}

	public ZakupSobeDTO getZakupSobe() {
		return zakupSobe;
	}

	public void setZakupSobe(ZakupSobeDTO zakupSobe) {
		this.zakupSobe = zakupSobe;
	}

	public ZakupVozilaDTO getZakupVozila() {
		return zakupVozila;
	}

	public void setZakupVozila(ZakupVozilaDTO zakupVozila) {
		this.zakupVozila = zakupVozila;
	}

	public static List<RezervacijaDTO> transformisi(List<Rezervacija> rezervacije) {
		List<RezervacijaDTO> rezultat = new ArrayList<RezervacijaDTO>();
		for(Rezervacija rezervacija : rezervacije) {
			rezultat.add(new RezervacijaDTO(rezervacija));
		}
		return rezultat;
	}

}
