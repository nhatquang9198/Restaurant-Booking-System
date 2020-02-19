package com.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.model.ResTable;
import com.model.Restaurant;

public interface ITableRepository extends PagingAndSortingRepository<ResTable, Long> {

	@Override
	public List<ResTable> findAll();

	// This function use native query
//	@Query(value = "SELECT * FROM restaurant_tables WHERE restaurant_id = :restaurantId AND id NOT IN(SELECT t.id FROM restaurant_tables t JOIN reservations r ON t.id = r.table_id WHERE r.date = :date AND r.approved = true);", nativeQuery = true)
//	public List<ResTable> findEmptyTablesByRestaurantId(@Param("restaurantId") Long restaurantId,
//			@Param("date") LocalDate date);

	@Query("SELECT t FROM ResTable t WHERE t.restaurant = :restaurant AND t.id NOT IN (SELECT t.id FROM ResTable t JOIN Reservation r ON t.id = r.resTable WHERE r.date = :date AND r.isApproved = true)")
	public List<ResTable> findEmptyTablesByRestaurantId(@Param("restaurant") Restaurant restaurant,
			@Param("date") LocalDate date);

	// "SELECT t FROM ResTable t WHERE t.restaurant = :restaurant AND t.id
	// NOT IN (SELECT t.id FROM ResTable t JOIN Reservation r ON t.id = r.resTable
	// WHERE r.date = :date AND r.isApproved = true)"
}
