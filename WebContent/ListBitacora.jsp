<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Persona" %>
<%@ page import="business.Bitacora" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Lista entradas</title>
</head>
<body>
<div class="container">
	<h3><b>Registros en bitacora</b><br></h3>
	<hr>	
	<form action="Index.jsp" method="post">
		<input type="submit" value="Menu" class="btn btn-primary">	
	</form>
	<hr>
	<table class="table table-bordered table-hover table-responsive">
		<tr class="info">
			<th>Foto</th>
			<th>Run</th>
			<th>Nombre</th>
			<th>Apellido</th>			
		</tr>
		<tr>
			<td><img src="${persona.foto_b64}" class="img-responsive"></img></td>
			<td>${persona.run}</td>
			<td>${persona.nombre}</td>
			<td>${persona.apellido}</td>
		</tr>
	</table>
	<table class="table table-bordered table-hover table-responsive">
	<i:forEach items="${listaBitacoras}" var="bitacora">
		<tr class="success">
			<th>ID Reg: ${bitacora.idB}</th>		
		</tr>	
		<tr>
			<td>${bitacora.entrada}</td>			
		</tr>
	</i:forEach>
	</table>
</div>
</body>
</html>