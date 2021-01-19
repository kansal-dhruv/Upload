<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Logged Out</title>
</head>
<body>
<%
	session.setAttribute("username", null);
	session.invalidate();
%>
	Successfully Logged out. 
	<a href="./index.jsp">Home Page</a>
</body>
</html>