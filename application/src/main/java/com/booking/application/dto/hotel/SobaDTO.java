package com.booking.application.dto.hotel;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.hotel.Soba;
import com.booking.application.model.hotel.TipSobe;

public class SobaDTO {

    private long id;
	private int sprat;
	private int brojKreveta;
	private TipSobe tip;
	
	public SobaDTO() { }
	
	public SobaDTO(Soba soba) {
		this.id = soba.getId();
		this.sprat = soba.getSprat();
		this.brojKreveta = soba.getBrojKreveta();
		this.tip = soba.getTip();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public static List<SobaDTO> transformisi(List<Soba> sobe) {
		List<SobaDTO> rezultat = new ArrayList<SobaDTO>();
		for(Soba soba : sobe) {
			rezultat.add(new SobaDTO(soba));
		}
		return rezultat;
	}
	
}
