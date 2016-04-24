<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.*" %>
<%@page import="business.Persona" %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Busquedas</title>
</head>
<body>
	<h2><b>Busqueda Simple</b></h2>
	
	<form class="form-horizontal" action="SearchSimpleServlet" method="post">
		Buscar:<input class="form-control" type="text" name="user" required/><br/>
		<button type="submit" class="btn btn-default" value="buscar">buscar</button>
	</form>
	
	<table class="table table-bordered table-hover table-responsive">
	<tr class="success">
		<th>Run</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>E-mail</th>
		<th>Telefono</th>
		<th>Direccion</th>
		<th>Genero</th>
	</tr>
	
	<c:forEach items="${listaPersonas}" var="persona">
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
					<td><form action="EditPersonaServlet.jsp" method="post">
						<input type="hidden" value="${persona.idP}" name="idP">
						<input type="submit" value="Editar" class="btn btn-primary">	
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
	</c:forEach>
	</table>
</body>
</html>