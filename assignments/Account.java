package com.techlabs.assignments;

public class Account {
	private int accountNumber;
	private String accountHolderName;
	private AccountType accountType;
	private double accountBalance;
	
	public Account() {
		
	}

	public Account(int accountNumber, String accountHolderName, AccountType accountType, double accountBalance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	

	@Override
	public String toString() {
		return accountNumber+"\t\t\t"+accountHolderName+"\t\t\t"+accountType+"\t\t\t"+accountBalance;
	}
	
}
