package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Restaurant;
import com.repositorie.IRestaurantRepository;

@Service(value = "service")
public class RService {
	@Autowired
	IRestaurantRepository restaurantRepository;
	
	public List<Restaurant> getAll() {
		return restaurantRepository.findAll();
	}
}
