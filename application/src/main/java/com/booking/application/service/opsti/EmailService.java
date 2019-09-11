package com.booking.application.service.opsti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	private static final String REGISTRACIJA_NASLOV = "Potvrda registracije";
	private static final String REGISTRACIJA_TEKST = "Uspesno ste se registrovali. Potrebno je samo da"
			+ " aktivirate Vas nalog klikom na sledeci link: ";
	private static final String LINK_ZA_REGISTRACIJU = "http://localhost:8081/korisnici/obicni/";
	private static final String AKTIVACIJA = "/aktiviraj";
	
	private static final String POZIV_NASLOV = "Poziv na rezervaciju";
	private static final String POZIV_TEKST_1 = "Pozvani ste na rezervaciju. Link za potvrdu rezervacije je: ";
	private static final String POZIV_TEKST_2 = " , a za otkazivanje je: ";
	private static final String LINK_ZA_POZIV = "http://localhost:8081/avionske-kompanije/0/letovi/0/sedista/";
	private static final String OTKAZIVANJE = "/otkazi";
	private static final String POTVRDJIVANJE = "/potvrdi";
	
	@Autowired
	private JavaMailSender sender;
	
	private void sendMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(text);
        sender.send(message);
	}

	public void posaljiLinkZaRegistraciju(String email, Long korisnikId) {
		String text = REGISTRACIJA_TEKST + LINK_ZA_REGISTRACIJU + korisnikId + AKTIVACIJA;
		this.sendMessage(email, REGISTRACIJA_NASLOV, text);
	}
	
	public void posaljiPozivZaRegistraciju(String email, Long sedisteId) {
		String text = POZIV_TEKST_1 + LINK_ZA_POZIV + sedisteId + POTVRDJIVANJE + POZIV_TEKST_2 + LINK_ZA_POZIV + OTKAZIVANJE;
		this.sendMessage(email, POZIV_NASLOV, text);
	}
	
}
