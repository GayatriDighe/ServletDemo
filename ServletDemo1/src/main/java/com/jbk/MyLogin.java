package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


	@WebServlet("/signout")
	public class MyLogin extends HttpServlet{

	        @Override
	        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	                System.out.println("successfully signin...! ");

	            String name=req.getParameter("name1");
	            String passw=req.getParameter("pass1");


	            try {
	                        Class.forName("com.mysql.cj.jdbc.Driver");
	                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher?useSSL=false","root","G@yatri123!");
	                        PreparedStatement ps=c.prepareStatement("select * from logininfo where username=? and password=?");
	                        		
	                        ps.setString(1,name);
	                        ps.setString(2,passw);
	                        ResultSet rs = ps.executeQuery();
	                      
	                        if(rs.next()) {
	                        	System.out.println("login successful");

	                            PrintWriter out = resp.getWriter();
	                            out.print("successfully login....");
	                        }else {
	                        	  PrintWriter out = resp.getWriter();
	                        	  out.print("usename and password did not matched...***");
	                        }
	                        c.close();
	            } catch (Exception e) {


	                    e.printStackTrace();
	            }




}
	}
	
