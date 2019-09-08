package com.booking.application.model.opsti;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import com.booking.application.model.hotel.Hotel;
import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.vozila.Garaza;
import com.booking.application.model.vozila.KompanijaVozila;

@Entity
public class Adresa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32, nullable = false)
	private String zemlja;
    @Column(length = 32, nullable = false)
	private String grad;
    @Column(length = 32, nullable = false)
	private String ulica;
    @Column(nullable = false)
    @Min(value = 0)
	private int broj;
	
	@OneToOne
	private Hotel hotel;
	
	@OneToOne
	private KompanijaVozila kompanijaVozila;
	
	@OneToOne
	private AvionskaKompanija avionskaKompanija;
	
	@OneToOne
	private Garaza garaza;
	
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public Adresa() { }
	
	public Adresa(AdresaDTO adresaDTO) {
		this.zemlja = adresaDTO.getZemlja();
		this.grad = adresaDTO.getGrad();
		this.ulica = adresaDTO.getUlica();
		this.broj = adresaDTO.getBroj();
	}


	public String getZemlja() {
		return zemlja;
	}
	
	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}
	
	public String getGrad() {
		return grad;
	}
	
	public void setGrad(String grad) {
		this.grad = grad;
	}
	
	public String getUlica() {
		return ulica;
	}
	
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	
	public int getBroj() {
		return broj;
	}
	
	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KompanijaVozila getKompanijaVozila() {
		return kompanijaVozila;
	}

	public void setKompanijaVozila(KompanijaVozila kompanijaVozila) {
		this.kompanijaVozila = kompanijaVozila;
	}

	public Garaza getGaraza() {
		return garaza;
	}

	public void setGaraza(Garaza garaza) {
		this.garaza = garaza;
	}

	public AvionskaKompanija getAvionskaKompanija() {
		return avionskaKompanija;
	}

	public void setAvionskaKompanija(AvionskaKompanija avionskaKompanija) {
		this.avionskaKompanija = avionskaKompanija;
	}
	
	
}
