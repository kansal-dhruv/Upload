package com.test;

import java.io.IOException;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession ses=req.getSession();
		if(ses.getAttribute("username")!=null)
		{
			res.sendRedirect("/Upload/final.jsp");
		}
		else
		{
			if(req.getParameter("email")!=null && req.getParameter("password")!=null)
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/testlogin";
					String username="root";
					String password="UIq123sewduity";
					Connection con=DriverManager.getConnection(
							url,username,password);
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select * from users where email="+"'"+req.getParameter("email")+"'");
					rs.next();
					if(rs.getString(2).equals(req.getParameter("password")))
					{	
						System.out.println("Login Succesfull");
						ses.setAttribute("username", req.getParameter("email"));
						res.sendRedirect("/Upload/final.jsp");
					}
					else {
						System.out.println("Invalid Credentials");
						try {
							res.sendRedirect("./unsuccessful.jsp");
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else {
				System.out.println("Cannot be empty");
				try {
					res.sendRedirect("./unsuccessful.jsp");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

