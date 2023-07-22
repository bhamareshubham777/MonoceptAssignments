<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>View Transactions</title>
</head>
<body>
    <h1>Transaction Details</h1>
    <table>
        <tr>
        	<th>Sender Account Number</th>
            <th>Receiver Account Number</th>
            <th>Transaction Type</th>
            <th>Amount</th>
            <th>Date</th>
        </tr>
        <c:forEach items="${transactions}" var="transaction">
            <tr>
            	<td>${transaction.senderAccountNumber}</td>
                <td>${transaction.recieverAccountNumber}</td>
                <td>${transaction.transactionType}</td>
                <td>${transaction.amount}</td>
                <td>${transaction.date}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
