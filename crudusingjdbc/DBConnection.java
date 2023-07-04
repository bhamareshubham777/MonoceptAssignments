package crudusingjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	 private static DBConnection dbConnection;
	    private  Connection connection;
	    private  Statement statement;
	    
	    private DBConnection() {
	        
	    }

	    public static DBConnection getInstance() {
	        if (dbConnection == null) {
	            dbConnection = new DBConnection();
	        }
	        return dbConnection;
	    }

	    public Connection connect() {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "shubh143");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    
	    public Statement createStetementInstance() throws SQLException {
	    	if(statement==null) {
	    		statement = connection.createStatement();
	    	}
	    	return statement;
	    }
	    
	    public void createCompanyDb() {
	        try {
	            statement = createStetementInstance();
	            statement.executeUpdate("CREATE DATABASE company");
	            System.out.println("Database created successfully!!!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void createDepartmentTable() {
	        try {
	            statement = createStetementInstance();
	            statement.executeUpdate("CREATE TABLE department (DEPTNO INT PRIMARY KEY, DNAME VARCHAR(100), LOC VARCHAR(100))");
	            System.out.println("Table created successfully!!!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public void createEmployeeTable() {
	        try {
	            statement = createStetementInstance();
	            statement.executeUpdate("CREATE TABLE employee (EMPNO INT PRIMARY KEY, ENAME VARCHAR(100), JOB VARCHAR(100), MANAGER INT, HIREDATE DATE, SAL DOUBLE, COMM DOUBLE, DEPTNO INT)");
	            System.out.println("Table created successfully!!!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
}
