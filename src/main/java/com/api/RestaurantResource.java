package com.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Restaurant;
import com.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantResource {
	@Autowired
	private RestaurantService service;

	// CRUD
	// Create
	@PostMapping
	public Restaurant save(@RequestBody Restaurant restaurant) {
		return service.create(restaurant);
	}

	// Read all
	@GetMapping
	public List<Restaurant> findAll() {
		return service.findAll();
	}

	// Read detail
	@GetMapping("/{id}")
	public Restaurant getById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	// Update
	@PutMapping("/{id}")
	public Restaurant update(@PathVariable("id") Long id, @RequestBody Restaurant restaurant) {
		return service.update(id, restaurant);
	}

	// Delete
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
