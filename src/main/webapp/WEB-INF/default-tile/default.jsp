<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
    <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">  
  <title><tiles:insertAttribute name="title" /></title>
  
</head>

<body>
 <nav class="navbar navbar-default navbar-static-top">
  <div class="container">
        <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/home">TechBite-Bank</a>
        </div>
        <a href="#" class="toggle-button">
        <span class="bar"></span>
         <span class="bar"></span>
          <span class="bar"></span>
        </a>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="/home">Home</a></li>
            <sec:authorize access="hasAuthority('USER')">
            <li><a href="/transfer">Send Money</a></li>
            <li><a href="/statements">MiniStatements</a></li>
            
            </sec:authorize>
            
             <sec:authorize access="hasAuthority('ADMIN')">
              <li><a href="/admin/users">Users</a></li>
              </sec:authorize>
              
            <sec:authorize access="!isAuthenticated()">
              <li><a href="/user/signup">Sign Up</a></li>
              </sec:authorize>
          </ul>
          <ul class="nav navbar-nav navbar-right">
          <sec:authorize access="!isAuthenticated()">
           <li><a href="/login">Sign In</a></li>
            </sec:authorize>
            
            <sec:authorize access="isAuthenticated()" >
          <li class="dropdown">
              <a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Me <span class="caret"></span></a>
              <ul class="dropdown-menu">
                <li><a href="/profile">Profile</a></li>
                <li role="separator" class="divider"></li>
                <li><a href="/logout">Logout</a></li>
              </ul> 
               </sec:authorize>
          </ul>
        </div>
        </div><!--/.nav-collapse -->
    </nav>
    
<tiles:insertAttribute name="content" />
 <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</body>
</html>