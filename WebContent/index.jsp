<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Login</title>
<head>
  <link rel="stylesheet" href="./styles.css">
</head>
<body>
	<% 
		if(session.getAttribute("username")!=null)
			response.sendRedirect("/Upload/final.jsp");
	%>
	<div class="login">
		<div class="heading">
			Login
		</div>
		<div class="form">
			<form action="login" method="post">
				<div class="form-row">
					<label> Email ID : </label>
					<input type="email" name="email">
				</div>
				<div class="form-row">
					<label> Password : </label>
					<input type="password" name="password">
				</div>	
				<div class="form-row"	>
					<button type="submit">Submit</button>
				</div>
			</form>
		</div>
		<br>
		<div class="form-row">
		<a href="./signup.jsp">A New User?</a>
		</div>
	</div>
</body>
</html>	