package com.abc.bank.service;

import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bank.config.Configuration;
import com.abc.bank.model.Account;
import com.abc.bank.model.AccountType;

@Service
public class AccountService {
	@Autowired
	private Configuration configuration;
	private Map<String, Account> accountCache= new HashMap<>();
	
	
	@PostConstruct
	public void setupTestData() {
		
		Account account1 = new Account("A12345", "Joe Bloggs", AccountType.CURRENT_ACCOUNT, BigDecimal.valueOf(1250.38));
		Account account2 = new Account("A67890", "Jane Doe", AccountType.SAVINGS_ACCOUNT, BigDecimal.valueOf(1550.40));
		
		accountCache.put(account1.getAccountId(), account1);
		accountCache.put(account2.getAccountId(), account2);
	}
	
	public void createAccount(Account account)
	{
		if(account.getAccountBalance().doubleValue() >= configuration.getMinBalance() && 
				   account.getAccountBalance().doubleValue() <= configuration.getMaxBalance()) {
					
					accountCache.put(account.getAccountId(), account);
				}
				else {
					
					throw new InvalidAccountBalanceException("Bank Account Balance is outside of allowed thresholds");
				}
	}
	
	public Account retrieveAccount(String accountId)
	{
		return accountCache.get(accountId);
	}

}
