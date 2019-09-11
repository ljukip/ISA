package com.booking.application.service.vozila;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.model.vozila.KompanijaVozila;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.repository.vozila.KompanijaVozilaRepository;
import com.booking.application.service.opsti.AdresaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KompanijaVozilaServiceTest {
	@Mock
	private KompanijaVozilaRepository kompanijaVozilaRepository;

	@Mock
	private AdresaService adresaService;
	
	@Mock
	private AdresaRepository adresaRepository;
	
	@Mock
	private ZakupVozilaService zakupVozilaService;
	
	@InjectMocks
	private KompanijaVozilaService kompanijaVozilaService;
	
	@Mock
	private KompanijaVozila kompanijaVozilaMock;
	
	@Test
	public void testVratiSve() {
		PageRequest pageRequest = PageRequest.of(1, 10);
		when(kompanijaVozilaRepository.findAll(pageRequest)).thenReturn(
				new PageImpl<KompanijaVozila>(Arrays.asList(new KompanijaVozila()).subList(0, 1), pageRequest, 1));

		List<KompanijaVozila> KompanijaVozilas = kompanijaVozilaService.vratiSve(pageRequest);

		assertThat(KompanijaVozilas).hasSize(1);
		verify(kompanijaVozilaRepository, times(1)).findAll(pageRequest);
		verifyNoMoreInteractions(kompanijaVozilaRepository);
	}

	@Test
	public void testVratiJedan() {
		when(kompanijaVozilaRepository.findById(1L)).thenReturn(Optional.of(kompanijaVozilaMock));

		KompanijaVozila KompanijaVozila = kompanijaVozilaService.vratiJednu(1L);

		assertEquals(kompanijaVozilaMock, KompanijaVozila);
		verify(kompanijaVozilaRepository, times(1)).findById(1L);
		verifyNoMoreInteractions(kompanijaVozilaRepository);
	}

	@Test
	public void testAzuriraj() {
		AdresaDTO adresaDTO = new AdresaDTO();
		adresaDTO.setUlica("ulica");
		adresaDTO.setBroj(1);
		adresaDTO.setGrad("grad");
		adresaDTO.setLatitude(1.0);
		adresaDTO.setLongitude(1.0);
		Adresa adresa = new Adresa(adresaDTO);
		KompanijaVozila KompanijaVozila = new KompanijaVozila();
		KompanijaVozila.setId(1L);
		KompanijaVozila.setNaziv("naziv");
		KompanijaVozila.setAdresa(adresa);
		KompanijaVozila.setOpis("opis");
		when(kompanijaVozilaRepository.findById(KompanijaVozila.getId()))
				.thenReturn(Optional.of(KompanijaVozila));
		when(kompanijaVozilaRepository.save(KompanijaVozila)).thenReturn(KompanijaVozila);
		when(adresaRepository.save(KompanijaVozila.getAdresa())).thenReturn(KompanijaVozila.getAdresa());

		KompanijaVozila dbKompanijaVozila = kompanijaVozilaService.azuriraj(KompanijaVozila, adresaDTO);

		assertThat(dbKompanijaVozila).isNotNull();
		assertThat(dbKompanijaVozila.getNaziv()).isEqualTo(KompanijaVozila.getNaziv());
		assertThat(dbKompanijaVozila.getAdresa()).isEqualTo(KompanijaVozila.getAdresa());
		assertThat(dbKompanijaVozila.getOpis()).isEqualTo(KompanijaVozila.getOpis());
		verify(kompanijaVozilaRepository, times(1)).findById(KompanijaVozila.getId());
		verify(kompanijaVozilaRepository, times(1)).save(KompanijaVozila);
		verify(adresaRepository, times(1)).save(KompanijaVozila.getAdresa());
		verifyNoMoreInteractions(kompanijaVozilaRepository);
	}

	@Test
	public void testObrisi() {
		KompanijaVozila kompanijaVozila = new KompanijaVozila();
		kompanijaVozila.setId(1L);
		kompanijaVozila.setGaraze(new ArrayList<>());
		kompanijaVozila.setAdresa(new Adresa());
		when(kompanijaVozilaRepository.findById(kompanijaVozila.getId()))
				.thenReturn(Optional.of(kompanijaVozila));
		doNothing().when(kompanijaVozilaRepository).delete(kompanijaVozila);

		kompanijaVozilaService.obrisi(kompanijaVozila.getId());

		verify(kompanijaVozilaRepository, times(1)).delete(kompanijaVozila);
		verify(kompanijaVozilaRepository, times(1)).findById(kompanijaVozila.getId());
		verifyNoMoreInteractions(kompanijaVozilaRepository);
	}


}
