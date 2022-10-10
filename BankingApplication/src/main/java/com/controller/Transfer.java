package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.Util;

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		try {
    		response.setContentType("text/html");
    	    PrintWriter out=response.getWriter();
    		String tnum=request.getParameter("taccno");
    		int taccno=Integer.parseInt(tnum);
    		String tamount=request.getParameter("amount");
    		double amount=Double.parseDouble(tamount);
    			
    		HttpSession session=request.getSession();
    		session.getAttribute("info");
    		String usr=(String)session.getAttribute("info");
    			
    		PreparedStatement ps=Util.getConnection().prepareStatement("select * from register where accno='"+taccno+"'");
    		ResultSet rs=ps.executeQuery();
    		double bal=0.0;
    		if(rs.next())
    		{
    			if(amount>0)
    			{
    				bal=amount+rs.getDouble(7);
    				request.getRequestDispatcher("transfer.jsp").include(request, response);
    				out.println("<center><h3>Transfer Successful</h3></center>");
    				PreparedStatement ps1=Util.getConnection().prepareStatement("update register set amt=? where accno='"+taccno+"'");
    				ps1.setDouble(1, bal);
    				ps1.executeUpdate();
    				PreparedStatement ps4=Util.getConnection().prepareStatement("insert into transaction values (?,?,?,?,?)");
					ps4.setInt(1, taccno);
					ps4.setString(2, rs.getString(2));
					ps4.setString(3, "credited");
					ps4.setDouble(4, amount);
					ps4.setDouble(5, bal);
					ps4.executeUpdate();
    			}
    			else
    			{
    				request.getRequestDispatcher("transfer.jsp").include(request, response);
    				out.println("<center><h3>Amount can't be zero or negative</h3></center>");
    			}
    			PreparedStatement ps2=Util.getConnection().prepareStatement("select * from register where username=?");
    			ps2.setString(1, usr);
    			ResultSet rs2=ps2.executeQuery();
    			double bal1=0.0;
    			if(rs2.next())
    			{
    				bal1=rs2.getDouble(7)-amount;
    				PreparedStatement ps3=Util.getConnection().prepareStatement("update register set amt=? where username='"+usr+"'");
    				ps3.setDouble(1, bal1);
    				ps3.executeUpdate();
    				PreparedStatement ps5=Util.getConnection().prepareStatement("insert into transaction values (?,?,?,?,?)");
					ps5.setInt(1, rs2.getInt(1));
					ps5.setString(2, usr);
					ps5.setString(3, "debited");
					ps5.setDouble(4, amount);
					ps5.setDouble(5, bal1);
					ps5.executeUpdate();
    			}
    		}
    		else
    		{
    			request.getRequestDispatcher("transfer.jsp").include(request, response);
				out.println("<center><h3>Target account does'nt exist</h3></center>");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
