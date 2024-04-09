package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fc")
public class FrontController extends HttpServlet{
	
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
	
	String page = req.getParameter("page");
	String jspPage = "/default.jsp";
	if(page.equals("index"))
		jspPage = "/index.jsp";
	else if(page.equals("login"))
		jspPage = "/WEB-INF/views/login.jsp";
	else if(page.equals("subjects"))
		jspPage = "/WEB-INF/views/subjects.jsp";
	else if(page.equals("books"))
		jspPage = "/WEB-INF/views/books.jsp";
	else if(page.equals("register"))
		jspPage = "/WEB-INF/views/register.jsp";
	else if(page.equals("addcart"))
		jspPage = "/WEB-INF/views/addcart.jsp";
	else if(page.equals("showcart"))
		jspPage = "/WEB-INF/views/showcart.jsp";
	else if(page.equals("signup"))
		jspPage = "/WEB-INF/views/signup.jsp";
	else if(page.equals("logout"))
		jspPage = "/logout.jsp";
	
	ServletContext ctx = this.getServletContext();
	RequestDispatcher rd = ctx.getRequestDispatcher(jspPage);
	rd.forward(req, resp);
	
}

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	doGet(req, resp);
}
}





