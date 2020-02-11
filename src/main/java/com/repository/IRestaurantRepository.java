package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Restaurant;

@Repository
public interface IRestaurantRepository extends CrudRepository<Restaurant, Long> {
	
	List<Restaurant> findAll();
}
