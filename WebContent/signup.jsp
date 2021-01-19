<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<title>Sign Up</title>
<head>
  <link rel="stylesheet" href="./styles.css">
</head>
<body>
	<% if(session.getAttribute("username")!=null)
	{
		response.sendRedirect("final.jsp");
	}
	%>
	<div class="login">
		<div class="heading">
			Sign Up
		</div>
		<div class="form">
			<form action="signup" method="post">
				<div class="form-row">
					<label> Email ID: </label>
					<input type="email" name="email" required>
				</div>	
				<div class="form-row">
					<label> Password : </label>
					<input type="password" name="password" required>
				</div>
				<div class="form-row">
					<button type="submit">Submit</button>
				</div>
			</form>
		</div>
		<br>
		<div class="form-row">
		<a href="./index.jsp">Already have an Account?</a>
		</div>
	</div>
</body>
</html>	