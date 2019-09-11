package com.booking.application.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class VremeDatumUtils {

	public static long razlikaUDanima(LocalDate pocetniDatum, LocalDate krajnjiDatum) {
		return ChronoUnit.DAYS.between(pocetniDatum, krajnjiDatum);
	}
	
	public static long razlikaUSatima(Date pocetniDatum, Date krajnjiDatum) {
		long razlika = krajnjiDatum.getTime() - pocetniDatum.getTime();
	    return TimeUnit.HOURS.convert(razlika, TimeUnit.MILLISECONDS);
	}
	
	public static boolean slobodanTermin(LocalDate pocetakPostojece, LocalDate krajPostojece, LocalDate pocetakNove, LocalDate krajNove) {
		if(pocetakNove.isAfter(pocetakPostojece) && pocetakNove.isBefore(krajPostojece)) {
			return false;
		}
		if(krajNove.isAfter(pocetakPostojece) && krajNove.isBefore(krajPostojece)) {
			return false;
		}
		return true;
	}
	
}
