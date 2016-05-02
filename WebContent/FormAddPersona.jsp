<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Persona" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Agregar</title>
</head>
<body>
	<h2><b>Agregar Persona</b></h2>
	<div class="container">
		<h3>Ingresar Datos Persona</h3>
		<hr>
			<h3>${AddPersonaStatus}</h3>
		<hr>
		<form class="form-horizontal" action="AddPersonaServlet" method="post">
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
	    		<input type="number" class="form-control" id="fono" name="fono" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="direccion">Dirección:</label>
	    		<input type="text" class="form-control" id="direccion" name="direccion" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="genero">Genero:</label>
	    		<input type="text" class="form-control" id="genero" name="genero" required>
	  		</div>
	  		<!--  
	  		<div class="form-group">
				<label class="col-lg-3 control-label">Seleccione Genero</label>
				<div class="col-lg-3">
		    	<select name="genero">
		 		 	<option value=m>M</option>
	 		 	 	<option value=f>F</option>
			 	</select>
		    	</div>
			</div>
				-->	   		
	  		<div class="form-group">
	    		<label for="id">Empresa ID:</label>
	    		<input type="text" class="form-control" id="empresaIde" name="empresaIde" required>
	  		</div>	  		 		
	  		<button type="submit" class="btn btn-success" value="Agregar">Agregar</button>
		</form>
	</div>
</body>
</html>