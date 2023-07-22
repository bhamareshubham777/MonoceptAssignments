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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 
	 public List<Customer> getCustomer(){
		 connect();
		 List<Customer> customers = new ArrayList<Customer>();
		 Customer customer = new Customer();
		 try {
			 String query = "SELECT * FROM customer";
			 prepStatement = connection.prepareStatement(query);
			 resultSet=prepStatement.executeQuery();
			 if(resultSet.next()) {
				 customer.setCustomerId(resultSet.getInt("customer_id"));
				 customer.setFirstName(resultSet.getString("firstname"));
				 customer.setLastName(resultSet.getString("lastname"));
				 customer.setPassword(resultSet.getString("password"));
				 
				 customers.add(customer);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers; 
	 }

	 public List<Admin> getAdmin(){
		 connect();
		 List<Admin> admins = new ArrayList<Admin>();
		 Admin admin = new Admin();
		 try {
			 String query = "SELECT * FROM admin";
			 prepStatement = connection.prepareStatement(query);
			 resultSet=prepStatement.executeQuery();
			 if(resultSet.next()) {
				admin.setAdminId(resultSet.getInt("admin_id"));
				admin.setFirstName(resultSet.getString("firstname"));
				admin.setLastName(resultSet.getString("lastname"));
				admin.setPassword(resultSet.getString("password"));
				
				admins.add(admin);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins; 
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

	public void addNewTransaction(String transactionType, String senderAccountNumber, double amount, LocalDate date, String recieverAccountNumber) {
		connect(); 
		try {
	        	
	            connection.setAutoCommit(false); 

	           
	            String sql = "INSERT INTO transaction (transaction_type, date, amount, account_no, reciever_acct_no) " +
	                         "VALUES (?, ?, ?, ?, ?)";
	            prepStatement = connection.prepareStatement(sql);
	            prepStatement.setString(1, transactionType);
	            prepStatement.setObject(2, date);
	            prepStatement.setDouble(3, amount);
	            prepStatement.setInt(4, Integer.parseInt(senderAccountNumber));
	            prepStatement.setInt(5, Integer.parseInt(recieverAccountNumber)); 

	            prepStatement.executeUpdate();

	            
	            if (transactionType.equals("credit")) {
	                sql = "UPDATE account SET balance = balance + ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, Integer.parseInt(senderAccountNumber));
	            } else if (transactionType.equals("debit")) {
	                sql = "UPDATE account SET balance = balance - ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, Integer.parseInt(senderAccountNumber));
	            } else if (transactionType.equals("transfer")) {
	                

	                sql = "UPDATE account SET balance = balance - ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, Integer.parseInt(senderAccountNumber));
	                prepStatement.executeUpdate();

	                sql = "UPDATE account SET balance = balance + ? WHERE account_no = ?";
	                prepStatement = connection.prepareStatement(sql);
	                prepStatement.setDouble(1, amount);
	                prepStatement.setInt(2, Integer.parseInt(recieverAccountNumber));
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
	
	/////////////////////////////////////////////////////////////////////////

	public void generateAccountById(String customerId, double balance, HttpServletRequest request, HttpServletResponse response) {
		connect();
		try {
            

            // Retrieve customer details
            String selectQuery = "SELECT * FROM customer WHERE customer_id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
            selectStatement.setString(1, customerId);
            ResultSet resultSet = selectStatement.executeQuery();

            // Check if customer exists
            if (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                
                request.setAttribute("customerId", "customerId");
                request.setAttribute("firstName", "firstName");
                request.setAttribute("lastName", "lastName");
                request.setAttribute("password", "password");
                
                //request.getRequestDispatcher("ViewCustomerById.jsp").forward(request, response); 
                // Generate account
                String insertQuery = "INSERT INTO account (balance, customer_id) VALUES (?, ?)";
                prepStatement = connection.prepareStatement(insertQuery);
                prepStatement.setDouble(1, balance);
                prepStatement.setString(2, customerId);
                prepStatement.executeUpdate();
                
              
                
            } else {
               
            	request.setAttribute("errorMessage3", "Customer Not Found!!!");
            	request.getRequestDispatcher("GenerateAccount.jsp").forward(request, response); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
	}

	//////////View Customers//////////////////////////////////////
	public List<Customer> viewCustomers() {
		connect();
		List<Customer> customers = new ArrayList<>();

        try {
            
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customer");

            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_Id");
                String firstName = resultSet.getString("firstname");
                String lastName = resultSet.getString("lastname");
                String password = resultSet.getString("password");

                List<Account> accounts = fetchAccountsForCustomer(customerId); // Fetch accounts for the customer

                Customer customer = new Customer(customerId, firstName, lastName, password, accounts);
//                customer.setCustomerId(customerId);
//                customer.setFirstName(firstName);
//                customer.setLastName(lastName);
//                customer.setPassword(password);
//
//                List<Account> accounts = fetchAccountsForCustomer(customerId); // Fetch accounts for the customer
//                customer.setAccounts(accounts);

                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    private List<Account> fetchAccountsForCustomer(int customerId) {
    	connect();
        List<Account> accounts = new ArrayList<>();

        try {
            
            statement = connection.createStatement();
            String query = "SELECT * FROM account WHERE customer_id="+customerId;
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int accountNumber = resultSet.getInt("account_no");
                double balance = resultSet.getDouble("balance");

                Account account = new Account();
                account.setAccountNumber(accountNumber);
                account.setBalance(balance);
                account.setCustomerId(customerId);

                accounts.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return accounts;
    }
//////////////////////////////View Transactions/////////////////////////////////////////
	public List<Transaction> getAllTransactions() {
		connect();
		  List<Transaction> transactions = new ArrayList<>();

	        try {
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery("SELECT * FROM transaction");

	            while (resultSet.next()) {
	                Transaction transaction = new Transaction();
	                transaction.setTransactionId(resultSet.getInt("transaction_Id"));
	                transaction.setTransactionType(resultSet.getString("transaction_Type"));
	                transaction.setDate(resultSet.getDate("date"));
	                transaction.setAmount(resultSet.getDouble("amount"));
	                transaction.setSenderAccountNumber(Integer.parseInt(resultSet.getString("account_no")));
	                transaction.setRecieverAccountNumber(Integer.parseInt(resultSet.getString("reciever_acct_no")));

	                transactions.add(transaction);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return transactions;
	 }
///////////////////////View Passbook///////////////////////////////////////
	public int getIdForPassbook(String firstName) {
		 connect();
		 int id=0;
         try {
        	 prepStatement = connection.prepareStatement("SELECT * FROM customer WHERE firstname = ?");
        	 prepStatement.setString(1, firstName);
			resultSet = prepStatement.executeQuery();
			id=resultSet.getInt("customer_id");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}

	public List<Transaction> getTransactionsByUserId(int customerId) {
		connect();
		  List<Transaction> transactions = new ArrayList<>();

	        try {
	            prepStatement = connection.prepareStatement("SELECT * FROM transaction WHERE account_no IN(SELECT account_no FROM account GROUP BY account_no WHERE customer_id = ?");
	            prepStatement.setInt(1, customerId);
	            resultSet = prepStatement.executeQuery();
	            
	            while (resultSet.next()) {
	                Transaction transaction = new Transaction();
	                transaction.setTransactionId(resultSet.getInt("transaction_Id"));
	                transaction.setTransactionType(resultSet.getString("transaction_Type"));
	                transaction.setDate(resultSet.getDate("date"));
	                transaction.setAmount(resultSet.getDouble("amount"));
	                transaction.setSenderAccountNumber(Integer.parseInt(resultSet.getString("account_no")));
	                transaction.setRecieverAccountNumber(Integer.parseInt(resultSet.getString("reciever_acct_no")));

	                transactions.add(transaction);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return transactions;
    }
}
    
//////////////////////////////////////////////////////////////////////////////////////

