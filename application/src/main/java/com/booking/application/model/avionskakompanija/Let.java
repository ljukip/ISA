package com.booking.application.model.avionskakompanija;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.booking.application.dto.avionskakompanija.LetDTO;
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
    
    @ManyToOne
    private AvionskaKompanija avionskaKompanija;
    
    @ManyToOne
    private Avion avion;

    @ManyToOne
    private Destinacija polaziste;
    
    @ManyToMany
	@JoinTable(name = "spoj_let_destinacija", 
	   joinColumns = @JoinColumn(name = "let_id"), 
	   inverseJoinColumns = @JoinColumn(name = "destinacija_id"))
    private List<Destinacija> presedanja;
    
    @ManyToOne
    private Destinacija odrediste;
    
    @OneToMany(mappedBy = "let")
    private List<SedisteNaLetu> sedista;
    
    @OneToMany(mappedBy = "polazniLet")
    private List<AvionskaKarta> polazneAvionskeKarte;
    
    @OneToMany(mappedBy = "povratniLet")
    private List<AvionskaKarta> povratneAvionskeKarte;
    
    public Let() { }
    
    public Let(LetDTO letDTO) {
		this.id = letDTO.getId();
		this.duzina = letDTO.getDuzina();
		this.vremePoletanja = letDTO.getVremePoletanja();
		this.vremeSletanja = letDTO.getVremeSletanja();
		this.cena = letDTO.getCena();
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

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Destinacija getPolaziste() {
		return polaziste;
	}

	public void setPolaziste(Destinacija polaziste) {
		this.polaziste = polaziste;
	}

	public List<Destinacija> getPresedanja() {
		return presedanja;
	}

	public void setPresedanja(List<Destinacija> presedanja) {
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

	public List<SedisteNaLetu> getSedista() {
		return sedista;
	}

	public void setSedista(List<SedisteNaLetu> sedista) {
		this.sedista = sedista;
	}

	public List<AvionskaKarta> getPolazneAvionskeKarte() {
		return polazneAvionskeKarte;
	}

	public void setPolazneAvionskeKarte(List<AvionskaKarta> polazneAvionskeKarte) {
		this.polazneAvionskeKarte = polazneAvionskeKarte;
	}

	public List<AvionskaKarta> getPovratneAvionskeKarte() {
		return povratneAvionskeKarte;
	}

	public void setPovratneAvionskeKarte(List<AvionskaKarta> povratneAvionskeKarte) {
		this.povratneAvionskeKarte = povratneAvionskeKarte;
	}
    
}
