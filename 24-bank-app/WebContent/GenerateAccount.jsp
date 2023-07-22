<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Generate Account</title>
</head>
<body>
    <h1>Generate Account</h1>
    <form action="GenerateAccountController" method="post">
        <input type="text" name="customerId" placeholder="Enter ID"/>
        <input type="submit" name="submit" value="Search"><br/><br/>
        <input type="text" name="balance" placeholder="Enter Amount"/><br/><br/>
        <input type="submit" value="Generate Account" />
        
        <c:if test="${not empty errorMessage}">
            <p style="color: red">${errorMessage}</p>
        </c:if>
        
        <c:if test="${not empty errorMessage2}">
            <p style="color: red">${errorMessage2}</p>
        </c:if>
        
        <c:if test="${not empty errorMessage3}">
            <p style="color: red">${errorMessage3}</p>
        </c:if>
    </form>
</body>
</html>
