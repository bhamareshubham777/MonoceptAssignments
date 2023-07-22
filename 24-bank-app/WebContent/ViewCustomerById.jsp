<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border = "1" width = "100%">
         <tr>
            <th>Customer Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Password</th>
         </tr>
         
            <tr>
               <td>${customer}</td>
               <td>${firstName}"</td>
               <td>${lastName}</td>
               <td>${password}</td>
            </tr>
      </table>
</body>
</html>