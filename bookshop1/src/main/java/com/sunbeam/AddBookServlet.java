package com.sunbeam;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet
{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	 doPost(req, resp);  
	   
}
   @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int id = Integer.parseInt(req.getParameter("id"));
	    String name = req.getParameter("name");
		String author = req.getParameter("author");
		String subject = req.getParameter("subject");
		double price = Double.parseDouble(req.getParameter("price"));
		Book b = new Book(id, name, author, subject, price);
		int count = 0;
		try(BookDao bookDao = new BookDao())
		{
			count = bookDao.save(b);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		 req.setAttribute("message", "Book Added:" +count);
  		 RequestDispatcher rd = req.getRequestDispatcher("booklist");
  		 rd.forward(req, resp);

	}
   

}

