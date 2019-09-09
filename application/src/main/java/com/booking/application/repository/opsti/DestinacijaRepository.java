package com.booking.application.repository.opsti;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.application.model.opsti.Destinacija;

@Repository
public interface DestinacijaRepository extends JpaRepository<Destinacija, Long> {

}
