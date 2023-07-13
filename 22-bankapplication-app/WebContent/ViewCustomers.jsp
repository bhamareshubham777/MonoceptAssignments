<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
   <head>
      <title>JSTL sql:query Tag</title>
   </head>
   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/bank_db"
         user = "root" password = "shubh143"/>
         <sql:query dataSource = "${snapshot}" var = "result">
         SELECT c.firstname, c.lastname, a.account_no, a.balance FROM customer c INNER JOIN account a ON c.customer_id=a.customer_id;
      </sql:query>
      <table border = "1" width = "100%">
         <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Account Number</th>
            <th>Balance</th>
         </tr>
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.firstname}"/></td>
               <td> <c:out value = "${row.lastname}"/></td>
               <td> <c:out value = "${row.account_no}"/></td>
               <td> <c:out value = "${row.balance}"/></td>
            </tr>
         </c:forEach>
      </table>
   </body>
</html>