package com.app.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.beans.LoginBeans;

public class AuthenticationFilters implements Filter {
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("SecurityFilter.init() called.");
	}
	
	@Override
	public void destroy() {
		System.out.println("SecurityFilter.destroy() called.");
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		 ArrayList<String> nocheckList = new ArrayList<String>();
		Collections.addAll(nocheckList, "index", "login", "NewUserAdded", "register");
		HttpServletRequest rq = (HttpServletRequest) req;
		HttpSession session1 = rq.getSession();
		LoginBeans lb =  (LoginBeans) session1.getAttribute("login");
		String page = rq.getParameter("page");
		if(!nocheckList.contains(page)) {
			HttpSession session = rq.getSession();
			if(lb == null || lb.getUser() == null) { 
				 HttpServletResponse res = (HttpServletResponse) resp;
				 res.sendRedirect("default.jsp");
				 return;
			}
		}
		chain.doFilter(req, resp);
	}
}
