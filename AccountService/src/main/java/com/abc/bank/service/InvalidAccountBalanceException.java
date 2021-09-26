package com.abc.bank.service;

public class InvalidAccountBalanceException extends RuntimeException {

	String msg;

	public InvalidAccountBalanceException(String msg) {
		super();
		this.msg = msg;
	}
}
