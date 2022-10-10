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

@WebServlet("/MobileRecharge")
public class MobileRecharge extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String mob=request.getParameter("mob");
			String operator=request.getParameter("operator");
			String state=request.getParameter("state");
			HttpSession session=request.getSession();
			session.setAttribute("mob", mob);
			session.setAttribute("operator", operator);
			session.setAttribute("state", state);
			out.println("<link rel='stylesheet' type='text/css' href='table.css' />");
			
			if(operator.equals("Airtel"))
			{
				Statement stmt=Util.getConnection().createStatement();
				String sql="select * from airtelrecharge";
				ResultSet rs=stmt.executeQuery(sql);
				out.print("<center><h2>Mobile Recharge</h2></center>");
				out.print("<br><br>");
				out.print("<table id='user' width='100%'");   
				out.print("<tr><th>ID</th><th>Data</th><th>Validity</th><th>Description</th><th>Price</th><th>Apply</th></tr>");
				while(rs.next())
				{
		    		out.print("<table id='user' border='1' width='100%'");  
					out.print("<tr><td width='8.7%'>"+rs.getInt(1)+"</td><td width='13.5%'>"+rs.getString(2)+"</td><td width='19.3%'>"+rs.getString(3)+"</td><td width='27.6%'>"+rs.getString(4)+"</td><td width='14.8%'>"+rs.getInt(5)+"</td><td><a href='RechargeServlet?price="+rs.getInt(5)+"'>Apply</a></td></tr>");
					out.print("</table>");
				}
			}
			
			if(operator.equals("Jio"))
			{
				Statement stmt1=Util.getConnection().createStatement();
				String sql1="select * from jiorecharge";
				ResultSet rs1=stmt1.executeQuery(sql1);
				out.print("<center><h2>Mobile Recharge</h2></center>");
				out.print("<br><br>");
				out.print("<table id='user' width='100%'");   
				out.print("<tr><th>ID</th><th>Data</th><th>Validity</th><th>Description</th><th>Price</th><th>Apply</th></tr>");
				while(rs1.next())
				{
					out.print("<table id='user' border='1' width='100%'");  
					out.print("<tr><td width='8.7%'>"+rs1.getInt(1)+"</td><td width='13.5%'>"+rs1.getString(2)+"</td><td width='19.3%'>"+rs1.getString(3)+"</td><td width='27.6%'>"+rs1.getString(4)+"</td><td width='14.8%'>"+rs1.getInt(5)+"</td><td><a href='RechargeServlet?price="+rs1.getInt(5)+"'>Apply</a></td></tr>");
					out.print("</table>");
				}
			}
		}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    }
}
