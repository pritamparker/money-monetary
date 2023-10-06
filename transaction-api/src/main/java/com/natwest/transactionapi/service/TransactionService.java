package com.natwest.transactionapi.service;

import java.util.List;

import com.natwest.transactionapi.exceptions.NoTransactionWithAccountNumber;
import com.natwest.transactionapi.exceptions.TransactionAlreadyExist;
import com.natwest.transactionapi.model.Transaction;

public interface TransactionService {
	
	public Transaction addTransaction(Transaction transaction) throws TransactionAlreadyExist;
	public List<Transaction> findByAccountno(int accountno) throws NoTransactionWithAccountNumber;
	
	//select * from transaction where accountno=? and transactionType=?
	public List<Transaction> findByAccountnoAndTransactionType(int accountno, String type);
	public Transaction getById(int transactionId);
	public List<Transaction> getAllTransactions();
	
}
