<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Persona" %>
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
    <script type="text/javascript" src="js/image.js"></script>

	<title>Editar Contacto</title>
</head>
<body>
	<h2><b>Editar Persona</b></h2>
	<div class="container">
		<h3>Formulario de Datos de la Persona</h3>
		<hr>
			<h3>${EditPersonaStatus}</h3>
		<hr>
		<form action="Index.jsp" method="post">
			<input type="submit" value="Menu" class="btn btn-primary">	
		</form>
		<hr>
		<form class="form-horizontal" action="EditPersonaServlet" method="post">
	  		<div class="form-group">
	    		<label for="run">ID:</label>
	    		<input type="text" class="form-control" id="idP" name="idP" value="${idP}" readonly>
	  		</div>
	  		<div class="form-group">
	    		<label for="run">Run:</label>
	    		<input type="text" class="form-control" id="run" name="run" value="${run}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="nombre">Nombre:</label>
	    		<input type="text" class="form-control" id="nombre" name="nombre" value="${nombre}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="apellido">Apellido:</label>
	    		<input type="text" class="form-control" id="apellido" name="apellido" value="${apellido}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="email">eMail:</label>
	    		<input type="email" class="form-control" id="email" name="email" value="${email}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="telefono">Telefono:</label>
	    		<input type="number" class="form-control" id="fono" name="fono" value="${fono}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="direccion">Dirección:</label>
	    		<input type="text" class="form-control" id="direccion" name="direccion" value="${direccion}" required>
	  		</div>
	  		<div class="form-group">
		  		<label for="genero">Genero:</label>
		  		<div class="radio">		  			
		  			<label>
						<input type="radio" name="genero" id="m" value="m">
					  	Masculino
					</label>
		  		</div>
		  		<div class="radio">
		  			<label>
						<input type="radio" name="genero" id="f" value="f">
					  	Femenino
					</label>
		  		</div>
	  		</div>
	  		<div class="form-group" >
	  			<label for="foto">Foto Contacto:</label>
	  			<div class="form-group" id="imgContainer"><img src="${foto_b64}" class="img-responsive"></img></div>
	  			<input id="inputImagen" name="inputImagen" type="file" multiple accept='image/*' onchange="encodeImage();" value="${foto_b64}"/>
	  			<textarea id="textArea" name="textArea" class="form-control textbox" style="display:none;">${foto_b64}</textarea>
	  		</div>	  		 
	  		<!-- Select viene desde servlet -->
	  		${LISTA} 
	  		<button type="submit" class="btn btn-warning" value="Editar">Editar</button>
		</form>
		<hr>
		
	</div>
</body>
</html>