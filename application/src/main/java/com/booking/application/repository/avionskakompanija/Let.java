package com.booking.application.repository.avionskakompanija;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.booking.application.dto.avionskakompanija.LetDTO;
import com.booking.application.model.avionskakompanija.AvionskaKarta;
import com.booking.application.model.avionskakompanija.Sediste;
import com.booking.application.model.opsti.Destinacija;

@Entity
public class Let {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @Min(50)
    @Max(2000)
    private double duzina;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date vremePoletanja;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
	private Date vremeSletanja;
    
    @Column(nullable = false)
    @Min(10)
    private double cena;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipLeta tip;
    
    @Column(nullable = false)
    private Long vremePutovanja;
    
    @ManyToOne
    private AvionskaKompanija avionskaKompanija;

    @ManyToOne
    private Destinacija polaziste;
    
    @Column(nullable = true, length = 128)
    private String presedanja;
    
    @ManyToOne
    private Destinacija odrediste;
    
    @OneToMany(mappedBy = "let")
    private List<Sediste> sedista;
    
    @OneToMany(mappedBy = "let")
    private List<AvionskaKarta> avionskeKarte;
    
    public Let() { }
    
    public Let(LetDTO letDTO) {
		this.id = letDTO.getId();
		this.duzina = letDTO.getDuzina();
		this.vremePoletanja = letDTO.getVremePoletanja();
		this.vremeSletanja = letDTO.getVremeSletanja();
		this.cena = letDTO.getCena();
		this.vremePutovanja = letDTO.getVremePutovanja();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getDuzina() {
		return duzina;
	}

	public void setDuzina(double duzina) {
		this.duzina = duzina;
	}

	public Date getVremePoletanja() {
		return vremePoletanja;
	}

	public void setVremePoletanja(Date vremePoletanja) {
		this.vremePoletanja = vremePoletanja;
	}

	public Date getVremeSletanja() {
		return vremeSletanja;
	}

	public void setVremeSletanja(Date vremeSletanja) {
		this.vremeSletanja = vremeSletanja;
	}

	public AvionskaKompanija getAvionskaKompanija() {
		return avionskaKompanija;
	}

	public void setAvionskaKompanija(AvionskaKompanija avionskaKompanija) {
		this.avionskaKompanija = avionskaKompanija;
	}

	public Destinacija getPolaziste() {
		return polaziste;
	}

	public void setPolaziste(Destinacija polaziste) {
		this.polaziste = polaziste;
	}

	public String getPresedanja() {
		return presedanja;
	}

	public void setPresedanja(String presedanja) {
		this.presedanja = presedanja;
	}

	public Destinacija getOdrediste() {
		return odrediste;
	}

	public void setOdrediste(Destinacija odrediste) {
		this.odrediste = odrediste;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public List<Sediste> getSedista() {
		return sedista;
	}

	public void setSedista(List<Sediste> sedista) {
		this.sedista = sedista;
	}

	public List<AvionskaKarta> getAvionskeKarte() {
		return avionskeKarte;
	}

	public void setAvionskeKarte(List<AvionskaKarta> avionskeKarte) {
		this.avionskeKarte = avionskeKarte;
	}

	public TipLeta getTip() {
		return tip;
	}

	public void setTip(TipLeta tip) {
		this.tip = tip;
	}

	public Long getVremePutovanja() {
		return vremePutovanja;
	}

	public void setVremePutovanja(Long vremePutovanja) {
		this.vremePutovanja = vremePutovanja;
	}
    
}
