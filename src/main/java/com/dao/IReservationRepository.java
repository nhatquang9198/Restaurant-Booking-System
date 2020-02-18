package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.model.Reservation;

public interface IReservationRepository extends PagingAndSortingRepository<Reservation, Long> {

	@Override
	public List<Reservation> findAll();

	public List<Reservation> findByDate(LocalDate date);

	public List<Reservation> findByRestaurantId(Long restaurantId);

}
