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
		<h2>Personas</h2>
		<div class="panel">
			<table class="table table-responsive">	
				<tr>
					<td>
			  			<a href="FormAddPersona.jsp" class="btn btn-success">Agregar Persona</a>
	  				</td>
	  				<td>
			  			<a href="FormEditPersona.jsp" class="btn btn-warning">Editar Persona</a>
	  				</td>
	  				<td>
			  			<a href="FormDelPersona.jsp" class="btn btn-danger">Eliminar Persona</a>
	  				</td>			  				
					<td>
						<form action="ListPersonaServlet" method="post">
							<input type="submit" value="Lista de Personas" class="btn btn-info">
						</form>
	  				</td>	  			
	  			</tr>
		  	</table>
		</div>
		<hr>
		<h2>Buscadores</h2>
		<div class="panel">
			<table class="table table-responsive">	
				<tr>		  				
					<td>
						<form action="SearchSimpleServlet" method="post">
							<input type="submit" value="Busqueda Simple" class="btn btn-primary">
						</form>
	  				</td>
	  				<td>
						<form action="SearchAdvanceServlet" method="post">
							<input type="submit" value="Busqueda Avanzada" class="btn btn-primary">
						</form>
	  				</td>	  			
	  			</tr>
		  	</table>
		</div>
		
	</div>
</body>
</html>