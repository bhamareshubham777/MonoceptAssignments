package com.techlabs.bankapplication;

import java.sql.Date;

public class Transaction {

	private int transactionId;
	private String transactionType;
	private Date date;
	private double amount;
	private int senderAccountNumber;
	private int recieverAccountNumber;
	private int customerId;
	
	public Transaction() {

	}
	
	public Transaction(int transactionId, String transactionType, Date date, double amount, int senderAccountNumber,
			int recieverAccountNumber, int customerId) {
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.date = date;
		this.amount=amount;
		this.senderAccountNumber = senderAccountNumber;
		this.recieverAccountNumber = recieverAccountNumber;
		this.customerId=customerId;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getSenderAccountNumber() {
		return senderAccountNumber;
	}
	public void setSenderAccountNumber(int senderAccountNumber) {
		this.senderAccountNumber = senderAccountNumber;
	}
	public int getRecieverAccountNumber() {
		return recieverAccountNumber;
	}
	public void setRecieverAccountNumber(int recieverAccountNumber) {
		this.recieverAccountNumber = recieverAccountNumber;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
