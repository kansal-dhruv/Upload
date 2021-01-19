package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC_test {
	public static void main(String[] args)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/testlogin";
			String username="root";
			String password="UIq123sewduity";
			Connection con=DriverManager.getConnection(
					url,username,password);
			Statement stmt=con.createStatement();
//			stmt.executeUpdate("insert into test values('rahul',9147236585,25)");
			ResultSet rs=stmt.executeQuery("select * from users");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+ " " + rs.getString(2));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
