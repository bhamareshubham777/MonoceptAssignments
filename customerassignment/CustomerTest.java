package com.techlabs.assignments.customerassignment;

import java.util.Scanner;

public class CustomerTest {
	
	static Scanner scanner=new Scanner(System.in);
	static Customer customers[];
	
	public static void main(String[] args) {
		System.out.println("Enter Number Of Customers:");
		int size=scanner.nextInt();
		
		customers=new Customer[size];
		
		acceptCustomerDetails();
		displayCustomerDetails();
		
		sortCustomerByName();
		displayCustomerDetails();
	}

	private static void acceptCustomerDetails() {
		
		for(int i=0 ; i<customers.length ; i++) {
			System.out.println("Enter Customer ID:");
			int customerID=scanner.nextInt();
			
			System.out.println("Enter Customer Name:");
			String customerName=scanner.next();
			
			String customerEmail;
			while(true) {
				System.out.println("Enter Customer Email:");
				customerEmail=scanner.next();
				if(isValidEmail(customerEmail))
					break;
				System.out.println("Invalid Email...!!!");
			}
			
			System.out.println("Enter Customer Password:");
			String customerPassword=scanner.next();
			
			customers[i]=new Customer(customerID,customerName,customerEmail,customerPassword);
		}
	}
	
	
	private static boolean isValidEmail(String email) {
		String emailRegex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";

		if(email.matches(emailRegex))
			return true;
		return false;
	}

	private static void displayCustomerDetails() {
		System.out.println("~~~~~~~~~~~~~~~~~~$ Customer Details $~~~~~~~~~~~~~~~~~~~");
		System.out.println();
		System.out.println("ID \t\t Name \t\t Email \t\t\t\t Password");
		System.out.println("============================================================================");
		for(Customer customer : customers)
			System.out.println(customer);
		
	}
	
	private static void sortCustomerByName() {
		for(int i=0 ; i<customers.length-1 ; i++) {
			sortRows(i);
		}
	}
	
	private static void sortRows(int i) {
		for(int j=0 ; j<customers.length-i-1 ; j++) {
			bubbleSort(j);
		}
	}

	private static void bubbleSort(int j) {
		if(customers[j].getCustomerName().compareTo(customers[j+1].getCustomerName())>0) {
			Customer temp=customers[j];
			customers[j]=customers[j+1];
			customers[j+1]=temp;
		}
		
	}
}
