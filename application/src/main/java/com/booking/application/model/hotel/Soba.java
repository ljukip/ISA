package com.booking.application.model.hotel;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;

import com.booking.application.dto.hotel.SobaDTO;

@Entity
public class Soba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(nullable = false)
	@Min(value = 0)
	private int sprat;
	@Column(nullable = false)
	@Min(value = 1)
	private int brojKreveta;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipSobe tip;
	
	@ManyToOne
	private Hotel hotel;
	
	@OneToMany(mappedBy = "soba")
	private List<CenovnikSobe> cenovnici;
	
	@ManyToMany(mappedBy = "sobe")
	private List<ZakupSoba> zakupi;

	
	
	public Soba() { }
	
	public Soba(SobaDTO sobaDTO) {
		this.id = sobaDTO.getId();
		this.sprat = sobaDTO.getSprat();
		this.brojKreveta = sobaDTO.getBrojKreveta();
		this.tip = sobaDTO.getTip();
	}


	public int getSprat() {
		return sprat;
	}

	public void setSprat(int sprat) {
		this.sprat = sprat;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public TipSobe getTip() {
		return tip;
	}

	public void setTip(TipSobe tip) {
		this.tip = tip;
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

	public void prekopiraj(Soba novaSoba) {
		this.sprat = novaSoba.getSprat();
		this.brojKreveta = novaSoba.getBrojKreveta();
		this.tip = novaSoba.getTip();
	}
	
	public List<CenovnikSobe> getCenovnici() {
		return cenovnici;
	}

	public void setCenovnici(List<CenovnikSobe> cenovnici) {
		this.cenovnici = cenovnici;
	}


	public List<ZakupSoba> getZakupi() {
		return zakupi;
	}

	public void setZakupi(List<ZakupSoba> zakupi) {
		this.zakupi = zakupi;
	}
	
}
