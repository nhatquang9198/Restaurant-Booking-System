package com.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.ResTable;
import com.model.Reservation;
import com.service.ReservationService;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}")
public class ReservationResource {
	@Autowired
	private ReservationService reservationService;

	// Create
	@PostMapping("tables/{tableId}")
	public ResTable save(@PathVariable("tableId") Long restaurantId, @RequestBody Reservation reservation) {
		return reservationService.create(restaurantId, reservation);
	}

	// Read all reservations of a specific restaurant
	@GetMapping
	public List<ResTable> findAll(@PathVariable("restaurantId") Long restaurantId) {
		return reservationService.findTablesByRestaurantId(restaurantId);
	}

	// Read detail of a specific table
	@GetMapping("/{tableId}")
	public ResTable findById(@PathVariable("tableId") Long tableId) {
		return reservationService.findById(tableId);
	}

}
