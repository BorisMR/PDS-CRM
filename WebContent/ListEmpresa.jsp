<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Lista</title>
</head>
<body>
	<h2><b>Lista de Empresas</b><br></h2>
	<hr>
	<h3>${ListEmpresaStatus}</h3>
	<h3>${DelEmpresaStatus}</h3>
	<hr>
	<a href="Index.jsp" class="btn btn-primary">Volver</a>
	<hr>
	<table class="table table-bordered table-hover table-responsive">
	<tr class="info">
		<th>Rut</th>
		<th>Nombre</th>
	</tr>
	<i:forEach items="${listaEmpresas}" var="empresa">
		<tr>
			<td>${empresa.rut}</td>
			<td>${empresa.nombre}</td>
			<td>
				<table>
					<tr>
						<td>
							<form action="EditEmpresaMiddleServlet" method="post">
								<input type="hidden" value="${empresa.idE}" name="idE">
								<input type="hidden" value="${empresa.rut}" name="rut">
								<input type="hidden" value="${empresa.nombre}" name="nombre">
								<input type="submit" value="Editar" class="btn btn-warning">	
							</form>
						</td>
						<td>
							<form action="DelEmpresaBTNServlet" method="post">
								<input type="hidden" value="${empresa.idE}" name="idE">
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