<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<title>Ingreso</title>
</head>
<body>
	<div class="container">
		<h3>Ingresar Usuario</h3>
		<form role="form" action="AddUsuarioServlet" method="post" class="form-horizontal" >
	  		<div class="form-group">
	    		<label for="nombre">Usuario:</label>
	    		<input type="text" class="form-control" id="user" name="user" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="password">Password:</label>
	    		<input type="password" class="form-control" id="pass" name="pass" required>
	  		</div>
	  		<button type="submit" class="btn btn-default" value="enviar">Submit</button>
		</form>
	</div>	
</body>
</html>