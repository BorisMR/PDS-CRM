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
	<link rel="stylesheet" href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"></link>
	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>    
    <script type="text/javascript" src="js/validator.js"></script>
    
	<title>Busqueda Simple</title>
</head>
<body>
	<h2><b>Busqueda Simple de Contacto</b></h2>
	
	<form class="form-horizontal" action="SearchSimpleServlet" method="post" id="FormSearchSimple">
		Buscar:<input class="form-control" type="text" name="busqueda"/><br/>
		<button type="submit" class="btn btn-success">buscar</button>
	</form>
	<h3>${SearchSimpleStatus}</h3>
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
			<td><img src="${persona.foto_b64}" class="img-responsive"></img></td>
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