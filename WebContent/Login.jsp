<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Agregar Usuario</title>
</head>
<body>
	<div class="container">
	<h3>Login</h3>
		<form class="form-horizontal" action="LoginServlet" method="post">
			User ID:<input class="form-control" type="text" name="user" required/><br/>
			Password:<input class="form-control" type="password" name="pass" required/><br/>
			<button type="submit" class="btn btn-default" value="login">Entrar</button>
		</form>
		<h3>${LoginStatus}</h3>
	</div>
</body>
</html>