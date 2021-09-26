package com.abc.bank.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bank.model.Account;
import com.abc.bank.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class AccountController {
	
	@Autowired
	public AccountService accountService; 
	
	
	@PostMapping("/bank-account")
	public ResponseEntity<?> createAccount(@RequestBody Account Account, HttpServletRequest request) throws URISyntaxException {
		
		accountService.createAccount(Account);
		
		log.info("created bank account {}", Account);
		
		URI uri = new URI(request.getRequestURL() + "bank-account/" + Account.getAccountId());
		
		return ResponseEntity.created(uri).build();				
	}
	
	@GetMapping("/{account_id}")
	public ResponseEntity<Account> retrieveAccount(String accountId)
	{
		return ResponseEntity.ok(accountService.retrieveAccount(accountId));
		
	}

}
