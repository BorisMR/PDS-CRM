<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"></link>
	
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>    
    <script type="text/javascript" src="js/validator.js"></script>
	
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
					  
						<form action="AddPersonaServlet" method="get">
							<input type="submit" value="Agregar Persona" class="btn btn-success">
						</form>
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
		<h2>Empresa</h2>
		<div class="panel">
			<table class="table table-responsive">	
				<tr>
					<td>
			  			<a href="FormAddEmpresa.jsp" class="btn btn-success">Agregar Empresa</a>
	  				</td>
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