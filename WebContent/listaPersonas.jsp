<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Personas</title>
</head>
<body>
<h1>Registro de Personas</h1>
<table class="table table-bordered table-hover table-responsive">
	<tr class="success">
		<th>RUN</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>E-mail</th>
		<th>Telefono</th>
		<th>Direccion</th>
		<th>Genero</th>		
	</tr>
	
<i:forEach items="${listaPersonasJSP}" var="listaP">
	<tr>
		<td>${contacto.run}</td>
		<td>${contacto.nombre}</td>
		<td>${contacto.apellido}</td>
		<td>${contacto.email}</td>
		<td>${contacto.fono}</td>
		<td>${contacto.direccion}</td>
		<td>${contacto.genero}</td>
		<td>
			<table>
				<tr>
					<td><form action="UpdateContact.jsp" method="get">
						<input type="hidden" value="${contacto.id}" name="id">
						<input type="submit" value="Editar" class="btn btn-default">	
					</form>
					</td>
					<td>
					<form action="DeleteContact" method="get">
						<input type="hidden" value="${contacto.id}" name="id">
						<input type="submit" value="Eliminar" class="btn btn-default">	
					</form>
					</td>
				</tr>
			</table>
			
		</td>
		
	</tr>
</i:forEach>
</table>
<center><a href="index.html" class="btn btn-default"><img src="volver.png">Volver</a></center>
</body>
</html>