package com.booking.application.dto.korisnici;

public class LoginDTO {

	private String email;
	private String lozinka;
	
	public LoginDTO() { }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
}
