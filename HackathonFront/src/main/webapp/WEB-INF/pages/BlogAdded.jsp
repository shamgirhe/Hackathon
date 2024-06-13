<%@page import="com.app.beans.BlogListBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <jsp:useBean id="addBlog" class = "com.app.beans.BlogListBeans"></jsp:useBean>
 <jsp:setProperty property="title" name="addBlog" param="title"/>
 <jsp:setProperty property="contents" name="addBlog" param="contents"/>
 <jsp:setProperty property="id" name="addBlog" param="Category"/> 
 <jsp:setProperty property="userID" name="addBlog" value="${login.user.userId}"/> 
  <% addBlog.addBlog(); %>
  <c:choose>
		<c:when test="${addBlog.count >0}">
			<c:redirect url="ctl?page=bloglist"/>
		</c:when>
		<c:otherwise>
			Candidate Added failed. <br/><br/>
			<a href="ctl?page=bloglist">Show Result</a>
		</c:otherwise>
	</c:choose>
</body>
</html>