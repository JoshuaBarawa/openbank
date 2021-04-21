
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
 
  <link rel="stylesheet" href="/css/deposit.css"> 
   <div class="center">
  <form action="/deposit" method="post" >
 
   <p class="msg"> <c:out value="${msg}"></c:out></p>
   <p class="error"> <c:out value="${error}"></c:out></p>
  <div class="form-group">
    <label for="amount"><b>Amount</b></label>
    <input type="text" class="form-control" placeHolder="Enter Deposit Amount" name="amount" required/>  
   </div>
   

    <input type="submit" value="Deposit" class="registerbtn" />

</form> 

  </div>