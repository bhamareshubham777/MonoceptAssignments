<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.*, com.techlabs.bankapplication.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body>
	<h1>Welcome,<span style="color: brown">${name}</span></h1>
    <ul>
        <li><a href="AddNewCustomer.jsp">Add new Customer</a></li>
        <li><a href="GenerateAccount.jsp">Add Bank Account</a></li>
        <li><a href="ViewCustomersController">View Customers</a></li>
        <li><a href="ViewTransactionController">View Transactions</a></li>
    </ul>
    
    <c:if test="${not empty successMessage}">
        <p style="color: green">${successMessage}</p>
    </c:if>
    
    <c:if test="${not empty successMessage2}">
            <p style="color: green">${successMessage2}</p>
        </c:if>
</body>
</html>