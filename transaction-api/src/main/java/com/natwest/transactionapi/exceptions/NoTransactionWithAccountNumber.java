package com.natwest.transactionapi.exceptions;

public class NoTransactionWithAccountNumber extends Exception{

	public NoTransactionWithAccountNumber(String mes) {
		super(mes);
	}
	
	public NoTransactionWithAccountNumber() {}
}
