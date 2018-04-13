package com.bancolombia.repository;

import java.util.List;

import com.bancolombia.model.Account;

public interface AccountRepository {

	List<Account> findAll();

}