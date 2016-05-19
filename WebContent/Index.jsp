<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<title>Index CRM</title>
</head>
<body>
	<div class="container">
		<h2>Buscadores</h2>
		<div class="panel">
			<table class="table table-responsive">	
				<tr>		  				
					<td>
						<a href="FormSearchSimple.jsp" class="btn btn-primary">Busqueda Simple</a>
					</td>
	  				<td>
						<a href="FormSearchAdvance.jsp" class="btn btn-primary">Busqueda Avanzada</a>
	  				</td>	  			
	  			</tr>
		  	</table>
		</div>
		<hr>
		<h2>Personas</h2>
		<div class="panel">
			<table class="table table-responsive">	
				<tr>
					<td>
			  			<a href="FormAddPersona.jsp" class="btn btn-success">Agregar Persona</a>
	  				</td>
	  				<!-- 
	  				<td>
			  			<a href="FormEditPersona.jsp" class="btn btn-warning">Editar Persona</a>
	  				</td>
	  				<td>
			  			<a href="FormDelPersona.jsp" class="btn btn-danger">Eliminar Persona</a>
	  				</td>
	  				 -->			  				
					<td>
						<form action="ListPersonaServlet" method="post">
							<input type="submit" value="Lista de Personas" class="btn btn-info">
						</form>
	  				</td>	  			
	  			</tr>
		  	</table>
		</div>
		<hr>
		<h2>Empresa</h2>
		<div class="panel">
			<table class="table table-responsive">	
				<tr>
					<td>
			  			<a href="FormAddEmpresa.jsp" class="btn btn-success">Agregar Empresa</a>
	  				</td>
	  				<!--  
	  				<td>
			  			<a href="FormEditEmpresa.jsp" class="btn btn-warning">Editar Empresa</a>
	  				</td>
	  				<td>
			  			<a href="FormDelEmpresa.jsp" class="btn btn-danger">Eliminar Empresa</a>
	  				</td>
	  				-->			  				
					<td>
						<form action="ListEmpresaServlet" method="post">
							<input type="submit" value="Lista de Empresa" class="btn btn-info">
						</form>
	  				</td>	  			
	  			</tr>
		  	</table>
		</div>
		<hr>		
	</div>
</body>
</html>