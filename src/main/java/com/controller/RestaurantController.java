package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Restaurant;
import com.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantService service;

	@PostMapping
	public Restaurant save(@RequestBody Restaurant restaurant) {
		return service.save(restaurant);
	}

//	@PutMapping("/{id}")
//	public Restaurant update(@PathVariable("id") Long id, @RequestBody Restaurant restaurant) {
//		return service.update(id, restaurant);
//	}

	@GetMapping
	public List<Restaurant> readAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Restaurant> getById(@PathVariable("id") Long id) {
		return service.findById(id);
	}

	@DeleteMapping("/{id}")
	public void create(@PathVariable("id") Long id) {
		service.deleteById(id);
	}
}
