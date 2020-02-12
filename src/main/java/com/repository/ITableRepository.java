package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.ResTable;

public interface ITableRepository extends CrudRepository<ResTable, Long>{
	
	List<ResTable> findAll();
}
