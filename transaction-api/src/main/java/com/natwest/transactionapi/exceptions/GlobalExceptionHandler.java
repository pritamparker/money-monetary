package com.natwest.transactionapi.exceptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@Value(value = "${exception.transactionAlreadyExist}")
	private String transactionexists;
	
	@Value(value = "${exception.accountNoDoesNotExist}")
	private String accountdoesnotexist;
	
	@ExceptionHandler(value=TransactionAlreadyExist.class)
	public ResponseEntity<?> transactionAlreadyExist() {
		return new ResponseEntity<String>(transactionexists,HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value=NoTransactionWithAccountNumber.class)
	public ResponseEntity<?> accountDoesNotExist() {
		return new ResponseEntity<String>(accountdoesnotexist,HttpStatus.NOT_FOUND);
	}

}
