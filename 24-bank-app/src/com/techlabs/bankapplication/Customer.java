package com.techlabs.bankapplication;

import java.util.List;

public class Customer {

	private int customerId;
	private String firstName;
	private String lastName;
	private String password;
	private List<Account> accounts;
	
	public Customer() {
		
	}
	
	public Customer(int customerId, String firstName, String lastName, String password, List<Account> accounts) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.accounts=accounts;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
}
