<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Login</title>
</head>
<body>
	<div class="container">
		<h2>Ingrese a la plataforma</h2>
		<hr>	
		<form class="form-inline" action="LoginServlet" method="post" role="form">
			<div class="form-group">
				 <label class="sr-only" for="usser">Usuario</label>
				 <input class="form-control" type="text" id="user" name="user" placeholder="Introduce tu Usuario" required>
			</div>
			<div class="form-group">
				 <label class="sr-only" for="password">Password</label>
				 <input class="form-control" type="password" id="pass" name="pass" placeholder="Introduce tu Password" required>
			</div>				
			
			<button type="submit" class="btn btn-success" value="login">Entrar</button>
		</form>		
		<h4 class="text-warning">${LoginStatus}</h4>		
	</div>
</body>
</html>