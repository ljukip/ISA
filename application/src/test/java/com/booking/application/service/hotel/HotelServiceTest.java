package com.booking.application.service.hotel;

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
import com.booking.application.model.hotel.Hotel;
import com.booking.application.model.opsti.Adresa;
import com.booking.application.repository.hotel.HotelRepository;
import com.booking.application.repository.opsti.AdresaRepository;
import com.booking.application.service.opsti.AdresaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelServiceTest {

	@Mock
	private HotelRepository hotelRepositoryMock;

	@Mock
	private AdresaService adresaService;

	@Mock
	private AdresaRepository adresaRepository;

	@Mock
	private Hotel hotelMock;

	@InjectMocks
	private HotelService hotelService;

	@Test
	public void testVratiSve() {
		PageRequest pageRequest = PageRequest.of(1, 10);
		when(hotelRepositoryMock.findAll(pageRequest))
				.thenReturn(new PageImpl<Hotel>(Arrays.asList(new Hotel()).subList(0, 1), pageRequest, 1));

		List<Hotel> hotels = hotelService.vratiSve(pageRequest);

		assertThat(hotels).hasSize(1);
		verify(hotelRepositoryMock, times(1)).findAll(pageRequest);
		verifyNoMoreInteractions(hotelRepositoryMock);
	}

	@Test
	public void testVratiJedan() {
		when(hotelRepositoryMock.findById(1L)).thenReturn(Optional.of(hotelMock));

		Hotel hotel = hotelService.vratiJedan(1L);

		assertEquals(hotelMock, hotel);
		verify(hotelRepositoryMock, times(1)).findById(1L);
		verifyNoMoreInteractions(hotelRepositoryMock);
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
		Hotel hotel = new Hotel();
		hotel.setId(1L);
		hotel.setNaziv("naziv");
		hotel.setAdresa(adresa);
		hotel.setOpis("opis");
		when(hotelRepositoryMock.findById(hotel.getId())).thenReturn(Optional.of(hotel));
		when(hotelRepositoryMock.save(hotel)).thenReturn(hotel);
		when(adresaRepository.save(hotel.getAdresa())).thenReturn(hotel.getAdresa());

		Hotel dbHotel = hotelService.azuriraj(hotel, adresaDTO);

		assertThat(dbHotel).isNotNull();
		assertThat(dbHotel.getNaziv()).isEqualTo(hotel.getNaziv());
		assertThat(dbHotel.getAdresa()).isEqualTo(hotel.getAdresa());
		assertThat(dbHotel.getOpis()).isEqualTo(hotel.getOpis());
		verify(hotelRepositoryMock, times(1)).findById(hotel.getId());
		verify(hotelRepositoryMock, times(1)).save(hotel);
		verify(adresaRepository, times(1)).save(hotel.getAdresa());
		verifyNoMoreInteractions(hotelRepositoryMock);
	}

	@Test
	public void testObrisi() {
		Hotel hotel = new Hotel();
		hotel.setId(1L);
		hotel.setSobe(new ArrayList<>());
		when(hotelRepositoryMock.findById(hotel.getId())).thenReturn(Optional.of(hotel));
		doNothing().when(hotelRepositoryMock).delete(hotel);

		hotelService.obrisi(hotel.getId());

		verify(hotelRepositoryMock, times(1)).delete(hotel);
		verify(hotelRepositoryMock, times(1)).findById(hotel.getId());
		verifyNoMoreInteractions(hotelRepositoryMock);
	}

}
