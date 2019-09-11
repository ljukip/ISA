package com.booking.application.dto.opsti;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StavkaStatistikeDTO {

	private String datum;
	private int vrednost;
	
	public StavkaStatistikeDTO() { }
	
	public StavkaStatistikeDTO(LocalDate datum, int vrednost) {
		this.vrednost = vrednost;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.datum = datum.format(formatter);
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public int getVrednost() {
		return vrednost;
	}

	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	
}
