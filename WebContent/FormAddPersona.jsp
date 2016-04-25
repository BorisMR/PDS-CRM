<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Agregar Persona</title>
</head>
<body>
	<div class="container">
		<h3>Ingresar Persona</h3>
		<form role="form" action="addPersonaServlet" method="post" class="form-horizontal" >
	  		<div class="form-group">
	    		<label for="run">Run:</label>
	    		<input type="text" class="form-control" id="run" name="run" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="nombre">Nombre:</label>
	    		<input type="text" class="form-control" id="nombre" name="nombre" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="apellido">Apellido:</label>
	    		<input type="text" class="form-control" id="apellido" name="apellido" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="email">eMail:</label>
	    		<input type="email" class="form-control" id="email" name="email" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="telefono">Telefono:</label>
	    		<input type="text" class="form-control" id="fono" name="fono" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="direccion">Direccion:</label>
	    		<input type="text" class="form-control" id="direccion" name="direccion" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="genero">Genero:</label>
	    		<input type="text" class="form-control" id="genero" name="genero" required>
	    		<!--  
				<select class="form-control" id="genero" required>
					<option value="m">M</option>
					<option value="f">F</option>
				</select>
				-->
	  		</div>
	  		<button type="submit" class="btn btn-default" value="enviar">Agregar</button>
		</form>
	</div>	
</body>
</html>