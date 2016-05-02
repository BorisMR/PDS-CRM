<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
<!DOCTYPE html">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Lista</title>
</head>
<body>
	<h2><b>Lista de Empresas</b><br></h2>
	
	<h3>${ListEmpresaStatus}</h3>
	<hr>
	
	<table class="table table-bordered table-hover table-responsive">
	<tr class="info">
		<th>Rut</th>
		<th>Nombre</th>
		<th>E-mail</th>
		<th>Telefono</th>
		<th>Dirección</th>
	</tr>
	<i:forEach items="${listaEmpresas}" var="empresa">
		<tr>
			<td>${empresa.rut}</td>
			<td>${empresa.nombre}</td>
			<td>${empresa.email}</td>
			<td>${empresa.fono}</td>
			<td>${empresa.direccion}</td>
			<td>
				<table>
					<tr>
						<!-- 
						<td>
							<form action="FormEditEmpresa.jsp" method="post">
								<input type="hidden" value="${empresa.idE}" name="idE">
								<input type="submit" value="Editar" class="btn btn-warning">	
							</form>
						</td>
						-->
						<td>
							<form action="DelEmpresaServlet" method="post">
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