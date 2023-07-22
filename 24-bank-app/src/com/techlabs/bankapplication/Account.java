package com.techlabs.bankapplication;

public class Account {

	private int accountNumber;
	private double balance;
	private int customerId;
	
	public Account() {

	}
	
	public Account(int accountNumber, double balance, int customerId) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customerId = customerId;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}
