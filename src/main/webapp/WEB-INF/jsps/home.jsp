<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="/css/home.css"> 


<div class="container">
<sec:authorize access="hasAuthority('ADMIN')">
Welcome ADMIN
</sec:authorize>


<sec:authorize access="hasAuthority('USER')">
 
 
  <div class="card">
  <img src="/img/purse.png" height="190px" width="90%"/>
 <h4><strong>Account Balance</strong></h4>
   <strong>Ksh.<c:out value="${account.accountBalance}"></c:out></strong>
</div>


<div class="card">
 <a href="/deposit" >
 <img src="/img/piggy-bank.png" height="200px" width="90%"/>
    <Strong>Deposit Money</Strong>
 </a>
 </div> 


<div class="card">
<a href="/withdraw">
<img src="/img/atm.png" height="200px" width="90%"/>
   <Strong>WithDraw Money</Strong>
  </a>
</div> 
 

</sec:authorize>



</div>