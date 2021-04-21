
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
      <link rel="stylesheet" href="/css/profile.css"> 
<div class="center">

  <form:form action="/update" modelAttribute="user" method="post" >
  
    <p>Account Details</p>
    <div class="msg" ><c:out value="${msg}"></c:out></div>
  
  <div class="form-group">
    <label for="userName"><b>Change UserName</b></label>
    <form:input path="userName" type="text" class="form-control" name="name" />  
   </div>
   
    <div class="form-group">
    <label for="email"><b>Change Email</b></label>
    <form:input path="email" type="text" class="form-control" name="email"/>
 </div>
 
  <div class="form-group">
    <label for="idno"><b>Change ID Number</b></label>
    <form:input path="idNumber" type="text" class="form-control" name="idnumber"/>
 </div>
 
  <div class="form-group">
    <label for="pno"><b>Change Phone Number +254</b></label>
    <form:input path="phoneNumber" type="text" class="form-control" name="phonenumber"/>
 </div>
 
 <div class="form-group">
    <label for="password"><b>Change Password</b></label>
    <form:input path="password" type="password" class="form-control" name="password"/>
    </div>

    <input type="submit" value="Update Details" class="registerbtn" />
</form:form> 

  </div>
