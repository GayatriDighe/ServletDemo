package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signin")
public class MySignin  extends HttpServlet{

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

                System.out.println("successfully signin...! ");

            String name=req.getParameter("name1");
            String passw=req.getParameter("pass1");


            try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/teacher","root","G@yatri123!");
                        PreparedStatement ps=c.prepareStatement("insert into logininfo values(?,?)");
                        ps.setString(1,"gauri");
                        ps.setString(2,"gauri@123");
                        ps.executeUpdate();
                        System.out.println("successfully insert record...");


            } catch (Exception e) {


                    e.printStackTrace();
            }



//      System.out.println("USERNAME ="+name);
//      System.out.println("PASSWORD ="+passw);


            PrintWriter out = resp.getWriter();
            out.print("successfully signin...");
//          
//          out.print("USERNAME ="+name);
//          out.print("PASSWORD ="+passw);
    }


    }


