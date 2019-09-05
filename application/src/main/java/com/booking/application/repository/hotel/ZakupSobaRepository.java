package com.booking.application.repository.hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.hotel.ZakupSoba;

@Repository
public interface ZakupSobaRepository extends JpaRepository<ZakupSoba, Long>{

}
