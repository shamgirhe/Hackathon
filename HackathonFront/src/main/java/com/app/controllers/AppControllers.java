package com.app.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ctl")
public class AppControllers extends HttpServlet {
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		processRequest(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getRequestURI());
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String page = req.getParameter("page");
		String uri = "/WEB-INF/pages/index.jsp";
		if(page.equals("index"))
			uri = "/WEB-INF/pages/index.jsp";
		else if(page.equals("login"))
			uri = "/WEB-INF/pages/login.jsp";
		else if(page.equals("register"))
			uri = "/WEB-INF/pages/register.jsp";
		else if(page.equals("bloglist"))
			uri = "/WEB-INF/pages/bloglist.jsp";
		else if(page.equals("NewUserAdded"))
			uri = "/WEB-INF/pages/NewUserAdded.jsp";
		else if(page.equals("MyBLogs"))
			uri = "/WEB-INF/pages/MyBLogs.jsp";
		else if(page.equals("delete"))
			uri = "/WEB-INF/pages/delete.jsp";
		else if(page.equals("AddBLogs"))
			uri = "/WEB-INF/pages/AddBlogs.jsp";
		else if(page.equals("signout"))
			uri = "/WEB-INF/pages/signout.jsp";
		else if(page.equals("BlogAdded"))
			uri = "/WEB-INF/pages/BlogAdded.jsp";
		
		
		
		ServletContext ctx = this.getServletContext();
		RequestDispatcher rd = ctx.getRequestDispatcher(uri);
		rd.forward(req, resp);
	}
}
