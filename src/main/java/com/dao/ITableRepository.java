package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.ResTable;

public interface ITableRepository extends CrudRepository<ResTable, Long>{
	
	@Override
	List<ResTable> findAll();
}
