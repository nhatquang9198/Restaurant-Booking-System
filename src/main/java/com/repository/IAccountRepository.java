package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.model.Account;

public interface IAccountRepository extends CrudRepository<Account, Long>{

	List<Account> findAll();
}
