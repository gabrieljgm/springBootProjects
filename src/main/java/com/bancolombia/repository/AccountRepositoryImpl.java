package com.bancolombia.repository;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.bancolombia.model.Account;
import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;

@Repository()
public class AccountRepositoryImpl implements AccountRepository {
	
	private static CloudantClient client;
	private static Database db = null; 
	
	
	String account="replace your cloudant account";
	String username = "replace your cloudant user ";
	String password = "replica your password user";
	
	
	public AccountRepositoryImpl() {
		// Create a new CloudantClient instance for account endpoint example.cloudant.com
		//System.setProperty("java.net.useSystemProxies", "true");
		 try {
			client = ClientBuilder.url(new URL("https://" + username + ".cloudant.com"))
			//client = ClientBuilder.url(new URL("https://ggaleano.cloudant.com"))
			        .username(username)
			        .password(password)
			        .build();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Server Version: " + client.serverVersion());
	}

	@Override
	public List<Account> findAll() {
		  db = client.database("accounts", false);
		 // db = client.database("prueba", false);
		
		  List<Account> accounts = null;
		try {
			accounts = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(Account.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				  
		
		return accounts;
	}
}
