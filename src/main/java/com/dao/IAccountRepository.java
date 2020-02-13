package com.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Account;

public interface IAccountRepository extends CrudRepository<Account, Long> {
	
	@Override
	List<Account> findAll();
}
