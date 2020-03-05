package com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Reservation;
import com.service.ReservationService;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}")
@CrossOrigin
public class ReservationResource {
	@Autowired
	private ReservationService reservationService;

	// Create
	@PostMapping("/tables/{tableId}/reserve")
	public Reservation save(@PathVariable("tableId") Long tableId, @PathVariable("restaurantId") Long restaurantId,
			@RequestParam("date") String date) {
		return reservationService.create(tableId, restaurantId, date);
	}

	// Read all reservations of a specific restaurant
	@GetMapping("/reservations")
	public List<Reservation> findAll(@PathVariable("restaurantId") Long restaurantId) {
		return reservationService.findByRestaurantId(restaurantId);
	}

	// Read detail of a specific reservation
	// @GetMapping("/reservations/{reservationId}")
	// public Reservation findById(@PathVariable("reservationId") Long
	// reservationId) {
	// return reservationService.findById(reservationId);
	// }

	@GetMapping("/reservations/{reservationId}")
	public ResponseEntity<Reservation> findById(@PathVariable("reservationId") Long reservationId) {
		// return reservationService.findById(reservationId);
		return ResponseEntity.ok().body(reservationService.findById(reservationId));
	}

	// Update
	@PutMapping("/reservations/{reservationId}")
	public Reservation update(@PathVariable("reservationId") Long reservationId, @RequestBody Reservation reservation) {
		return reservationService.update(reservationId, reservation);
	}

	// Delete
	@DeleteMapping("/reservations/{reservationId}")
	public ResponseEntity<Void> delete(@PathVariable("reservationId") Long reservationId,
			@RequestBody Reservation reservation) {
		reservationService.deleteById(reservationId);
		return ResponseEntity.noContent().header("Content-Length", "0").build();
	}

}
