package com.techlabs.one.customerassignment2;

import java.util.Scanner;

public class TestCustomer {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter Customer ID:");
		int id=scanner.nextInt();
		
		System.out.println("Enter Customer Name:");
		String name=scanner.next();
		
		System.out.println("Enter Customer Email:");
		String email=scanner.next();
		
		System.out.println("Enter Customer Password:");
		String password=scanner.next();
		
		Customer customer=new Customer();
		
		customer.setCustomerID(id);
		customer.setCustomerName(name);
		customer.setCustomerEmail(email);
		customer.setCustomerPassword(password);
		
		int customerID=customer.getCustomerID();
		String customerName=customer.getCustomerName();
		String customerEmail=customer.getCustomerEmail();
		String customerPassword=customer.getCustomerPassword();
		
		System.out.println();
		System.out.println();
		System.out.println("------------------------:Customer Details:------------------------");
		System.out.println();
		System.out.println("ID \t\t NAME \t\t EMAIL \t\t\t PASSWORD");
		System.out.println("==================================================================");
		System.out.println(customerID+"\t\t"+customerName+"\t\t"+customerEmail+"\t"+customerPassword);

	}

}

