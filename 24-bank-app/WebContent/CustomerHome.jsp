<%@page import="com.techlabs.bankapplication.Customer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customer Home</title>
</head>
<body>
    <h1>Welcome,<span style="color: brown">${name}</span></h1>

    <h2>Options:</h2>
    <ul>
        <li><a href="PassbookController">Passbook</a></li>
        <li><a href="NewTransaction.jsp">New Transaction</a></li>
        <li><a href="UpdateProfile.jsp">Edit Profile</a></li>
    </ul>

    <c:if test="${not empty successMessage}">
        <p style="color: green">${successMessage}</p>
    </c:if>
    
</body>
</html>