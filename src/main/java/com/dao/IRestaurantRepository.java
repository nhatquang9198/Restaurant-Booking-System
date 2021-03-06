package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.model.Restaurant;

@Repository
public interface IRestaurantRepository extends PagingAndSortingRepository<Restaurant, Long> {

	@Override
	@Query("Select r from Restaurant as r")
	public List<Restaurant> findAll();
}
