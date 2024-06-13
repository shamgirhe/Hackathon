<%@page import="com.app.beans.CategoryBeans"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Blog</title>
<style>
    body {
        background-color: #121212;
        color: #ffffff;
        font-family: Arial, sans-serif;
    }
       h1 {
        color: #e0e0e0;
        text-align: center; /* Center the h1 */
    }
    h2, h3 {
        color: #e0e0e0;
         text-align: center;
    }
    table {
        margin: 0 auto;
        padding: 20px;
        border-collapse: collapse;
    }
    label {
        display: block;
        margin-bottom: 5px;
    }
    input[type="text"], select {
        width: 100%;
        padding: 8px;
        margin-bottom: 10px;
        border: 1px solid #333;
        border-radius: 4px;
        background-color: #333;
        color: #fff;
    }
    input[type="submit"] {
        background-color: #6200ea;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #3700b3;
    }
</style>
</head>
<body>
<jsp:useBean id="category" class="com.app.beans.CategoryBeans"></jsp:useBean>
<% category.fetchCategory(); %>
<h1>Add Blogs</h1>
<h2>Blog Details</h2>
<h3>Fill in the details below to add a new blog post</h3>
<form method="post" action="ctl?page=BlogAdded">
    <table>
        <tr>
            <td><label for="title">Title</label></td>
            <td>
                <input type="text" id="title" name="title" placeholder="Enter title" required />
            </td>
        </tr>
        <tr>
            <td><label for="contents">Contents</label></td>
            <td>
                <input type="text" id="contents" name="contents" placeholder="Enter contents" required />
            </td>
        </tr>
        <tr>
            <td>Category :</td>
            <td>
                <select name="Category">
                    <c:forEach var="c" items="${category.cantegoryList}">
                        <option value="${c.id}">${c.title}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Submit" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>
