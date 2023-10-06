package com.natwest.transactionapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.natwest.transactionapi.exceptions.NoTransactionWithAccountNumber;
import com.natwest.transactionapi.exceptions.TransactionAlreadyExist;
import com.natwest.transactionapi.model.Transaction;
import com.natwest.transactionapi.service.TransactionService;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/addtransaction")
	public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction)  {
		try {
			return new ResponseEntity<Transaction>(transactionService.addTransaction(transaction), HttpStatus.CREATED);
		} catch (TransactionAlreadyExist e) {
			
			return new ResponseEntity<String>("Sorry, transaction already exists", HttpStatus.CONFLICT);
		}
	}
	
	@GetMapping("/get/{accountno}/{type}")
	public ResponseEntity<?> getTransactionByAccountAndType(@PathVariable int accountno, @PathVariable String type) {
		return new ResponseEntity<List<Transaction>>(transactionService.findByAccountnoAndTransactionType(accountno, type),HttpStatus.OK);
	}
	
	@GetMapping("/get/accountno/{accountno}")
	public ResponseEntity<?> findByAccountno(@PathVariable int accountno) throws NoTransactionWithAccountNumber {
		return new ResponseEntity<List<Transaction>>(transactionService.findByAccountno(accountno),HttpStatus.OK);
	}
}
