package com.natwest.transactionapi.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.natwest.transactionapi.exceptions.NoTransactionWithAccountNumber;
import com.natwest.transactionapi.exceptions.TransactionAlreadyExist;
import com.natwest.transactionapi.model.Transaction;
import com.natwest.transactionapi.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	private TransactionRepository transactionRepository;
	
	public TransactionRepository getTransactionRepository() {
		return transactionRepository;
	}
	
	@Autowired
	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	@Override
	public Transaction addTransaction(Transaction transaction) throws TransactionAlreadyExist {
		Optional<Transaction> tr = transactionRepository.findById(transaction.getTransactionId());
		if(tr.isPresent()) {
			throw new TransactionAlreadyExist();
		}
		transaction.setTransationTimestamp(LocalDateTime.now());
		return transactionRepository.save(transaction);
	}

	@Override
	public List<Transaction> findByAccountno(int accountno) throws NoTransactionWithAccountNumber {
		List<Transaction> transactions = transactionRepository.findByAccountno(accountno);
		
		if(transactions.size()==0) {
			throw new NoTransactionWithAccountNumber();
		}
		return transactions;
	}

	@Override
	public List<Transaction> findByAccountnoAndTransactionType(int accountno, String type) {
		// TODO Auto-generated method stub
		return transactionRepository.findByAccountnoAndTransactionType(accountno, type);
	}

	@Override
	public Transaction getById(int transactionId) {
		// TODO Auto-generated method stub
		return transactionRepository.findById(transactionId).get();
	}

	@Override
	public List<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return (List<Transaction>) transactionRepository.findAll();
	}

}
