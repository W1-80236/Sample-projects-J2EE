

package com.sunbeam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		System.out.println("email: " + email + ", password: " + password);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Login Result</title>");
		out.println("</head>");
		out.println("<body>");

		try(UserDao userDao = new UserDao()) {
		
			User user = userDao.findByEmail(email);
			System.out.println("Logged IN: " + user);
			if(user != null && password.equals(user.getPassword())) {
				/*Cookie c = new Cookie("uname", user.getName());
								c.setMaxAge(3600); 
								resp.addCookie(c);
			*/
				HttpSession session = req.getSession();
				session.setAttribute("uname", user.getName());
				if(user.getRole().equals("ROLE_ADMIN")) {
				 //out.println("<h2>Welcome, Admin!</h2>");
					resp.sendRedirect("booklist"); 
				}
				else {
					//out.printf("<h2>Welcome, User (%s)!</h2>\n", user.getName());
					ArrayList<Integer> cart = new ArrayList<>();
					session.setAttribute("cart",cart);
					resp.sendRedirect("subjects");
				}
			}
			else {
				
				out.println("<h2>Invalid email or password.</h2>");
				out.println("<a href='index.html'>Login again</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		out.println("</body>");
		out.println("</html>");
	}
}















