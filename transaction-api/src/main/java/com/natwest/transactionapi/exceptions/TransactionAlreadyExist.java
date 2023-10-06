package com.natwest.transactionapi.exceptions;

public class TransactionAlreadyExist extends Exception {
	
	public TransactionAlreadyExist(String mes) {
		super(mes);
	}
	
	public TransactionAlreadyExist() {}

}
