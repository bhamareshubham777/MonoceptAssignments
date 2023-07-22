<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
    <h1>Edit Profile</h1>
    <form action="UpdateProfileController" method="POST">
      
        <input type="text" name="firstName" id="firstName" placeholder="Firstname">
        <br><br>
      
        <input type="text" name="lastName" id="lastName" placeholder="LastName">
        <br><br>
        
        <input type="password" name="password" id="password" placeholder="Password">
        <br><br>
        <input type="submit" value="Update">
        
         <c:if test="${not empty errorMessage}">
            <p style="color: red">${errorMessage}</p>
        </c:if>
    </form>
</body>
</html>
