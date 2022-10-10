package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.service.Util;
@WebServlet("/Invoice")
public class Invoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			response.setContentType("text/html"); 
			HttpSession session=request.getSession();
    		session.getAttribute("info");
    		String usr=(String)session.getAttribute("info");
    		session.getAttribute("mob");
    		String mob=(String)session.getAttribute("mob");
    		session.getAttribute("mob");
    		String operator=(String)session.getAttribute("operator");
    		session.getAttribute("state");
    		String state=(String)session.getAttribute("state");
    		session.getAttribute("amt");
    		String amt=(String)session.getAttribute("amt");
    		
    		Statement stmt=Util.getConnection().createStatement();
    		String sql="select * from register where username='"+usr+"'";
    		ResultSet rs=stmt.executeQuery(sql);
    		while(rs.next())
    		{
				Document document=new Document();
				PdfWriter.getInstance(document, new FileOutputStream("Documents/workspace-spring-tool-suite-4-4.15.1.RELEASE/BankingApplication/src/main/invoice.pdf"));
			    					
				document.open();
				document.add(new Chunk(""));
				
				Paragraph p=new Paragraph();    				   
				p.add("Invoice\n");
				p.add("============================\n");
				p.add("Name : "+rs.getString(2)+"\n");
				p.add("Mobile : "+mob+"\n");
				p.add("Operator : "+operator+"\n");
				p.add("State : "+state+"\n");
				p.add("Recharge Amount : "+amt+"\n");
				//p.add("Balance : "+bal+"\n");
				document.add(Chunk.NEWLINE);
				document.add(Chunk.NEWLINE);
				p.add("Recharge Successful"+"\n");
				p.setAlignment(Element.ALIGN_CENTER);
				document.add(p);
				document.close();
								
				String filePath="Documents/workspace-spring-tool-suite-4-4.15.1.RELEASE/BankingApplication/src/main/invoice.pdf";
	    		File downloadFile=new File(filePath);
	    		FileInputStream inStream=new FileInputStream(downloadFile);
	    		ServletContext context=getServletContext();
	    		String mimeType=context.getMimeType(filePath);
	    		if(mimeType==null)
	    		{
	    			mimeType="application/octet-stream";
	    		}
	    		
	    		response.setContentType(mimeType);
	    		response.setContentLength((int) downloadFile.length());
	    		String headerKey="Content-Disposition";
	    		String headerValue=String.format("attachment; filename=\"%s\"", downloadFile.getName());
	    		response.setHeader(headerKey, headerValue);	    		
	    		OutputStream outStream=response.getOutputStream();	    		
	    		byte[] buffer=new byte[4096];
	    		int bytesRead=-1;
	    		while((bytesRead=inStream.read(buffer))!=-1)
	    		{
	    			outStream.write(buffer,0,bytesRead);
	    		}
	    		inStream.close();
	    		outStream.close();
				System.out.println("Done");
    		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
