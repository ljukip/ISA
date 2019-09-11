package com.booking.application.dto.avionskakompanija;

import java.util.ArrayList;
import java.util.List;

import com.booking.application.model.avionskakompanija.KlasaSedista;
import com.booking.application.model.avionskakompanija.Sediste;

public class SedisteDTO {

    private static final int MAX_SIRINA = 6;
	private Long id;
	private KlasaSedista klasa;
    private double cena;
    private KategorijaPrtljagaDTO kategorijaPrtljagaDTO;
	private LetDTO letDTO;
    private String imePutnika;
    private String prezimePutnika;
    private String brojPasosa;
    private String email;
	
    public SedisteDTO() { }
    
    public SedisteDTO(Sediste sediste) {
    	this.id = sediste.getId();
    	this.klasa = sediste.getKlasa();
    	this.cena = sediste.getCena();
    	if(sediste.getKategorijaPrtljaga() != null) this.kategorijaPrtljagaDTO = new KategorijaPrtljagaDTO(sediste.getKategorijaPrtljaga());	
    	this.letDTO = new LetDTO(sediste.getLet());
    	this.imePutnika = sediste.getImePutnika();
    	this.prezimePutnika = sediste.getPrezimePutnika();
    	this.brojPasosa = sediste.getBrojPasosa();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public KlasaSedista getKlasa() {
		return klasa;
	}

	public void setKlasa(KlasaSedista klasa) {
		this.klasa = klasa;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public KategorijaPrtljagaDTO getKategorijaPrtljagaDTO() {
		return kategorijaPrtljagaDTO;
	}

	public void setKategorijaPrtljagaDTO(KategorijaPrtljagaDTO kategorijaPrtljagaDTO) {
		this.kategorijaPrtljagaDTO = kategorijaPrtljagaDTO;
	}
    
	public static List<SedisteDTO> transformisi(List<Sediste> sedista) {
		List<SedisteDTO> rezultat = new ArrayList<SedisteDTO>();
		for(Sediste sediste : sedista) {
			rezultat.add(new SedisteDTO(sediste));
		}
		return rezultat;
	}

	public static List<List<SedisteDTO>> transformisiZaLet(List<Sediste> sedista) {
		List<SedisteDTO> privremeni = new ArrayList<SedisteDTO>();
		List<List<SedisteDTO>> rezultat = new ArrayList<List<SedisteDTO>>();
		for(Sediste sediste : sedista) {
			privremeni.add(new SedisteDTO(sediste));
			if(privremeni.size() == MAX_SIRINA) {
				rezultat.add(new ArrayList<SedisteDTO>(privremeni));
				privremeni.clear();
			}
		}
		if(!privremeni.isEmpty()) rezultat.add(privremeni);
		return rezultat;
	}
	
	public LetDTO getLetDTO() {
		return letDTO;
	}

	public void setLetDTO(LetDTO letDTO) {
		this.letDTO = letDTO;
	}

	public String getImePutnika() {
		return imePutnika;
	}

	public void setImePutnika(String imePutnika) {
		this.imePutnika = imePutnika;
	}

	public String getPrezimePutnika() {
		return prezimePutnika;
	}

	public void setPrezimePutnika(String prezimePutnika) {
		this.prezimePutnika = prezimePutnika;
	}

	public String getBrojPasosa() {
		return brojPasosa;
	}

	public void setBrojPasosa(String brojPasosa) {
		this.brojPasosa = brojPasosa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
