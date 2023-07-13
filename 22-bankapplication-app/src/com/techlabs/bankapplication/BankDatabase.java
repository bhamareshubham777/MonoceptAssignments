package com.techlabs.bankapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankDatabase {

	 private static BankDatabase bankDatabase;
	 private  Connection connection;
	 private  Statement statement;
	 private PreparedStatement prepStatement;
	 private ResultSet resultSet;
	    
	 private BankDatabase() {
	        
	 }

	 public static BankDatabase getInstance() {
	     if (bankDatabase == null) {
	         bankDatabase = new BankDatabase();
	     }
	     return bankDatabase;
	 }

	 public Connection connect() {
	     try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_db", "root", "shubh143");
	     } catch (Exception e) {
	         e.printStackTrace();
	     }
	     return connection;
	 }
	 
	 //loginController
	 public boolean authenticateUser(String loginType, String firstName, String lastName, String password) {
		 	connect();
	        try {
	            String query = "";
	            if (loginType.equals("admin")) {
	                query = "SELECT * FROM admin WHERE firstname = ? AND lastname = ? AND password = ?";
	            } else if (loginType.equals("customer")) {
	                query = "SELECT * FROM customer WHERE firstname = ? AND lastname = ? AND password = ?";
	            }
	            prepStatement = connection.prepareStatement(query);
	            prepStatement.setString(1, firstName);
	            prepStatement.setString(2, lastName);
	            prepStatement.setString(3, password);

	            resultSet = prepStatement.executeQuery();

	            boolean authenticated = resultSet.next();

	            return authenticated;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	public void addCustomer(String firstName, String lastName, String password) {
		connect();
        try {
           
            String sql = "INSERT INTO customer (firstname, lastname, password) VALUES (?, ?, ?)";
            prepStatement = connection.prepareStatement(sql);
            prepStatement.setString(1, firstName);
            prepStatement.setString(2, lastName);
            prepStatement.setString(3, password);

            prepStatement.executeUpdate();

            
        } catch (SQLException e) {
            e.printStackTrace();
        } 

		
	}

	public void addNewTransaction(String transactionType, int accountNumber, double amount, LocalDate date, int recieverAccountNumber) {
		connect(); 
		try {
	        	
	            connection.setAutoCommit(false); 

	           
	            String sql = "INSERT INTO transaction (transaction_type, date, amount, account_no, reciever_acct_no) " +
	                         "VALUES (?, ?, ?, ?, ?)";
	            prepStatement = connection.prepareStatement(sql);
	            prepStatement.setString(1, transactionType);
	            prepStatement.setObject(2, date);
	            prepStatement.setDouble(3, amount);
	            prepStatement.setInt(4, accountNumber);
	            prepStatement.setInt(5, accountNumber); 

	            prepStatement.executeUpdate();

	            
	            if (transactionType.equals("credit")) {
	                sql = "UPDATE account SET balance = balance + ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, accountNumber);
	            } else if (transactionType.equals("debit")) {
	                sql = "UPDATE account SET balance = balance - ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, accountNumber);
	            } else if (transactionType.equals("transfer")) {
	                

	                sql = "UPDATE account SET balance = balance - ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, accountNumber);
	                prepStatement.executeUpdate();

	                sql = "UPDATE account SET balance = balance + ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, recieverAccountNumber);
	            }

	            prepStatement.executeUpdate();

	            connection.commit(); 
	            connection.setAutoCommit(true); 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

		
	}

	public void updateProfile(String firstName, String lastName, String password, int customerId) {
		connect();
		
		try {
            
            String sql = "UPDATE customer SET firstname = ?, lastname = ?, password = ? WHERE customer_id = ?";
            prepStatement = connection.prepareStatement(sql);
            prepStatement.setString(1, firstName);
            prepStatement.setString(2, lastName);
            prepStatement.setString(3, password);
            prepStatement.setInt(4, customerId);

            prepStatement.executeUpdate();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
