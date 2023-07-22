<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Customer</title>
</head>
<body>
	<h1>Add New Customer</h1>
	<br><br>
	<form action="AddCustomerController" method="POST">
        <input type="text" name="firstName" placeholder="Firstname">
        <br><br>
        <input type="text" name="lastName" placeholder="Lastname">
        <br><br>
        <input type="password" name="password" placeholder="Password">
        <br><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Cancel">
        
        <c:if test="${not empty errorMessage}">
            <p style="color: red">${errorMessage}</p>
        </c:if>
    </form>
</body>
</html>