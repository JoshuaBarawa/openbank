
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
      <link rel="stylesheet" href="/css/users.css"> 

   <div class="container">
   <h4>All Bank Customers</h4>
    <table class="table table-bordered">
    <tr>
      <th>UserName</th>
      <th>Email</th>
      <th>ID Number</th>
      <th>Phone Number</th>
      <th>Active</th>
      <th>Actions</th>
    </tr>
    
    <tbody>
    <c:forEach var="user" items="${users}" >
   <tr>
      <td class="value"><c:out value="${user.userName}"/></td>
      <td class="value"><c:out value="${user.email}"/></td>
      <td class="value"><c:out value="${user.idNumber}"/></td>
      <td class="value"><c:out value="${user.phoneNumber}"/></td>
      <td class="value"><c:out value="${user.enabled}"/></td>
       <td>
       <form action="/freeze/${user.id}" method="post">
       <input class="lock-links" type="submit" value="Lock" />
       </form>
       
       <form action="/open/${user.id}" method="post">
       <input class="unlock-links" type="submit" value="Unlock" />
       </form>
       
       </td>
    </tr>
     </c:forEach>
     </tbody>
</table>
</div>
