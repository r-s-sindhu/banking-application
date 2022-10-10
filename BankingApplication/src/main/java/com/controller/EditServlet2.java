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

@WebServlet("/EditServlet2")
public class EditServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
    		response.setContentType("text/html");
    		PrintWriter out=response.getWriter();
    		String acc=request.getParameter("accno");
    		int accno=Integer.parseInt(acc);
    		String name=request.getParameter("username");
    		String pwd=request.getParameter("pwd");
    		String phno=request.getParameter("phno");
    		String addr=request.getParameter("add");
    		String email=request.getParameter("email");
    		String acctype=request.getParameter("acc type");
    				
    		User u1=new User();
    		u1.setAccno(accno);
    		u1.setUsername(name);
    		u1.setPassword(pwd);
    		u1.setPhno(phno);
    		u1.setAddress(addr);
    		u1.setEmail(email);
    		u1.setAcctype(acctype);
    		
    		int status=UserDao.update(u1);  
            if(status>0){  
                out.println("<center><h2>Record updated successfully</h2></center>");  
                out.println("<center><a href='dashboard.jsp'>Go back to dashboard</a></center>");
            }else{  
                out.println("<center><h2>Sorry! unable to update record</h2></center>");  
            }           
            out.close(); 
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}
}
