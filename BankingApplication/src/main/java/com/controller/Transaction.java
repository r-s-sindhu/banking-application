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

import com.service.Util;

@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
    		
    		HttpSession session=request.getSession();
    		session.getAttribute("info");
    		String usr=(String)session.getAttribute("info");
    		
    		Statement stmt=Util.getConnection().createStatement();
    		String sql="select * from transaction where username='"+usr+"'";
    		ResultSet rs=stmt.executeQuery(sql);
    		out.println("<center><h1>Transaction History</h1></center>");
    		out.println("<p style='text-align:right'><a href='dashboard.jsp' style='font-size:20px'>Go back</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='TransactionHistory' style='font-size:20px'>Print</a></p>");
    		out.println("<link rel='stylesheet' type='text/css' href='table.css' />");
    		out.print("<table id='user' width='100%'");   
    		out.print("<tr><th>Accno</th><th>Status</th><th>Amount</th><th>Balance</th></tr>");     		
    		while(rs.next())
    		{
    			out.print("<table id='user' border='1' width='100%'");  
    			out.print("<tr><td width='22.9%'>"+rs.getInt(1)+"</td><td width='22.9%'>"+rs.getString(3)+"</td><td width='26.9%'>"+rs.getDouble(4)+"</td><td>"+rs.getDouble(5)+"</td></tr>");  		     
    			out.print("</table>");   
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
