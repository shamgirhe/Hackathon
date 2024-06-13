<%@page import="com.app.beans.BlogListBeans"%>
<%@page import="com.app.beans.NewUserBeans"%>
<%@page import="com.app.beans.CategoryBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Blog List</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f0f8ff; /* Light blue background */
            color: #333333; /* Dark gray text */
        }
        .container {
            width: 80%;
            margin: 20px auto;
            overflow: hidden;
            padding: 20px;
            background-color: #ffffff; /* White background for container */
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        table {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #cccccc; /* Light gray border */
        }
        th, td {
            padding: 12px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2; /* Light gray background for header */
            color: #333333; /* Dark gray text for header */
        }
        tr:nth-child(even) {
            background-color: #e9f5ff; /* Light blue background for even rows */
        }
        tr:nth-child(odd) {
            background-color: #ffffff; /* White background for odd rows */
        }
        caption {
            font-size: 1.5em;
            margin-bottom: 10px;
            color: #333333; /* Dark gray text for caption */
        }
        a img {
            vertical-align: middle;
        }
        .actions {
            margin: 20px 0;
            text-align: center;
        }
        .actions a {
            margin: 0 10px;
            padding: 10px 20px;
            background-color: #007bff; /* Blue background for buttons */
            color: #ffffff; /* White text for buttons */
            border-radius: 5px;
            text-decoration: none;
        }
        .actions a:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>
<div class="container">
    <jsp:useBean id="blog" class="com.app.beans.BlogListBeans"></jsp:useBean>
    <jsp:useBean id="user" class="com.app.beans.NewUserBeans" ></jsp:useBean>
    <jsp:useBean id="category" class="com.app.beans.CategoryBeans" ></jsp:useBean>
    <jsp:setProperty property="id" name="blog" value="${login.user.userId}" />
    <% blog.myBlogList(); %>
    <table>
        <caption>My Blogs</caption>
        <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Contents</th>
                <th>Created Date</th>
                <th>User Name</th>
                <th>Category Name</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${blog.blogList}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.title}</td>
                    <td>${c.contents}</td>
                    <td>${c.createdDate}</td>
                    <td>${user.userName(c.userId)}</td>
                    <td>${category.categoryName(c.categoryId)}</td>
                    <td>
                        <a href="ctl?page=delete&id=${c.id}">
                            <img src="images/delete.png" alt="Delete" width="24" height="24"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="actions">
        <a href="ctl?page=bloglist">All Blogs</a>
        <a href="ctl?page=AddBLogs">Add Blogs</a>
        <a href="ctl?page=signout">Sign Out</a>
    </div>
</div>
</body>
</html>

<%-- <%@page import="com.app.beans.BlogListBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Blog List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: auto;
            overflow: hidden;
        }
        table {
            width: 100%;
            margin: 20px 0;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid #dddddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        a img {
            vertical-align: middle;
        }
    </style>
</head>
<body>
<div class="container">
    <jsp:useBean id="blog" class="com.app.beans.BlogListBeans" ></jsp:useBean>
    <jsp:setProperty property="id" name="blog" value="${login.user.userId}" />
    <% blog.myBlogList();%>
    <table>
       <caption>My Blogs</caption>
        <thead>
            <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Contents</th>
                <th>Created Date</th>
                <th>User Id</th>
                <th>Category Id</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${blog.blogList}">
                <tr>
                    <td>${c.id}</td>
                    <td>${c.title}</td>
                    <td>${c.contents}</td>
                    <td>${c.createdDate}</td>
                    <td>${c.userId}</td>
                    <td>${c.categoryId}</td>
                    <td>
                        <a href="ctl?page=delete&id=${c.id}">
                            <img src="images/delete.png" alt="Delete" width="24" height="24"/>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
     <a href= "ctl?page=bloglist">All Blogs</a>
    <a href= "ctl?page=AddBLogs">Add Blogs</a>
    <a href= "ctl?page=signout">SignOut</a>
</div>
</body>
</html>
--%>