package com.service;

import java.util.ArrayList;
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

	public ResTable save(Long restaurantId, ResTable table) {
		Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
		table.setRestaurant(restaurant);

		return tableRepository.save(table);
	}

	public List<ResTable> findTablesByRestaurantId(Long restaurantId) {
		return restaurantRepository.findById(restaurantId).get().getTables();
	}

	public List<ResTable> findEmptyTables(Long restaurantId) {
		List<ResTable> tables = new ArrayList<ResTable>();
		restaurantRepository.findById(restaurantId).get().getTables().forEach(t -> {
			if (t.isAvailable()) {
				tables.add(t);
			}
		});
		return tables;
	}

	public ResTable findTableById(Long tableId) {
		return tableRepository.findById(tableId).get();
	}

	public ResTable update(Long tableId, ResTable table) {
		ResTable resTable = tableRepository.findById(tableId).get();
		resTable.setAvailable(table.isAvailable());

		return tableRepository.save(resTable);
	}

	public void deleteById(Long id) {
		tableRepository.deleteById(id);
	}
}
