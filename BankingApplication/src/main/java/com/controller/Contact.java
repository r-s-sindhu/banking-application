package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Util;

@WebServlet("/Contact")
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
    		String name=request.getParameter("Name");
    		String email=request.getParameter("Email");
    		String mobile=request.getParameter("Mobile");
    		String message=request.getParameter("Message");
		
    		PreparedStatement ps=Util.getConnection().prepareStatement("insert into contact (name,email,mobile,message) values (?,?,?,?)");
    		ps.setString(1, name);
    		ps.setString(2, email);
    		ps.setString(3, mobile);
    		ps.setString(4, message);
    		ps.execute();
    		out.println("Submitted");
    		request.getRequestDispatcher("home.jsp").include(request, response);
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
