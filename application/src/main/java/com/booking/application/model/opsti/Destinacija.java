package com.booking.application.model.opsti;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.booking.application.dto.opsti.DestinacijaDTO;
import com.booking.application.model.avionskakompanija.Let;

@Entity
public class Destinacija {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 32, nullable = false)
    private String grad;
    @Column(length = 32, nullable = false)
    private String zemlja;
	
    @OneToMany(mappedBy = "polaziste")
    private List<Let> letoviIz;
    
    @OneToMany(mappedBy = "odrediste")
    private List<Let> letoviU;
    
    @ManyToMany(mappedBy = "presedanja")
    private List<Let> letoviKojiPresedaju;
    
    public Destinacija() { }
    
    public Destinacija(DestinacijaDTO destinacijaDTO) {
    	this.id = destinacijaDTO.getId();
    	this.grad = destinacijaDTO.getGrad();
    	this.zemlja = destinacijaDTO.getZemlja();
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

	public List<Let> getLetoviIz() {
		return letoviIz;
	}

	public void setLetoviIz(List<Let> letoviIz) {
		this.letoviIz = letoviIz;
	}

	public List<Let> getLetoviU() {
		return letoviU;
	}

	public void setLetoviU(List<Let> letoviU) {
		this.letoviU = letoviU;
	}

	public List<Let> getLetoviKojiPresedaju() {
		return letoviKojiPresedaju;
	}

	public void setLetoviKojiPresedaju(List<Let> letoviKojiPresedaju) {
		this.letoviKojiPresedaju = letoviKojiPresedaju;
	}
    
}
