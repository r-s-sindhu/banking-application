package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
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

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.setContentType("text/html");
	    	PrintWriter out=response.getWriter();
			String wamount=request.getParameter("amount");
			double amount=Double.parseDouble(wamount);
			
			HttpSession session=request.getSession();
			session.getAttribute("info");
			String usr=(String)session.getAttribute("info");
			
			User u1=new User();
	    	Statement stmt=Util.getConnection().createStatement();
			String sql="select * from register where username='"+usr+"'";
			ResultSet rs=stmt.executeQuery(sql);
			double bal=0.0;
			if(rs.next()) {
				u1.setAmount(rs.getDouble(7));
				if(u1.getAmount()>amount)
				{
					if(amount>0)
					{
						bal=u1.getAmount()-amount;
						if(bal<=100.0)
						{
							request.getRequestDispatcher("withdraw.jsp").include(request, response);
							out.println("<center><h3>Minimum balance of 100 should be maintained</h2></center>");
						}
						else
						{
							request.getRequestDispatcher("withdraw.jsp").include(request, response);
							out.println("<center><h3>Withdraw successful</center></h2>");
							out.println("<center><h3>Your balance is : "+bal+"</center></h2>");
							PreparedStatement ps=Util.getConnection().prepareStatement("update register set amt=? where username='"+usr+"'");
							ps.setDouble(1, bal);
							ps.executeUpdate();
							PreparedStatement ps1=Util.getConnection().prepareStatement("insert into transaction values (?,?,?,?,?)");
							ps1.setInt(1, rs.getInt(1));
							ps1.setString(2, usr);
							ps1.setString(3, "debited");
							ps1.setDouble(4, amount);
							ps1.setDouble(5, bal);
							ps1.executeUpdate();
						}
					}
					else 
					{
						request.getRequestDispatcher("withdraw.jsp").include(request, response);
						out.println("<center><h3>Amount can't be zero or negative</h3></center>");
					}
				}
				else
				{
					request.getRequestDispatcher("withdraw.jsp").include(request, response);
					out.println("<center><h3>Insufficient balance</h3></center>");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}