package com.booking.application.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.booking.application.dto.hotel.HotelDTO;
import com.booking.application.model.korisnici.AdminKompanije;
import com.booking.application.model.opsti.Adresa;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(length = 32, nullable = false)
	private String naziv;
	
	@Column(length = 512, nullable = true)
	private String opis;
	
	@Column(nullable = false)
	private double ocena;
	
	@OneToOne
	private Adresa adresa;
	
	@OneToMany(mappedBy = "hotel")
	private List<AdminKompanije> admini;
	
	@OneToMany(mappedBy = "hotel")
	private List<Opcija> opcije;
	
	@OneToMany(mappedBy = "hotel")
	private List<Soba> sobe;
	
	public Hotel() { }
	
	public Hotel(HotelDTO hotelDTO) {
		this.id = hotelDTO.getId();
		this.naziv = hotelDTO.getNaziv();
		this.opis = hotelDTO.getOpis();
		this.ocena = hotelDTO.getProsecnaOcena();
	}

	public List<Soba> getSobe() {
		return sobe;
	}

	public void setSobe(List<Soba> sobe) {
		this.sobe = sobe;
	}

	public List<Opcija> getOpcije() {
		return opcije;
	}

	public void setOpcije(List<Opcija> opcije) {
		this.opcije = opcije;
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

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void prekopiraj(Hotel noviHotel) {
		this.naziv = noviHotel.getNaziv();
		this.opis = noviHotel.getOpis();
	}

	public List<AdminKompanije> getAdmini() {
		return admini;
	}

	public void setAdmini(List<AdminKompanije> admini) {
		this.admini = admini;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	
}
