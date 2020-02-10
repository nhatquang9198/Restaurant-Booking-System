package com.repositorie;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface IGenericRepository<T> extends CrudRepository<T, Long> {
	
	@Override
	List<T> findAll();
}
