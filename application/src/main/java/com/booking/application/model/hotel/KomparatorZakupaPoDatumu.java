package com.booking.application.model.hotel;

import java.util.Comparator;

public class KomparatorZakupaPoDatumu implements Comparator<CenovnikSobe> {

	@Override
	public int compare(CenovnikSobe o1, CenovnikSobe o2) {
		if (o1.getPocetniDatum() == null || o2.getPocetniDatum() == null)
			return 0;
		return o1.getPocetniDatum().compareTo(o2.getPocetniDatum());
	}

}
