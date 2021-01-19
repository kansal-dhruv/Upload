<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Invalid Credentials</title>
</head>
<body>
	<% if(session.getAttribute("username")!=null)
	{
		response.sendRedirect("final.jsp");
	}
	%>
	Invalid Credentials! <a href="./index.jsp">Please Try Again</a>
</body>
</html>