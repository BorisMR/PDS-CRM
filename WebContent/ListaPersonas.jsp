<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


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
						<input type="hidden" value="${contacto.idP}" name="idP">
						<input type="submit" value="Editar" class="btn btn-primary">	
					</form>
					</td>
					<td>
					<form action="DelPersonaServlet" method="post">
						<input type="hidden" value="${contacto.idP}" name="idP">
						<input type="submit" value="Eliminar" class="btn btn-danger">	
					</form>
					</td>
				</tr>
			</table>
			
		</td>
		
	</tr>
</i:forEach>
</table>
<center><a href="index.html" class="btn btn-default">Volver</a></center>
</body>
</html>