package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.model.ResTable;
import com.model.Restaurant;

public interface ITableRepository extends PagingAndSortingRepository<ResTable, Long> {

	final String findEmptyTableQuery = "SELECT t FROM ResTable t LEFT JOIN Reservation r ON t.id = r.resTable WHERE t.restaurant = ?1 AND r.date = ?2 or r.date is null AND r.isApproved = false or r.isApproved is null";

	@Override
	public List<ResTable> findAll();
	
//	@Query("SELECT t FROM ResTable t LEFT JOIN Reservation r ON t.id = r.resTable WHERE t.restaurant = ?1 AND (r.date = ?2 OR r.date is null) AND (r.isApproved = false OR r.isApproved is null) GROUP BY t.id")
//	public List<ResTable> findEmptyTablesByRestaurantId(Restaurant restaurant, LocalDate date);
	
	@Query("SELECT t FROM ResTable t LEFT JOIN Reservation r ON t.id = r.resTable WHERE t.restaurant = ?1 AND (r.date = ?2 OR r.date is null) AND (r.isApproved = false OR r.isApproved is null) GROUP BY t.id")
	public List<ResTable> findEmptyTablesByRestaurantId(Restaurant restaurant, LocalDate date);
	
}
