package com.techlabs.assignments;

import java.util.Scanner;

public class AccountTest {

	static Scanner scanner=new Scanner(System.in);
	static Account accounts[];
	
	public static void main(String[] args) {
		System.out.println("Enter Number Of Accounts:");
		int noOfAccounts=scanner.nextInt();
		
		accounts=new Account[noOfAccounts];
		
		acceptAccountDetails();
		displayAccountDetails();
		displayMaxiumumBalanceAccount();
	}

	private static void acceptAccountDetails() {
		System.out.println("Enter Account Details: ");
		
		for(int i=0 ; i<accounts.length ; i++) {
			System.out.println("Enter Account Number:");
			int accountNumber=scanner.nextInt();
			
			System.out.println("Enter Account Holder Name:");
			String accountHolderName=scanner.next();
			
			System.out.println("Enter Account Type (SAVING/CURRENT/JOINT):");
			String accountType=scanner.next();
			
			System.out.println("Enter Account Balance:");
			double accountBalance=scanner.nextDouble();
			
			accounts[i]=new Account(accountNumber,accountHolderName,AccountType.valueOf(accountType),accountBalance);
		}
		
	}
	
	private static void displayAccountDetails() {
		System.out.println("-----------------------------Account Details------------------------------");
		System.out.println("AccountNumber \t\t Name \t\t AccountType \t\t AccountBalance");
		System.out.println("==========================================================================");
		for(Account account : accounts)
			System.out.println(account);
		
	}
	
	private static void displayMaxiumumBalanceAccount() {
		Account maximumBalanceAccount=findMaxiumumBalanceAccount();
		
		System.out.println();
		System.out.println();
		System.out.println("-----------------------------Account Details With Maximum Balance---------------");
		System.out.println("AccountNumber \t\t Name \t\t AccountType \t\t AccountBalance");
		System.out.println("================================================================================");
		
		System.out.println(maximumBalanceAccount);
		
	}
	
	private static Account findMaxiumumBalanceAccount() {
		Account accountWithMaximumBalance=accounts[0];
		
		for(int i=0 ; i<accounts.length ; i++)
			if(accounts[i].getAccountBalance()>accountWithMaximumBalance.getAccountBalance())
				accountWithMaximumBalance=accounts[i];
		return accountWithMaximumBalance;
		
	}

}
