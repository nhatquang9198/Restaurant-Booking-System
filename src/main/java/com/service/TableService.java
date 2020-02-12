package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.ResTable;
import com.repository.ITableRepository;

@Service
public class TableService {
	@Autowired
	ITableRepository repository;

	public ResTable save(ResTable table) {
		return repository.save(table);
	}

	public List<ResTable> findAll() {
		return repository.findAll();
	}

	public List<ResTable> checkEmptyTable() {
		List<ResTable> tables = new ArrayList<ResTable>();
		repository.findAll().forEach(t -> {
			if (t.isAvailable()) {
				tables.add(t);
			}
		});
		return tables;
	}

	public Optional<ResTable> findById(Long id) {
		return repository.findById(id);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
}
