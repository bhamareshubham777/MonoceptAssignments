package com.techlabs.one.customerassignment2;

public class Customer {
	private int customerID;
	private String customerName;
	private String customerEmail;
	private String customerPassword;

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
		String emailRegex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";

		if(customerEmail.matches(emailRegex)) {
			this.customerEmail=customerEmail;
		}else {
			System.out.println();
			System.out.println();
			System.out.println("Invalid Email...!!!");
		}
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
}

