package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Restaurant;
import com.repository.IRestaurantRepository;

@Service(value = "service")
public class RestaurantService {
	@Autowired
	IRestaurantRepository restaurantRepository;
	
	public Restaurant save(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}
	
	
}
