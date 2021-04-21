<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
      <link rel="stylesheet" href="/css/statements.css"> 
    
    
    <div class="container">
   <h4>Transaction History</h4>
    <table class="table table-bordered">
    <tr>
      <th>TRANSACTION-DATE</th>
      <th>TRANSACTION-TYPE</th>
      <th>RECIPIENT</th>
      <th>TRANSACTION AMOUNT</th>
      <th>BALANCE</th>
      <th>ACTIONS</th>
    </tr>
    
    <tbody>
    <c:forEach var="statement" items="${statements}" >
   <tr>
      <td class="value"><c:out value="${statement.date}"/></td>
      <td class="value"><c:out value="${statement.transType}"/></td>
      <td class="value"><c:out value="${statement.recipient}"/></td>
      <td class="value"><c:out value="${statement.amount}"/></td>
      <td class="value"><c:out value="${statement.balance}"/></td>
       <td>
       <form action="/delete/${statement.id}" method="post">
       <input class="table-links" type="submit" value="Delete" />
       </form>
       
       </td>
    </tr>
     </c:forEach>
     </tbody>
</table>
</div>
