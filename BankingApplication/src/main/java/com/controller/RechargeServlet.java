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

@WebServlet("/RechargeServlet")
public class RechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try
    	{
    		response.setContentType("text/html"); 
       	    PrintWriter out=response.getWriter();     		        
    	    out.print("<center><h1>Mobile Recharge</h1></center>");   
    	    out.print("<p style='text-align:right'><a href='dashboard.jsp'>Go back to dashboard</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='Invoice'>Print</a></p>");
    	    String price=request.getParameter("price");      		        
    	    int amt=Integer.parseInt(price);  
       		        
    	    HttpSession session=request.getSession();
    	    session.setAttribute("amt", price);
    		session.getAttribute("info");
    		String usr=(String)session.getAttribute("info");
    		session.getAttribute("mob");
    		String mob=(String)session.getAttribute("mob");
    		session.getAttribute("mob");
    		String operator=(String)session.getAttribute("operator");
    		session.getAttribute("state");
    		String state=(String)session.getAttribute("state");
    				
    		User u1=new User();
    	    Statement stmt=Util.getConnection().createStatement();
    		String sql="select * from register where username='"+usr+"'";
    		ResultSet rs=stmt.executeQuery(sql);
    		int bal=0;
    		while(rs.next()) {
    			u1.setAmount(rs.getDouble(7));
    			if(u1.getAmount()>amt)
    			{
    				bal=(int) (u1.getAmount()-amt);
    				if(bal<=100.0)
    				{
    					out.println("<center><h3>Minimum balance of 100 should be maintained</h2></center>");
    				}
    				else
    				{
    					out.println("<center><h3>Name : "+rs.getString(2)+"</h3></center>");
    					out.println("<center><h3>Mobile No : "+mob+"</h3></center>");
    					out.println("<center><h3>Operator : "+operator+"</h3></center>");
    					out.println("<center><h3>State : "+state+"</h3></center>");
    					out.println("<center><h3>Recharge amount : "+amt+"</h3></center>");
   						out.println("<br><br>");
    					out.println("<center><h2 style='color:green'>Recharge successful</center></h2><br>");
    					out.println("<center><h3>Your balance is : "+bal+"</center></h2>");
    					PreparedStatement ps=Util.getConnection().prepareStatement("update register set amt=? where username='"+usr+"'");
    					ps.setDouble(1, bal);
    					ps.executeUpdate();
    					PreparedStatement ps1=Util.getConnection().prepareStatement("insert into transaction values (?,?,?,?,?)");
    					ps1.setInt(1, rs.getInt(1));
    					ps1.setString(2, usr);
    					ps1.setString(3, "debited");
    					ps1.setDouble(4, amt);
    					ps1.setDouble(5, bal);
    					ps1.executeUpdate();
    					
//    					Document document=new Document();
//    					PdfWriter.getInstance(document, new FileOutputStream("Documents/workspace-spring-tool-suite-4-4.15.1.RELEASE/BankingApplication/src/main/invoice.pdf"));
//    				    					
//    					document.open();
//    					document.add(new Chunk(""));
//    					
//    					Paragraph p=new Paragraph();    				   
//    					p.add("Invoice\n");
//    					p.add("============================\n");
//    					p.add("Name : "+rs.getString(2)+"\n");
//      				p.add("Mobile : "+mob+"\n");
//      				p.add("Operator : "+operator+"\n");
//      				p.add("State : "+state+"\n");
//    					p.add("Recharge Amount : "+amt+"\n");
//    					p.add("Balance : "+bal+"\n");
//    					p.add("Recharge Successful"+"\n");
//    					p.setAlignment(Element.ALIGN_CENTER);
//    					document.add(p);
//       					document.close();
//    					System.out.println("Done");
    				}
    			}
    			else
    			{
    				out.println("<center><h3 style='color:Red'>Recharge Failed</h3></center>");
    			}
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}