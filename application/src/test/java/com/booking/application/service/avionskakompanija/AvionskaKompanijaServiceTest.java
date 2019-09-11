package com.booking.application.service.avionskakompanija;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

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
import com.booking.application.model.avionskakompanija.AvionskaKompanija;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.repository.avionskakompanija.AvionskaKompanijaRepository;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.service.opsti.AdresaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AvionskaKompanijaServiceTest {
	@Mock
	private AvionskaKompanijaRepository avionskaKompanijaRepository;

	@Mock
	private AdresaService adresaService;

	@Mock
	private AdresaRepository adresaRepository;

	@Mock
	private AvionskaKompanija avionskaKompanijaMock;

	@InjectMocks
	private AvionskaKompanijaService avionskaKompanijaService;

	@Test
	public void testVratiSve() {
		PageRequest pageRequest = PageRequest.of(1, 10);
		when(avionskaKompanijaRepository.findAll(pageRequest)).thenReturn(
				new PageImpl<AvionskaKompanija>(Arrays.asList(new AvionskaKompanija()).subList(0, 1), pageRequest, 1));

		List<AvionskaKompanija> avionskaKompanijas = avionskaKompanijaService.vratiSve(pageRequest);

		assertThat(avionskaKompanijas).hasSize(1);
		verify(avionskaKompanijaRepository, times(1)).findAll(pageRequest);
		verifyNoMoreInteractions(avionskaKompanijaRepository);
	}

	@Test
	public void testVratiJedan() {
		when(avionskaKompanijaRepository.findById(1L)).thenReturn(Optional.of(avionskaKompanijaMock));

		AvionskaKompanija avionskaKompanija = avionskaKompanijaService.vratiJednu(1L);

		assertEquals(avionskaKompanijaMock, avionskaKompanija);
		verify(avionskaKompanijaRepository, times(1)).findById(1L);
		verifyNoMoreInteractions(avionskaKompanijaRepository);
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
		AvionskaKompanija avionskaKompanija = new AvionskaKompanija();
		avionskaKompanija.setId(1L);
		avionskaKompanija.setNaziv("naziv");
		avionskaKompanija.setAdresa(adresa);
		avionskaKompanija.setOpis("opis");
		when(avionskaKompanijaRepository.findById(avionskaKompanija.getId()))
				.thenReturn(Optional.of(avionskaKompanija));
		when(avionskaKompanijaRepository.save(avionskaKompanija)).thenReturn(avionskaKompanija);
		when(adresaRepository.save(avionskaKompanija.getAdresa())).thenReturn(avionskaKompanija.getAdresa());

		AvionskaKompanija dbAvionskaKompanija = avionskaKompanijaService.azuriraj(avionskaKompanija, adresaDTO);

		assertThat(dbAvionskaKompanija).isNotNull();
		assertThat(dbAvionskaKompanija.getNaziv()).isEqualTo(avionskaKompanija.getNaziv());
		assertThat(dbAvionskaKompanija.getAdresa()).isEqualTo(avionskaKompanija.getAdresa());
		assertThat(dbAvionskaKompanija.getOpis()).isEqualTo(avionskaKompanija.getOpis());
		verify(avionskaKompanijaRepository, times(1)).findById(avionskaKompanija.getId());
		verify(avionskaKompanijaRepository, times(1)).save(avionskaKompanija);
		verify(adresaRepository, times(1)).save(avionskaKompanija.getAdresa());
		verifyNoMoreInteractions(avionskaKompanijaRepository);
	}

	@Test
	public void testObrisi() {
		AvionskaKompanija avionskaKompanija = new AvionskaKompanija();
		avionskaKompanija.setId(1L);
		when(avionskaKompanijaRepository.findById(avionskaKompanija.getId()))
				.thenReturn(Optional.of(avionskaKompanija));
		doNothing().when(avionskaKompanijaRepository).delete(avionskaKompanija);

		avionskaKompanijaService.obrisi(avionskaKompanija.getId());

		verify(avionskaKompanijaRepository, times(1)).delete(avionskaKompanija);
		verify(avionskaKompanijaRepository, times(1)).findById(avionskaKompanija.getId());
		verifyNoMoreInteractions(avionskaKompanijaRepository);
	}

}
