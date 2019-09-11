package com.booking.application.dto.avionskakompanija;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PretragaLetaDTO {

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date datumPoletanja;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date datumSletanja;
	private String gradPoletanja;
	private String gradSletanja;
	
	public PretragaLetaDTO() { }

	public Date getDatumPoletanja() {
		return datumPoletanja;
	}

	public void setDatumPoletanja(Date datumPoletanja) {
		this.datumPoletanja = datumPoletanja;
	}

	public Date getDatumSletanja() {
		return datumSletanja;
	}

	public void setDatumSletanja(Date datumSletanja) {
		this.datumSletanja = datumSletanja;
	}

	public String getGradPoletanja() {
		return gradPoletanja;
	}

	public void setGradPoletanja(String gradPoletanja) {
		this.gradPoletanja = gradPoletanja;
	}

	public String getGradSletanja() {
		return gradSletanja;
	}

	public void setGradSletanja(String gradSletanja) {
		this.gradSletanja = gradSletanja;
	}
	
}
