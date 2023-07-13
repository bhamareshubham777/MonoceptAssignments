<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<html>
   <head>
      <title>View Transactions</title>
   </head>
   <body>
      <sql:setDataSource var = "snapshot" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/bank_db"
         user = "root" password = "shubh143"/>
         <sql:query dataSource = "${snapshot}" var = "result">
         SELECT account_no, reciever_acct_no, transaction_type, amount, date from transaction;
      </sql:query>
      <table border = "1" width = "100%">
         <tr>
            <th>Sender Account Number</th>
            <th>Reciever Account Number</th>
            <th>Transaction Type</th>
            <th>Amount</th>
            <th>date</th>
         </tr>
         <c:forEach var = "row" items = "${result.rows}">
            <tr>
               <td> <c:out value = "${row.account_no}"/></td>
               <td> <c:out value = "${row.reciever_acct_no}"/></td>
               <td> <c:out value = "${row.transaction_type}"/></td>
               <td> <c:out value = "${row.amount}"/></td>
               <td> <c:out value = "${row.date}"/></td>
            </tr>
         </c:forEach>
      </table>
   </body>
</html>