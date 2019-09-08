package com.booking.application.dto.vozila;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.vozila.Garaza;

public class GarazaDTO {

    private Long id;
    private KompanijaVozilaDTO kompanijaDTO;
    private AdresaDTO adresaDTO;
    
    public GarazaDTO() { }
    
    public GarazaDTO(Garaza garaza) {
    	this.id = garaza.getId();
    	this.kompanijaDTO = new KompanijaVozilaDTO(garaza.getKompanija());
    	this.adresaDTO = new AdresaDTO(garaza.getAdresa());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KompanijaVozilaDTO getKompanijaDTO() {
		return kompanijaDTO;
	}

	public void setKompanijaDTO(KompanijaVozilaDTO kompanijaDTO) {
		this.kompanijaDTO = kompanijaDTO;
	}

	public AdresaDTO getAdresaDTO() {
		return adresaDTO;
	}

	public void setAdresaDTO(AdresaDTO adresaDTO) {
		this.adresaDTO = adresaDTO;
	}
	
	public static List<GarazaDTO> transformisi(List<Garaza> garaze) {
		List<GarazaDTO> rezultat = new ArrayList<GarazaDTO>();
		for(Garaza garaza : garaze) {
			rezultat.add(new GarazaDTO(garaza));
		}
		return rezultat;
	}
	
}
