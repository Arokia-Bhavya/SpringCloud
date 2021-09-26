package com.abc.bank.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {
	private String accountId;
	private String accountName;
	private AccountType accountType;
	private BigDecimal accountBlance;

}
