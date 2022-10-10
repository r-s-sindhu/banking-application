package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.Util;

@WebServlet("/AccountDetails")
public class AccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String user=request.getParameter("username");
			String pass=request.getParameter("password");
			User u1=new User();
	    	u1.setUsername(user);
	    	u1.setPassword(pass);
	    	
	    	HttpSession session=request.getSession();
			session.getAttribute("info");
			String usr=(String)session.getAttribute("info");
			
	    	Statement stmt=Util.getConnection().createStatement();
			String sql="select * from register where username='"+user+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
			{
				u1.setPassword(rs.getString(3));
				if(user.equals(usr)&&pass.equals(u1.getPassword()))
				{	
					request.getRequestDispatcher("accdetails.jsp").include(request, response);  
					out.println("<center><p>Account No : "+rs.getInt(1)+"</p></center>");
					out.println("<center><p>User Name : "+rs.getString(2)+"</p></center>");
					out.println("<center><p>Password : "+rs.getString(3)+"</p></center>");
					out.println("<center><p>Phone No : "+rs.getString(4)+"</p></center>");
					out.println("<center><p>Address : "+rs.getString(5)+"</p></center>");
					out.println("<center><p>Email : "+rs.getString(6)+"</p></center>");
					out.println("<center><p>Amount : "+rs.getDouble(7)+"</p></center>");
					out.println("<center><p>Account Type : "+rs.getString(8)+"</p></center>");
				}
				else
				{
					request.getRequestDispatcher("accdetails.jsp").include(request, response);
					out.println("<center><h3>Invalid credentials</h3></center>");
				}
			}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
