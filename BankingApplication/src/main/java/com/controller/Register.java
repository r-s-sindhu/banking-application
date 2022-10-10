package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserDao;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String user=request.getParameter("user");
			String pass=request.getParameter("pwd");
			String cpass=request.getParameter("cpwd");
			String mob=request.getParameter("phno");
			String addr=request.getParameter("add");
			String email=request.getParameter("email");
			String amt=request.getParameter("amt");
			double amt1=Double.parseDouble(amt);
			String acctype=request.getParameter("acc_type");
			
			User u1=new User();
			u1.setUsername(user);
			u1.setPassword(pass);
			u1.setPhno(mob);
			u1.setAddress(addr);
			u1.setEmail(email);
			u1.setAmount(amt1);
			u1.setAcctype(acctype);
				
			if(pass.equals(cpass))
			{
				UserDao.saveUser(u1);
				out.println("<center><h3>Registeration successful</h3></center>");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
			else
			{
				request.getRequestDispatcher("register.jsp").include(request, response);
				out.println("<center><h3 style='color:white'>Registeration failed</h3></center>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
