package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IRestaurantRepository;
import com.model.Restaurant;

@Service
public class RestaurantService {
	@Autowired
	private IRestaurantRepository restaurantRepository;

	public Restaurant create(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	public Restaurant findById(Long id) {
		return restaurantRepository.findById(id).get();
	}

	public Restaurant update(Long id, Restaurant restaurant) {
		Restaurant res = restaurantRepository.findById(id).get();
		res.setName(restaurant.getName());

		return restaurantRepository.save(res);
	}

	public void deleteById(Long id) {
		restaurantRepository.deleteById(id);
	}

}
