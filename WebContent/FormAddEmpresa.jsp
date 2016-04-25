<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Agregar</title>
</head>
<body>
	<h2><b>Agregar Empresa</b></h2>
	<div class="container">
		<h3>Ingresar Datos Empresa</h3>
		<form class="form-horizontal" action="AddEmpresaServlet" method="post">
	  		<div class="form-group">
	    		<label for="rut">Rut:</label>
	    		<input type="text" class="form-control" id="rut" name="rut" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="nombre">Nombre:</label>
	    		<input type="text" class="form-control" id="nombre" name="nombre" required>
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
	  		<button type="submit" class="btn btn-success" value="Agregar">Agregar</button>
		</form>
		<hr>
		<h3>${AddEmpresaStatus}</h3>
	</div>
</body>
</html>