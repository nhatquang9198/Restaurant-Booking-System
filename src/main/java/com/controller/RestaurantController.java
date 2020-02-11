package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	private RestaurantService restaurantService;
	
	@PostMapping
	public Restaurant save(@RequestBody Restaurant restaurant) {
		return restaurantService.save(restaurant);
	}
	
	@GetMapping
	public List<Restaurant> readAll() {
		return restaurantService.findAll();
	}
	
	
}
