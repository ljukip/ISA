package com.booking.application.dto.opsti;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.opsti.Adresa;

public class AdresaDTO {

    private long id;
	private String zemlja;
	private String grad;
	private String ulica;
	private int broj;
	
	public AdresaDTO() { }
	
	public AdresaDTO(Adresa adresa) {
		if(adresa == null) return;
		this.id = adresa.getId();
		this.zemlja = adresa.getZemlja();
		this.grad = adresa.getGrad();
		this.ulica = adresa.getUlica();
		this.broj = adresa.getBroj();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
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
	
	public static List<AdresaDTO> pretvori(List<Adresa> adrese) {
		List<AdresaDTO> rezultat = new ArrayList<AdresaDTO>();
		for(Adresa adresa : adrese) {
			rezultat.add(new AdresaDTO(adresa));
		}
		return rezultat;
	}
	
}
