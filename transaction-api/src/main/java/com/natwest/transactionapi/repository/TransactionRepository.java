package com.natwest.transactionapi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.natwest.transactionapi.model.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
	
	public List<Transaction> findByAccountno(int accountno);
	public List<Transaction> findByAccountnoAndTransactionType(int accountno, String type);

}
