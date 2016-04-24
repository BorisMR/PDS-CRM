<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Login</title>
</head>
<body>
	<div class="container">
	<h3>Ingrese a la plataforma</h3>
		<form class="form-horizontal" action="LoginServlet" method="post">
			User ID:<input class="form-control" type="text" name="user" placeholder="Ingrese su Usuario" required/><br/>
			Password:<input class="form-control" type="password" name="pass" placeholder="Ingrese su password" required/><br/>
			<button type="submit" class="btn btn-success" value="login">Entrar</button>
		</form>
		
		<h3>${LoginStatus}</h3>	
		
	</div>
</body>
</html>