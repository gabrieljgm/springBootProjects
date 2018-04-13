package com.bancolombia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bancolombia.model.Account;
import com.bancolombia.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired	
	private AccountRepository accountRepository;
	
	@Override
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
}
