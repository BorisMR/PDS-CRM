<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Registro de Personas</title>
</head>
<body>
<h1>Registro de Personas</h1>
<table class="table table-bordered table-hover table-responsive">
	<tr>
		<th>Run</th>
		<th>Nombre</th>
		<th>Apellido</th>
		<th>E-mail</th>
		<th>Telefono</th>
		<th>Direccion</th>
		<th>Genero</th>		
	</tr>
	
	<c:forEach items="${listaPersonasJSP}" var="persona">
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
						<form action="EditPersonaServlet.jsp" method="post">
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