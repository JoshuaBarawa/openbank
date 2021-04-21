
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
   
    <link href="${pageContext.request.contextPath}/css/signup.css" rel="stylesheet"> 
   
    </body> 
    <div class="center">
    
  <form:form action="/user/signup" modelAttribute="user" method="post" >
 
    <p>Sign Up</p>
    
    <div class="error" style="color: red"><c:out value="${error}"></c:out></div>
  <div class="form-group">
    <form:input path="userName" type="text" class="form-control" placeholder="Enter UserName" name="name" required="please this field!!"/>  
   </div>
   
    <div class="form-group">
    <form:input path="email" type="text" class="form-control" placeholder="Enter Email" name="email" required="please this field!!" />
 </div>
 
  <div class="form-group">
    <form:input path="idNumber" type="text" class="form-control" placeholder="Enter ID Number" name="idnumber" required="please this field!!"/>
 </div>
 
  <div class="form-group">
    <form:input path="phoneNumber" type="text" class="form-control" placeholder="Enter Phone Number" name="phonenumber" required="please this field!!"/>
 </div>
 
 <div class="form-group">
    <form:input path="password" type="password" class="form-control" placeholder="Enter Password" name="password" required="please this field!!"/>
    </div>

    <input type="submit" value="Sign Up" class="registerbtn" />
    
     <div class="signin_link">
   Already a member? <a href="/login">Login</a>
    </div>

</form:form> 

 </div>
 
 </body>