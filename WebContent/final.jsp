<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<form method="post" action="/Upload/logout">
    <input type="submit" value="Logout"/>
	</form>
	</div>
</body>
</html>