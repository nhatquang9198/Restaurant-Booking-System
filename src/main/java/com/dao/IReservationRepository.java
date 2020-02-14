package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Reservation;

public interface IReservationRepository extends CrudRepository<Reservation, Long> {

	@Override
	List<Reservation> findAll();
}
