package com.booking.application.dto.hotel;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.hotel.Hotel;

public class HotelDTO {

    private long id;
	private String naziv;
	private String opis;
	
	public HotelDTO() { }
	
	public HotelDTO(Hotel hotel) {
		this.id = hotel.getId();
		this.naziv = hotel.getNaziv();
		this.opis = hotel.getOpis();
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

	
	
	public static List<HotelDTO> transformisi(List<Hotel> hoteli) {
		List<HotelDTO> rezultat = new ArrayList<HotelDTO>();
		for(Hotel hotel : hoteli) {
			rezultat.add(new HotelDTO(hotel));
		}
		return rezultat;
	}
	
}
