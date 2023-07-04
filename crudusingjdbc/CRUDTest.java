package crudusingjdbc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class CRUDTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DBConnection dbConnection=DBConnection.getInstance();
		dbConnection.connect();
		
//		dbConnection.createCompanyDb();
//		dbConnection.createDepartmentTable();
//		dbConnection.createEmployeeTable();
		
		DatabaseOperations operation=new DatabaseOperations();
        Scanner scanner = new Scanner(System.in);
        
        boolean exit = false;

        while (!exit) {
            System.out.println("Menu:");
            System.out.println("1. Insert Records into Department");
            System.out.println("2. Insert Records into Employee");
            System.out.println("3. Display all Employees in a particular Department");
            System.out.println("4. Update Records of Employees (Increase Commission by 20%)");
            System.out.println("5. Insert New Employee in the HR Department");
            System.out.println("6. Delete Employees having Salary Less than a given amount");
            System.out.println("7. Display All Employees");
            System.out.println("8. Display All Departments");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter department number: ");
                    int deptNo = scanner.nextInt();
                    System.out.print("Enter department name: ");
                    scanner.nextLine(); 
                    String deptName = scanner.nextLine();
                    System.out.print("Enter department location: ");
                    String location = scanner.nextLine();
                    
                    operation.insertDepartment(deptNo, deptName, location);
                    
                    break;
                case 2:
                    System.out.print("Enter employee number: ");
                    int empNo = scanner.nextInt();
                    System.out.print("Enter employee name: ");
                    scanner.nextLine(); 
                    String empName = scanner.nextLine();
                    System.out.print("Enter job: ");
                    String job = scanner.nextLine();
                    System.out.print("Enter manager ID: ");
                    int manager = scanner.nextInt();
                    System.out.print("Enter hire date (YYYY-MM-DD): ");
                    scanner.nextLine(); 
                    String hireDateStr = scanner.nextLine();
                    Date hireDate = Date.valueOf(hireDateStr);
                    System.out.print("Enter salary: ");
                    double salary = scanner.nextFloat();
                    System.out.print("Enter commission: ");
                    double commission = scanner.nextDouble();
                    System.out.print("Enter department number: ");
                    int deptNoEmp = scanner.nextInt();
                    
                    operation.insertEmployee(empNo, empName, job, manager, hireDate, salary, commission, deptNoEmp);
                    
                    break;
                case 3:
                    System.out.print("Enter department name: ");
                    scanner.nextLine(); 
                    String departmentName = scanner.nextLine();
                    
                    operation.displayEmployeesByDepartment(departmentName);
                    
                    break;
                case 4:
                    operation.updateEmployeeCommission(20);
                    break;
                case 5:
                    operation.insertNewEmployeeInHR();
                    break;
                case 6:
                    System.out.print("Enter salary threshold: ");
                    double salaryThreshold = scanner.nextDouble();
                    operation.deleteEmployeesWithSalaryLessThan(salaryThreshold);
                    break;
                case 7:
                    operation.displayAllEmployees();
                    break;
                case 8:
                    operation.displayAllDepartments();
                    break;
                case 9:
                	System.out.println("Exiting...!!!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    	}
}