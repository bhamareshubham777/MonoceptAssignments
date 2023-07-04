package crudusingjdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseOperations {

	private DBConnection dbConnection;
	private PreparedStatement prepStatement;
	private Statement statement;
	private ResultSet resultSet;
    
    public DatabaseOperations() {
        dbConnection = DBConnection.getInstance();
    }
    
    public void insertDepartment(int deptNo, String deptName, String location) {
        try {
        	String query="INSERT INTO department (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)";
            prepStatement = dbConnection.connect().prepareStatement(query);
            prepStatement.setInt(1, deptNo);
            prepStatement.setString(2, deptName);
            prepStatement.setString(3, location);
            int result=prepStatement.executeUpdate();
            System.out.println(result+" RECORD INSERTED SUCCESSFULLY!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertEmployee(int empNo, String empName, String job, int manager, Date hireDate, double salary, double commission, int deptNo) {
        try {
        	String query="INSERT INTO employee (EMPNO, ENAME, JOB, MANAGER, HIREDATE, SAL, COMM, DEPTNO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            prepStatement = dbConnection.connect().prepareStatement(query);
            prepStatement.setInt(1, empNo);
            prepStatement.setString(2, empName);
            prepStatement.setString(3, job);
            prepStatement.setInt(4, manager);
            prepStatement.setDate(5, hireDate);
            prepStatement.setDouble(6, salary);
            prepStatement.setDouble(7, commission);
            prepStatement.setInt(8, deptNo);
            int result=prepStatement.executeUpdate();
            System.out.println(result+" RECORD INSERTED SUCCESSFULLY!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void displayEmployeesByDepartment(String departmentName) {
        try {
        	String query="SELECT * FROM employee e INNER JOIN department d ON e.DEPTNO = d.DEPTNO WHERE d.DNAME = ?";
            prepStatement = dbConnection.connect().prepareStatement(query);
            prepStatement.setString(1, departmentName);
            resultSet = prepStatement.executeQuery();
            
            while (resultSet.next()) {
                int empNo = resultSet.getInt("EMPNO");
                String empName = resultSet.getString("ENAME");
                String job = resultSet.getString("JOB");
                int manager = resultSet.getInt("MANAGER");
                Date hireDate = resultSet.getDate("HIREDATE");
                double salary = resultSet.getDouble("SAL");
                Double commission = resultSet.getDouble("COMM");
                int deptNo = resultSet.getInt("DEPTNO");
                
                System.out.println("Employee No: " + empNo);
                System.out.println("Employee Name: " + empName);
                System.out.println("Job: " + job);
                System.out.println("Manager: " + manager);
                System.out.println("Hire Date: " + hireDate);
                System.out.println("Salary: " + salary);
                System.out.println("Commission: " + commission);
                System.out.println("Department No: " + deptNo);
                System.out.println("------------------------");
            }
            
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateEmployeeCommission(double commissionPercentage) {
        try {
        	String query="UPDATE employee SET COMM = COMM + (COMM * " + commissionPercentage + "/100)";
            prepStatement = dbConnection.connect().prepareStatement(query);
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void insertNewEmployeeInHR() {
    
        insertEmployee(2222, "KING", "Manager", 7902, new Date(System.currentTimeMillis()), 5000, 0, 40);
    }
    
    public void deleteEmployeesWithSalaryLessThan(double salaryThreshold) {
        try {
        	String query="DELETE FROM employee WHERE SAL < ?";
            prepStatement = dbConnection.connect().prepareStatement(query);
            prepStatement.setDouble(1, salaryThreshold);
            int result=prepStatement.executeUpdate();
            System.out.println(result+" RECORD DELETED SUCCESSFULLY!!!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void displayAllEmployees() {
        try {
            statement = dbConnection.createStetementInstance();
            resultSet = statement.executeQuery("SELECT * FROM employee");
            
            while (resultSet.next()) {
                int empNo = resultSet.getInt("EMPNO");
                String empName = resultSet.getString("ENAME");
                String job = resultSet.getString("JOB");
                int manager = resultSet.getInt("MANAGER");
                Date hireDate = resultSet.getDate("HIREDATE");
                float salary = resultSet.getFloat("SAL");
                float commission = resultSet.getFloat("COMM");
                int deptNo = resultSet.getInt("DEPTNO");
                
                System.out.println("Employee No: " + empNo);
                System.out.println("Employee Name: " + empName);
                System.out.println("Job: " + job);
                System.out.println("Manager: " + manager);
                System.out.println("Hire Date: " + hireDate);
                System.out.println("Salary: " + salary);
                System.out.println("Commission: " + commission);
                System.out.println("Department No: " + deptNo);
                System.out.println("------------------------");
            }
            
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void displayAllDepartments() {
        try {
            statement = dbConnection.createStetementInstance();
            resultSet = statement.executeQuery("SELECT * FROM department");
            
            while (resultSet.next()) {
            	System.out.println("DEPTNO \t DNAME \t\t LOC");
                System.out.println(resultSet.getInt("DEPTNO")+"\t"+resultSet.getString("DNAME")+"\t"+resultSet.getString("LOC"));
              
                System.out.println("------------------------");
            }
            
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
