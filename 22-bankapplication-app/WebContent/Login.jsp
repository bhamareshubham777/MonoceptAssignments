<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
    <form action="LoginController" method="POST">
        <select name="loginType" id="loginType">
        	<option value=""></option>
            <option value="admin">Admin</option>
            <option value="customer">Customer</option>
        </select>
        <br><br>
        <input type="text" name="firstName" placeholder="Firstname">
        <br><br>
        <input type="text" name="lastName" placeholder="Lastname">
        <br><br>
        <input type="password" name="password" placeholder="Password">
        <br><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Cancel">
    </form>
</body>
</html>