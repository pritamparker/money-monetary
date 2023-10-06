package com.natwest.transactionapi.model;

import java.time.LocalDateTime;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transactions")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.AUTO)
	private int transactionId;
	private String transactionType;
	private int accountno;
	private double amount;
	private LocalDateTime transationTimestamp;
	private String status; //pending, completed, declined
	private String particulars;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int transactionId, String transactionType, int accountno, double amount,
			LocalDateTime transationTimestamp, String status, String particulars) {
		super();
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.accountno = accountno;
		this.amount = amount;
		this.transationTimestamp = transationTimestamp;
		this.status = status;
		this.particulars = particulars;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDateTime getTransationTimestamp() {
		return transationTimestamp;
	}
	public void setTransationTimestamp(LocalDateTime transationTimestamp) {
		this.transationTimestamp = transationTimestamp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getParticulars() {
		return particulars;
	}
	public void setParticulars(String particulars) {
		this.particulars = particulars;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionType=" + transactionType + ", accountno="
				+ accountno + ", amount=" + amount + ", transationTimestamp=" + transationTimestamp + ", status="
				+ status + ", particulars=" + particulars + "]";
	}
	
	
}
