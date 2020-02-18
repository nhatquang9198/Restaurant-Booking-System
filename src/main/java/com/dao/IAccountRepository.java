package com.dao;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.model.Account;

public interface IAccountRepository extends PagingAndSortingRepository<Account, Long> {
	
	@Override
	public List<Account> findAll();
}
