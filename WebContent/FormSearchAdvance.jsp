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
	
    <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>    
    <script type="text/javascript" src="js/validator.js"></script>
    
	<title>Busqueda</title>
</head>
<body>
<div class="container">
	<h3><b>Busqueda Avanzada</b></h3>
	
	<div class="container">
		<h4>Datos de Contacto a buscar</h4>
		<form class="form-horizontal" action="SearchAdvanceServlet" method="post" id="FormSearchAdvance">
	  		<div class="form-group">
	    		<label for="run">Run:</label>
	    		<input type="text" class="form-control" id="run" name="run">
	  		</div>
	  		<div class="form-group">
	    		<label for="nombre">Nombre:</label>
	    		<input type="text" class="form-control" id="nombre" name="nombre">
	  		</div>
	  		<div class="form-group">
	    		<label for="apellido">Apellido:</label>
	    		<input type="text" class="form-control" id="apellido" name="apellido">
	  		</div>
	  		<div class="form-group">
	    		<label for="email">eMail:</label>
	    		<input type="email" class="form-control" id="email" name="email">
	  		</div>
	  		<div class="form-group">
	    		<label for="telefono">Telefono:</label>
	    		<input type="text" class="form-control" id="fono" name="fono">
	  		</div>
	  		<div class="form-group">
	    		<label for="direccion">Direccion:</label>
	    		<input type="text" class="form-control" id="direccion" name="direccion">
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
	  		<button type="submit" class="btn btn-success">Buscar</button>
		</form>
		<h3>${SearchAdvanceStatus}</h3>
	</div>	
	<hr>
	<a href="Index.jsp" class="btn btn-primary">Volver</a>
	<hr>
	<table class="table table-bordered table-hover table-responsive">
	<tr class="info">
		<th>Run</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>E-mail</th>
		<th>Telefono</th>
		<th>Direccion</th>
		<th>Genero</th>
		<th>Empresa</th>
		<th>Foto</th>
	</tr>
	<i:forEach items="${listaPersonas}" var="persona">
		<tr>
			<td>${persona.run}</td>
			<td>${persona.nombre}</td>
			<td>${persona.apellido}</td>
			<td>${persona.email}</td>
			<td>${persona.fono}</td>
			<td>${persona.direccion}</td>
			<td>${persona.genero}</td>
			<td>${persona.empresa.nombre}</td>
			<td><img src="${persona.foto_b64}" class="img-responsive"></img></td>
			<td>
				<table>
					<tr>
						<td>
							<form action="AddBitacoraMiddleServlet" method="post">
								<input type="hidden" value="${persona.idP}" name="idP">
								<input type="hidden" value="${persona.run}" name="run">
								<input type="hidden" value="${persona.nombre}" name="nombre">
								<input type="hidden" value="${persona.apellido}" name="apellido">
								<input type="submit" value="Bitacora" class="btn btn-success">	
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<form action="ListBitacoraServlet" method="post">
								<input type="hidden" value="${persona.idP}" name="idP">
								<input type="hidden" value="${persona.run}" name="run">
								<input type="hidden" value="${persona.nombre}" name="nombre">
								<input type="hidden" value="${persona.apellido}" name="apellido">
								<input type="submit" value="Bitacora Info" class="btn btn-info">	
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<form action="EditPersonaMiddleServlet" method="post">
								<input type="hidden" value="${persona.idP}" name="idP">
								<input type="hidden" value="${persona.run}" name="run">
								<input type="hidden" value="${persona.nombre}" name="nombre">
								<input type="hidden" value="${persona.apellido}" name="apellido">
								<input type="hidden" value="${persona.email}" name="email">
								<input type="hidden" value="${persona.fono}" name="fono">
								<input type="hidden" value="${persona.direccion}" name="direccion">
								<input type="hidden" value="${persona.genero}" name="genero">
								<input type="hidden" value="${persona.empresa.nombre}" name="empresanombre">
								<input type="hidden" value="${persona.foto_b64}" name="foto_b64">
								<input type="submit" value="Editar" class="btn btn-warning">	
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<form action="DelPersonaServlet" method="post">
								<input type="hidden" value="${persona.idP}" name="idP">
								<input type="submit" value="Eliminar" class="btn btn-danger">	
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</i:forEach>
	</table>
</div>
</body>
</html>