package com.booking.application.dto.hotel;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.hotel.Hotel;

public class HotelDTO {

    private long id;
	private String naziv;
	private String opis;
	private double prosecnaOcena;
	private AdresaDTO adresaDTO;
	
	public HotelDTO() { }
	
	public HotelDTO(Hotel hotel) {
		this.id = hotel.getId();
		this.naziv = hotel.getNaziv();
		this.opis = hotel.getOpis();
		this.adresaDTO = new AdresaDTO(hotel.getAdresa());
		this.prosecnaOcena = hotel.getOcena();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public AdresaDTO getAdresaDTO() {
		return adresaDTO;
	}

	public void setAdresaDTO(AdresaDTO adresaDTO) {
		this.adresaDTO = adresaDTO;
	}
	
	public static List<HotelDTO> transformisi(List<Hotel> hoteli) {
		List<HotelDTO> rezultat = new ArrayList<HotelDTO>();
		for(Hotel hotel : hoteli) {
			rezultat.add(new HotelDTO(hotel));
		}
		return rezultat;
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(double ocena) {
		this.prosecnaOcena = ocena;
	}
	
}
