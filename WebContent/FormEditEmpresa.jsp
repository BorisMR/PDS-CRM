<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"></link>
	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>    
    <script type="text/javascript" src="js/validator.js"></script>

	<title>Formulario</title>
</head>
<body>
	<h2><b>Editar Empresa</b></h2>
	<div class="container">
		<h3>Editar Datos de Empresa</h3>
		<hr>
		<h4>${EditEmpresaStatus}</h4>
		<hr>
		<form action="Index.jsp" method="post">
			<input type="submit" value="Menu" class="btn btn-primary">	
		</form>
		<hr>
		<form class="form-horizontal" action="EditEmpresaServlet" method="post" id="FormEditEmpresa">
	  		<div class="form-group">
	    		<label for="idE">ID:</label>
	    		<input type="text" class="form-control" id="idE" name="idE" value="${idE}" readonly>
	  		</div>
	  		<div class="form-group">
	    		<label for="rut">Rut:</label>
	    		<input type="text" class="form-control" id="rut" name="rut" value="${rut}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="nombre">Nombre:</label>
	    		<input type="text" class="form-control" id="nombre" name="nombre" value="${nombre}" required>
	  		</div>
	  		<button type="submit" class="btn btn-warning" value="Editar">Editar</button>
		</form>		
	</div>
</body>
</html>