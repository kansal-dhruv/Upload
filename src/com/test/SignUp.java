package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/signup")
public class SignUp extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException{
		PrintWriter out=res.getWriter();
		HttpSession ses=req.getSession();
		if(ses.getAttribute("username")!=null)
		{
			res.sendRedirect("/Upload/final.jsp");
		}
		else {
			if(req.getParameter("email").length()!=0 && req.getParameter("password").length()!=0)
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
					if(rs.next() && rs.getString(1).equals(req.getParameter("email")))
					{	
						out.println("Account Already Exists\n");
					}
					else {
					String qry="insert into users values("+"'"+req.getParameter("email")+"'" +","+"'"+req.getParameter("password")+"')";
					System.out.println(qry);
					stmt.executeUpdate(qry);
					res.sendRedirect("/Upload/index.jsp");
					}
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			else {
				System.out.println("Cannot be empty");
				try {
					res.sendRedirect("./unsuccessful.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
