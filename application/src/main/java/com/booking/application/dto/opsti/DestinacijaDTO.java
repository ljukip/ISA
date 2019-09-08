package com.booking.application.dto.opsti;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.opsti.Destinacija;

public class DestinacijaDTO {

    private Long id;
    private String grad;
    private String zemlja;
	
    public DestinacijaDTO() { }
    
    public DestinacijaDTO(Destinacija destinacija) {
    	this.id = destinacija.getId();
    	this.grad = destinacija.getGrad();
    	this.zemlja = destinacija.getZemlja();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getZemlja() {
		return zemlja;
	}

	public void setZemlja(String zemlja) {
		this.zemlja = zemlja;
	}
    
	public static List<DestinacijaDTO> transformisi(List<Destinacija> destinacije) {
		List<DestinacijaDTO> rezultat = new ArrayList<DestinacijaDTO>();
		for(Destinacija destinacija : destinacije) {
			rezultat.add(new DestinacijaDTO(destinacija));
		}
		return rezultat;
	}
	
}
