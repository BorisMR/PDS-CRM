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
	<title>Busqueda</title>
</head>
<body>
	<h2><b>Busqueda Avanzada</b></h2>
	
	<div class="container">
		<h3>Ingresar Datos Persona</h3>
		<form class="form-horizontal" action="SearchAdvanceServlet" method="post">
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
	    		<input type="text" class="form-control" id="genero" name="genero">
	    		<!--  
				<select class="form-control" id="genero" required>
					<option value="m">M</option>
					<option value="f">F</option>
				</select>
				-->
	  		</div>
	  		<button type="submit" class="btn btn-success" value="Buscar">Buscar</button>
		</form>
		<h3>${SearchAdvanceStatus}</h3>
	</div>	
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
			<td>
				<table>
					<tr>
						<td>
							<form action="FormEditPersona.jsp" method="post">
								<input type="hidden" value="${persona.idP}" name="idP">
								<input type="submit" value="Editar" class="btn btn-warning">	
							</form>
						</td>
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
</body>
</html>