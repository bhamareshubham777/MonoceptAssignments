package com.techlabs.bankapplication;

public class Admin {

	private int adminId;
	private String firstName;
	private String lastName;
	private String password;
	
	public Admin() {
		
	}
	
	public Admin(int adminId, String firstName, String lastName, String password) {
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	
	public boolean validate() {
		boolean status = false;
		
		if(password.length()>=7) 
			status = true;
		
		return status;
	}
}
