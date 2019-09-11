package com.booking.application.controller.vozila;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.booking.application.TestUtil;
import com.booking.application.dto.opsti.AdresaDTO;
import com.booking.application.dto.vozila.KompanijaVozilaDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class KompanijaVozilaControllerTest {
	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	private static final String URL_PREFIX = "/kompanije-vozila";

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@PostConstruct
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testVratiSveKompanijeVozila() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "?page=0&size=5"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$.[*].id").value(hasItem(1)))
				.andExpect(jsonPath("$.[*].naziv").value(hasItem("naziv")))
				.andExpect(jsonPath("$.[*].prosecnaOcena").value(hasItem(0.0)))
				.andExpect(jsonPath("$.[*].opis").value(hasItem("opis")));
	}

	@Test
	public void testVratiJednuKompanijuVozila() throws Exception {
		mockMvc.perform(get(URL_PREFIX + "/" + 1))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.naziv").value("naziv"))
				.andExpect(jsonPath("$.prosecnaOcena").value(0.0))
				.andExpect(jsonPath("$.opis").value("opis"));
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testKreirajKompanijuVozila() throws Exception {
		AdresaDTO adresaDTO = new AdresaDTO();
		adresaDTO.setUlica("ulica");
		adresaDTO.setGrad("grad");
		adresaDTO.setBroj(15);
		adresaDTO.setLatitude(15);
		adresaDTO.setLongitude(15);
		adresaDTO.setZemlja("zemlja");
		KompanijaVozilaDTO kompanijaVozila = new KompanijaVozilaDTO();
		kompanijaVozila.setNaziv("naziv");
		kompanijaVozila.setAdresa(adresaDTO);
		kompanijaVozila.setOpis("opis");

		String json = TestUtil.json(kompanijaVozila);
		this.mockMvc.perform(post(URL_PREFIX).contentType(contentType).content(json))
		.andExpect(status().isCreated());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testAzurirajKompanijuVozila() throws Exception {
		AdresaDTO adresaDTO = new AdresaDTO();
		adresaDTO.setId(1);
		adresaDTO.setUlica("ulica");
		adresaDTO.setGrad("grad");
		adresaDTO.setBroj(15);
		adresaDTO.setLatitude(15);
		adresaDTO.setLongitude(15);
		adresaDTO.setZemlja("zemlja");
		KompanijaVozilaDTO kompanijaVozila = new KompanijaVozilaDTO();
		kompanijaVozila.setId(1L);
		kompanijaVozila.setNaziv("naziv");
		kompanijaVozila.setAdresa(adresaDTO);
		kompanijaVozila.setOpis("opis");
		String json = TestUtil.json(kompanijaVozila);
		this.mockMvc.perform(put(URL_PREFIX)
					.contentType(contentType).content(json))
					.andExpect(status().isOk());
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testObrisiKompanijuVozila() throws Exception {
		this.mockMvc.perform(delete(URL_PREFIX + "/" + 1)).andExpect(status().isOk());
	}

}
