package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Restaurant;

public interface ITableRepository extends CrudRepository<Restaurant, Long>{
	
	List<Restaurant> findAll();
}
