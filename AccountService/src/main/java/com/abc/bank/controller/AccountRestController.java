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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.bank.model.Account;
import com.abc.bank.service.AccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("account")
public class AccountRestController {
	@Autowired
	AccountService accountService;

	@PostMapping("create")
	public ResponseEntity<Account> createBankAccount(@RequestBody Account account,HttpServletRequest request) throws URISyntaxException
	{
		accountService.createAccount(account);
		log.info("created bank account {}", account);		
		URI uri = new URI(request.getRequestURL() + "bank-account/" + account.getAccountId());		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getBankAccount(@PathVariable String accountId){
		
		Account account = accountService.retrieveAccount(accountId);		
		log.info("retrieved bank account {}", account);		
		return ResponseEntity.ok(account);				
	}
}
