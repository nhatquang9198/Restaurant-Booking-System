package com.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.ResTable;
import com.service.ResTableService;

@RestController
@RequestMapping("/api/restaurants/{restaurantId}/tables")
public class ResTableResource {
	@Autowired
	private ResTableService tableService;

	// Create
	@PostMapping
	public ResTable save(@PathVariable("restaurantId") Long restaurantId, @RequestBody ResTable table) {
		return tableService.save(restaurantId, table);
	}

	// Read all tables of a specific restaurant
	@GetMapping
	public List<ResTable> findAll(@PathVariable("restaurantId") Long restaurantId) {
		return tableService.findTablesByRestaurantId(restaurantId);
	}

	// Read detail of a specific table
	@GetMapping("/{tableId}")
	public ResTable findById(@PathVariable("tableId") Long tableId) {
		return tableService.findTableById(tableId);
	}

	// Read all tables that are available
	@GetMapping("/emptytables")
	public List<ResTable> findEmptyTables(@PathVariable("restaurantId") Long restaurantId) {
		return tableService.findEmptyTables(restaurantId);
	}

	// Update
	@PutMapping("/{tableId}")
	public ResTable update(@PathVariable("tableId") Long tableId, @RequestBody ResTable table) {
		return tableService.update(tableId, table);
	}

	// Delete by table id
	@DeleteMapping("/{tableId}")
	public void deleteById(@PathVariable("tableId") Long tableId) {
		tableService.deleteById(tableId);
	}

}
