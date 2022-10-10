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
import com.service.UserDao;
import com.service.Util;
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {	
    		response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
    		String name=request.getParameter("username");
    		String pass=request.getParameter("password");
    		User u=new User();
    		u.setUsername(name);
    		
    		HttpSession session=request.getSession();
    		session.getAttribute("info");
    		String usr=(String)session.getAttribute("info");
    		
    		Statement stmt=Util.getConnection().createStatement();
    		String sql="select * from register where username='"+name+"'";
    		ResultSet rs=stmt.executeQuery(sql);
    		if(rs.next())
    		{
    			u.setPassword(rs.getString(3));
    			if(name.equals(usr) && pass.equals(u.getPassword()))
    			{
    				User u1=UserDao.getUserByName(name);
    				out.print("<form action='EditServlet2' method='post'>");  
			        out.print("<center>");
			        out.print("<table style='font-size:20px'>");  
			        out.print("<h2>Edit User Details</h2><br><br>");
			        out.print("<tr><td></td><td><input type='hidden' name='accno' value='"+u1.getAccno()+"' style='font-size:20px'/></td></tr>");  
			        out.print("<tr><td>Name:</td><td><input type='text' name='username' value='"+u1.getUsername()+"' style='font-size:20px'/></td></tr>");  
			        out.print("<tr><td>Password:</td><td><input type='text' name='pwd' value='"+u1.getPassword()+"' style='font-size:20px'/></td></tr>");  
			        out.print("<tr><td>Phone:</td><td><input type='number' name='phno' value='"+u1.getPhno()+"' style='font-size:20px'/></td></tr>");
			        out.print("<tr><td>Address:</td><td><input type='text' name='add' value='"+u1.getAddress()+"' style='font-size:20px'/></td></tr>");
			        out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+u1.getEmail()+"' style='font-size:20px'/></td></tr>");
			        out.print("<tr><td>Account Type:</td><td>");  
			        out.print("<select name='acc type' style='width:150px'>");  
			        out.print("<option value='Savings'>Savings</option>");  
			        out.print("<option value='Current'>Current</option>"); 
			        out.print("</select>");  
			        out.print("</td></tr>"); 
			        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save ' style='font-size:15px'/></td></tr>");  
			        out.print("</table>");  
			        out.print("</center>");
			        out.print("</form>");  			          
    			}
    			else
        		{
        			request.getRequestDispatcher("update.jsp").include(request, response);  
    				out.print("<center><h3>Invalid credentials</h3></center>");
        		}
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}