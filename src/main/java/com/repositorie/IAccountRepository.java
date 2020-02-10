package com.repositorie;

import org.springframework.data.repository.CrudRepository;

import com.model.Account;

public interface IAccountRepository extends CrudRepository<Account, Long>{

}
