package com.booking.application.model.hotel;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;

import com.booking.application.dto.hotel.ZakupSobeDTO;
import com.booking.application.model.opsti.Rezervacija;
import com.booking.application.model.opsti.TipZakupa;

@Entity
public class ZakupSobe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate pocetniDatum;
	
	@Column(nullable = false)
	private LocalDate krajnjiDatum;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double cenaZakupa;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double dodatniPopust;
	
	@Column(nullable = false)
	@Min(value = 0)
	private double popustNaTip;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TipZakupa tip;
	
	@Column(nullable = true)
	private double ocena;
	
	@ManyToOne
	private Soba soba;

	@ManyToMany
	@JoinTable(name = "spoj_zakup_opcija", 
	   joinColumns = @JoinColumn(name = "zakup_id"), 
	   inverseJoinColumns = @JoinColumn(name = "opcija_id"))
	private List<Opcija> opcije;
	
	@OneToOne
	private Rezervacija rezervacija;
	
	public ZakupSobe() { }
	
	public ZakupSobe(ZakupSobeDTO zakupDTO) {
		this.id = zakupDTO.getId();
		this.pocetniDatum = zakupDTO.getPocetniDatum();
		this.krajnjiDatum = zakupDTO.getKrajnjiDatum();
		this.cenaZakupa = zakupDTO.getCenaZakupa();
		this.dodatniPopust = zakupDTO.getDodatniPopust();
		this.popustNaTip = zakupDTO.getPopustNaTip();
		this.ocena = zakupDTO.getOcena();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getPocetniDatum() {
		return pocetniDatum;
	}

	public void setPocetniDatum(LocalDate pocetniDatum) {
		this.pocetniDatum = pocetniDatum;
	}

	public LocalDate getKrajnjiDatum() {
		return krajnjiDatum;
	}

	public void setKrajnjiDatum(LocalDate krajnjiDatum) {
		this.krajnjiDatum = krajnjiDatum;
	}

	public double getCenaZakupa() {
		return cenaZakupa;
	}

	public void setCenaZakupa(double cenaZakupa) {
		this.cenaZakupa = cenaZakupa;
	}

	public double getDodatniPopust() {
		return dodatniPopust;
	}

	public void setDodatniPopust(double dodatniPopust) {
		this.dodatniPopust = dodatniPopust;
	}

	public double getPopustNaTip() {
		return popustNaTip;
	}

	public void setPopustNaTip(double popustNaTip) {
		this.popustNaTip = popustNaTip;
	}

	public List<Opcija> getOpcije() {
		return opcije;
	}

	public void setOpcije(List<Opcija> opcije) {
		this.opcije = opcije;
	}

	public TipZakupa getTip() {
		return tip;
	}

	public void setTip(TipZakupa tip) {
		this.tip = tip;
	}

	public Rezervacija getRezervacija() {
		return rezervacija;
	}

	public void setRezervacija(Rezervacija rezervacija) {
		this.rezervacija = rezervacija;
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public double getOcena() {
		return ocena;
	}

	public void setOcena(double ocena) {
		this.ocena = ocena;
	}
	
}
