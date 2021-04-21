<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    
   <link rel="stylesheet" href="/css/login.css">  

 <body>
  <div class="center">
  <form action="/login" method="post" >
 
  <p>Login</p>
  <c:if test="${param.error != null }">
 <div class="error">Invalid email or password</div>
 </c:if>
    
  
  <div class="form-group">
    <input  type="text" class="form-control" placeholder="Enter Email" name="username" />  
   </div>
   
    <div class="form-group">
    <input type="password" class="form-control" placeholder="Enter password" name="password"/>
   </div>
   
  <div><a class="forpssw" href="/user/resetpassword" >Forgot Password?</a></div>
   
    <input type="submit" value="Login" class="registerbtn" />
    
    <div class="signup_link">Not a member? <a href="/user/signup">	Sign Up</a></div>
 
</form> 
 </div>
</body>