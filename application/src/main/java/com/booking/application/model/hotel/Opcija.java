package com.booking.application.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

import com.booking.application.dto.hotel.OpcijaDTO;

@Entity
public class Opcija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32, nullable = false)
	private String naziv;
    @Min(value = 0)
	private double cena;
	
	@ManyToOne
	private Hotel hotel;

	
	
	public Opcija() { }
	
	public Opcija(OpcijaDTO opcijaDTO) {
		this.id = opcijaDTO.getId();
		this.naziv = opcijaDTO.getNaziv();
		this.cena = opcijaDTO.getCena();
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void prekopiraj(Opcija novaOpcija) {
		this.naziv = novaOpcija.getNaziv();
		this.cena = novaOpcija.getCena();
	}
	
}
