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
	<link rel="stylesheet" href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"></link>
	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>    
    <script type="text/javascript" src="js/validator.js"></script>

	<title>Formulario</title>
</head>
<body>
	<h2><b>Agregar Empresa</b></h2>
	<div class="container">
		<h3>Ingresar Datos Empresa</h3>
		<hr>
		<h4>${AddEmpresaStatus}</h4>
		<hr>
		<form class="form-horizontal" action="AddEmpresaServlet" method="post" id="FormAddEmpresa">
	  		<div class="form-group">
	    		<label for="rut">Rut:</label>
	    		<input type="text" class="form-control" id="rut" name="rut" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="nombre">Nombre:</label>
	    		<input type="text" class="form-control" id="nombre" name="nombre" required>
	  		</div>
	  		<button type="submit" class="btn btn-success" value="Agregar">Agregar</button>
		</form>
		<hr>
		<a href="Index.jsp" class="btn btn-primary">Volver</a>
	</div>
</body>
</html>