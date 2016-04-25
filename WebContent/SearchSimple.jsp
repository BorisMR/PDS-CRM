<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Persona" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Busqueda</title>
</head>
<body>
	<h2><b>Busqueda Simple</b></h2>
	
	<form class="form-horizontal" action="SearchSimpleServlet" method="post">
		Buscar:<input class="form-control" type="text" name="busqueda"/><br/>
		<button type="submit" class="btn btn-success">buscar</button>
	</form>
	<h3>${SearchSimpleStatus}</h3>
	
	<table class="table table-bordered table-hover table-responsive">
	<tr class="info">
		<th>Run</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>E-mail</th>
		<th>Telefono</th>
		<th>Direccion</th>
		<th>Genero</th>
		<th>Acciones</th>
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