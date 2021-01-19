package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOut extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		PrintWriter out=res.getWriter();
		HttpSession ses=req.getSession();
		ses.setAttribute("username", null);
		out.println("Logged Out Successfully");
		ses.invalidate();
	}
}
