<%@page import="com.app.pojos.User"%>
<%@page import="com.app.beans.LoginBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Login Beans</title>
</head>
<body>
   <jsp:useBean id="login" class="com.app.beans.LoginBeans" scope="session"></jsp:useBean>
   <jsp:setProperty property="email" name="login" param="email"/>
   <jsp:setProperty property="password" name="login" param="password"/>
   <% login.loginAuth();%>
   
 <% 
    if (login.getUser() != null) {
%>       
        <% response.sendRedirect("ctl?page=bloglist"); %>
<% 
    } else {
%>
        <h1>Login Failed!!!</h1>
        <a href="ctl?page=index">Login Again!!!</a>
<% 
    } 
%>

</body>
</html>