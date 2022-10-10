package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.Util;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
	    	response.setContentType("text/html");
	    	PrintWriter out=response.getWriter();
	    	String luser=request.getParameter("luser");
	    	String lpass=request.getParameter("lpwd");
	    	
	    	HttpSession session=request.getSession();
			session.setAttribute("info", luser);
	    	
	    	User u1=new User();
	    	u1.setUsername(luser);
	    	u1.setPassword(lpass);
	    	Statement stmt=Util.getConnection().createStatement();
			String sql="select username, password from register where username='"+u1.getUsername()+"'and password='"+u1.getPassword()+"'";
			ResultSet rs=stmt.executeQuery(sql);
			
			if(rs.next())
			{
				u1.setUsername(rs.getString(1));
				u1.setPassword(rs.getString(2));
				if(luser.equals(u1.getUsername()) && lpass.equals(u1.getPassword()))
				{
					out.println("<h1><center>Login success</center></h1>");
			    	RequestDispatcher rd=request.getRequestDispatcher("dashboard.jsp");
			    	rd.forward(request, response);
				}		
	    	}
			else
			{
				request.getRequestDispatcher("login.jsp").include(request, response);
				out.println("<center><h3>Login failed</h3></center>");
			}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
