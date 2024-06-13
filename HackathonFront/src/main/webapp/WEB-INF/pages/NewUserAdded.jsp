<%@page import="com.app.beans.NewUserBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <jsp:useBean id="register" class="com.app.beans.NewUserBeans"/>
  <jsp:setProperty property="fullName" name="register" param="fullName"/>
  <jsp:setProperty property="password" name="register" param="password"/>
  <jsp:setProperty property="email" name="register" param="email"/>
  <jsp:setProperty property="phoneNumber" name="register" param="phoneNumber"/>
   <% register.insertUser(); %>
	<c:choose>
		<c:when test="${register.count > 0}">
			Registration successful.
			<jsp:forward page="ctl?page=index"></jsp:forward>
		</c:when>
		<c:otherwise>
			Registration failed.
			<a href="ctl?page=index">Sign Up</a>
		</c:otherwise>
	</c:choose>
</body>
</html>