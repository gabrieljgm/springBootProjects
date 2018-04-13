package com.bancolombia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bancolombia.model.Account;
import com.bancolombia.service.AccountService;

@RestController 
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/accounts")
	public List<Account> accounts (){
		return accountService.findAll();
		
	}
}