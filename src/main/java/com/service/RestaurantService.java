package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Restaurant;
import com.repository.IRestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	IRestaurantRepository repository;

	public Restaurant save(Restaurant restaurant) {
		return repository.save(restaurant);
	}

//	public Restaurant update(Long id, Restaurant restaurant) {
//		return repository.update(id, restaurant.getName());
//	}

	public List<Restaurant> findAll() {
		return repository.findAll();
	}

	public Optional<Restaurant> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
