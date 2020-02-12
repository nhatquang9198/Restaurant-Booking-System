package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Restaurant;
import com.model.ResTable;
import com.service.RestaurantService;
import com.service.TableService;

@RestController
@RequestMapping("/api/restaurants/{id}")
public class TableController {
	@Autowired
	private TableService tableService;
	@Autowired
	private RestaurantService restaurantService;

	@PostMapping
	public ResTable save(@PathVariable("id") Long restaurantId, @RequestBody ResTable table) {
		Restaurant restaurant =  restaurantService.findById(restaurantId).get();
		table.setRestaurant(restaurant);
		return tableService.save(table);
	}
	
	@PutMapping("/{tableid}")
	public ResTable update(@RequestBody ResTable table) {
		
		return tableService.save(table);
	}
}
