<%@page import="com.app.beans.BlogListBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
  <jsp:useBean id="delete" class="com.app.beans.BlogListBeans"></jsp:useBean>
      <jsp:setProperty name="delete" property="userID" value ="${login.user.userId}" />
      <jsp:setProperty property="id" name="delete" param="id"/>
    <% delete.deleteBlogs(); %>
    <c:choose>
		<c:when test="${delete.count >0}">
			<c:redirect url="ctl?page=bloglist"/>
		</c:when>
		<c:otherwise>
			Delete failed. <br/><br/>
			<a href="ctl?page=bloglist">Show Result</a>
		</c:otherwise>
	</c:choose>
   
</body>
</html>