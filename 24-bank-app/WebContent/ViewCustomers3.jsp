<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customer Accounts</title>
</head>
<body>
    <c:forEach var="customer" items="${requestScope.customers}" >
        <h2>${customer.firstName} ${customer.lastName}</h2>
        <ul>
            <c:forEach var="account" items="${customer.accounts}" >
                <li>Account Number: ${account.accountNumber}, Balance: ${account.balance}</li>
            </c:forEach>
        </ul>
    </c:forEach>
</body>
</html>
