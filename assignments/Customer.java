package com.techlabs.assignments;

public class Customer {
	private int customerID;
	private String customerName;
	private String customerEmail;
	private String customerPassword;
	
	public Customer() {
		
	}
	
	public Customer(int customerID, String customerName, String customerEmail, String customerPassword) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail=customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	@Override
	public String toString() {
		return customerID+"\t\t"+customerName+"\t\t"+customerEmail+"\t\t"+customerPassword;
	}
	
}
