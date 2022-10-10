package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
//import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.service.Util;
@WebServlet("/TransactionHistory")
public class TransactionHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try 
		{
			response.setContentType("text/html");
			HttpSession session=request.getSession();
			session.getAttribute("info");
			String usr=(String)session.getAttribute("info");
			Statement stmt=Util.getConnection().createStatement();
			String sql="select * from transaction where username='"+usr+"'";
			ResultSet rs=stmt.executeQuery(sql);
			Document document=new Document();
    		PdfWriter.getInstance(document, new FileOutputStream("Documents/workspace-spring-tool-suite-4-4.15.1.RELEASE/BankingApplication/src/main/transaction.pdf"));
    		document.open();
    		Paragraph p=new Paragraph();
    		p.add("Transaction History");
    		p.setAlignment(Element.ALIGN_CENTER);
    		document.add(p);
    		document.add(Chunk.NEWLINE);
    		document.add(Chunk.NEWLINE);
    		PdfPTable table=new PdfPTable(new float[] {5,15,15,15});
    		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    		table.addCell("Accno");
    		table.addCell("Status");
    		table.addCell("Amount");
    		table.addCell("Balance");
    		
    		table.setHeaderRows(1);
    		PdfPCell[] cells=table.getRow(0).getCells();
    		for(int j=0;j<cells.length;j++)
    		{
    			cells[j].setBackgroundColor(BaseColor.GRAY);
    		}    		
    		while(rs.next())
    		{
    			table.addCell(String.valueOf(rs.getInt(1)));
    			table.addCell(rs.getString(3));
    			table.addCell(String.valueOf(rs.getDouble(4)));
    			table.addCell(String.valueOf(rs.getDouble(5)));
    		}
    		document.add(table);
    		document.close();
    		
    		String filePath="Documents/workspace-spring-tool-suite-4-4.15.1.RELEASE/BankingApplication/src/main/transaction.pdf";
    		File downloadFile=new File(filePath);
    		FileInputStream inStream=new FileInputStream(downloadFile);
    		//String relativePath=getServletContext().getRealPath("");
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
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
