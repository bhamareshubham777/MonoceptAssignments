<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.*, com.techlabs.bankapplication.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Customers</title>
</head>
<body>
    <h1>Customer Details</h1>
    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Account Number</th>
            <th>Balance</th>
        </tr>
        
        
        <% 
            List<Customer> customers = (List<Customer>) request.getAttribute("customers");
            for (Customer customer : customers) {
                List<Account> accounts = customer.getAccounts();
                for (Account account : accounts) {
        %>
        <tr>
            <td><%= customer.getFirstName() %></td>
            <td><%= customer.getLastName() %></td>
            <td><%= account.getAccountNumber() %></td>
            <td><%= account.getBalance() %></td>
        </tr>
        <% 
                }
            } 
        %>
        
    </table>
</body>
</html>