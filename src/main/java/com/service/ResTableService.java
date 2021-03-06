package com.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IRestaurantRepository;
import com.dao.ITableRepository;
import com.model.ResTable;
import com.model.Restaurant;

@Service
public class ResTableService {
	@Autowired
	private ITableRepository tableRepository;
	@Autowired
	private IRestaurantRepository restaurantRepository;

	public ResTable create(Long restaurantId, ResTable table) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
		table.setRestaurant(restaurant);

		return tableRepository.save(table);
	}

	public List<ResTable> findAll() {
		return tableRepository.findAll();
	}

	public ResTable findById(Long id) {
		return tableRepository.findById(id).get();
	}

	public ResTable update(Long tableId, ResTable table) {
		ResTable resTable = tableRepository.findById(tableId).get();
		resTable.setSeats(table.getSeats());

		return tableRepository.save(resTable);
	}

	public void deleteById(Long id) {
		tableRepository.deleteById(id);
	}

	public List<ResTable> findTablesByRestaurantId(Long restaurantId) {
		return restaurantRepository.findById(restaurantId).get().getTables();
	}

	public List<ResTable> findEmptyTablesByRestaurantId(Long restaurantId, String date, int people) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
		LocalDate reserve_date = LocalDate.parse(date);
		reserve_date = reserve_date.plusDays(1);

		return tableRepository.findEmptyTablesByRestaurantId(restaurant, reserve_date, people);
	}

}
