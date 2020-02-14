package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IReservationRepository;
import com.dao.ITableRepository;
import com.model.ResTable;
import com.model.Reservation;

@Service
public class ReservationService {
	@Autowired
	private IReservationRepository reservationRepository;
	@Autowired
	private ITableRepository tableRepository;

	public Reservation create(Long tableId, Reservation reservation) {
		ResTable table = tableRepository.findById(tableId).get();
		reservation.setResTable(table);

		return reservationRepository.save(reservation);
	}

	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	public Reservation findById(Long id) {
		return reservationRepository.findById(id).get();
	}

	public Reservation update(Long id, Reservation reservation) {
		Reservation res = reservationRepository.findById(id).get();
		res.setApproved(reservation.isApproved());
		res.setDate(reservation.getDate());

		return reservationRepository.save(res);
	}

	public void deleteById(Long id) {
		reservationRepository.deleteById(id);
	}

	public List<Reservation> findByRestaurantId(Long id) {
		reservationRepository.f
	}
}
