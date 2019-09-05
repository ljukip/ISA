package com.booking.application.service.korisnici;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.booking.application.model.korisnici.AdminSistema;
import com.booking.application.repository.korisnici.AdminSistemaRepository;

@Service
public class AdminSistemaService {

	@Autowired
	private AdminSistemaRepository adminSistemaRepository;
	
	public List<AdminSistema> vratiSve() {
		return this.adminSistemaRepository.findAll();
	}
	
	public AdminSistema vratiJednog(Long adminId) {
		Optional<AdminSistema> admin = this.adminSistemaRepository.findById(adminId);
		if(admin.isPresent()) {
			return admin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}
	
	public AdminSistema kreiraj(AdminSistema adminSistema) {
		AdminSistema kreiraniAdmin = this.adminSistemaRepository.save(adminSistema);
		return kreiraniAdmin;
	}

	public AdminSistema azuriraj(AdminSistema noviAdmin) {
		AdminSistema stariAdmin = this.vratiJednog(noviAdmin.getId());
		stariAdmin.prekopiraj(noviAdmin);
		this.adminSistemaRepository.save(stariAdmin);
		return stariAdmin;
	}
	
	public void obrisi(Long adminId) {
		AdminSistema admin = this.vratiJednog(adminId);
		this.adminSistemaRepository.delete(admin);
	}
	
}
