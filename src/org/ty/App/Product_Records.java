package org.ty.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class Product_Records extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) 
			throws ServletException, IOException {
		String number=req.getParameter("pn");
		int pno=Integer.parseInt(number);
		String name=req.getParameter("nm");
		String price=req.getParameter("pp");
		int pprice=Integer.parseInt(price);
		String quantity=req.getParameter("pq");
		int pqty=Integer.parseInt(quantity);
		PrintWriter out=resp.getWriter();
		out.print("<html><body bgcolor='orange'><h1>Details are:-> "+pno+" "+name+" "+pprice+" "+pqty+" </h1></body></html> ");
		
		String inQry="insert into product.proddetails values(?,?,?,?)";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			PreparedStatement pstmt=con.prepareStatement(inQry);
			pstmt.setInt(1, pno);
			pstmt.setString(2, name);
			pstmt.setInt(3, pprice);
			pstmt.setInt(4, pqty);
			pstmt.executeUpdate();
			System.out.println("inserted product details succesfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
