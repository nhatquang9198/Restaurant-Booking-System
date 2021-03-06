package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IReservationRepository;
import com.dao.IRestaurantRepository;
import com.dao.ITableRepository;
import com.model.ResTable;
import com.model.Reservation;
import com.model.Restaurant;

@Service
public class ReservationService {
	@Autowired
	private IReservationRepository reservationRepository;
	@Autowired
	private ITableRepository tableRepository;
	@Autowired
	private IRestaurantRepository restaurantRepository;

	public Reservation create(Long restaurantId, Long tableId, String date) {
		LocalDate reserve_date = LocalDate.parse(date);
		reserve_date = reserve_date.plusDays(1);

		if (isValidDate(reserve_date)) {
			System.out.println(tableId+"asdhjagweqwen\\n\n\n\n\n\n\n\nn");
			ResTable table = tableRepository.findById(tableId).get();
			Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

			Reservation reservation = new Reservation();

			reservation.setRestaurant(restaurant);
			reservation.setResTable(table);
			reservation.setDate(reserve_date);

			return reservationRepository.save(reservation);
		} else {
			return null;
		}
	}

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		return reservationRepository.findById(id).get();
	}

	public List<Reservation> findByDate(LocalDate date) {
		return reservationRepository.findByDate(date);
	}

	public Reservation update(Long reservationId, Reservation reservation) {
		Reservation res = reservationRepository.findById(reservationId).get();

		res.setApproved(reservation.isApproved());
		res.setDate(reservation.getDate());
		res.setResTable(reservation.getResTable());

		return reservationRepository.save(res);
	}

	public void deleteById(Long reservationId) {
		reservationRepository.deleteById(reservationId);
	}

	public List<Reservation> findByRestaurantId(Long restaurantId) {
		return reservationRepository.findByRestaurantId(restaurantId);
	}

	private boolean isValidDate(LocalDate date) {
		LocalDate yesterday = LocalDate.now().minusDays(1);
		return date.isAfter(yesterday) ? true : false;
	}

}
