<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
	
	<i:forEach items="${listaPersonasJSP}" var="listaP">
	<tr>
		<td>${listaP.run}</td>
		<td>${listaP.nombre}</td>
		<td>${listaP.apellido}</td>
		<td>${listaP.email}</td>
		<td>${listaP.fono}</td>
		<td>${listaP.direccion}</td>
		<td>${listaP.genero}</td>
		<td>
			<table>
				<tr>
					<td>
						<form action="EditPersonaServlet.jsp" method="post">
							<input type="hidden" value="${listaP.idP}" name="idP">
							<input type="submit" value="Editar" class="btn btn-primary">	
						</form>
					</td>
					<td>
						<form action="DelPersonaServlet" method="post">
							<input type="hidden" value="${listaP.idP}" name="idP">
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