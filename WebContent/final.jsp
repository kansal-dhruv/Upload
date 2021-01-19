<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<% if(session.getAttribute("username")==null)
	{
		response.sendRedirect("index.jsp");
	}
	%>
	<div>
		Hello <% out.print(session.getAttribute("username")); %>, Welcome to Front Page	
	</div>
	<div>
	<form method="post" action="/Upload/logout.jsp">
    <input type="submit" value="Logout"/>
	</form>
	</div>
	
	<form action="upload" method="post" enctype="multipart/form-data">
		<label>Select Your file: </label>
		<input type="file" name="file">
		<button type="submit">Submit</button>
	</form>
	
	<%
		String path="C:\\Users\\dhruv.kansal\\servlets-test\\Upload\\Files\\";
		path=path+session.getAttribute("username");
		File dir=new File(path);
		for(String s:dir.list()){ %>
			<a href=<%= path %><%= s %>><%= s %></a>
		<%}
		%>
</body>
</html>