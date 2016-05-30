<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.2/css/bootstrapValidator.min.css"></link>
	
	<script type="text/javascript" src="js/jquery-1.12.0.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>    
    <script src="//oss.maxcdn.com/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"></script>    
    <script type="text/javascript" src="js/validator.js"></script>

	<title>Bitacora</title>
</head>
<body>
	<h2><b>Agregar entrada a bitacora</b></h2>
	<div class="container">
		<h3>Contacto: ${nombre} ${apellido} </h3>
		<hr>
		<h4>${AddBitacoraStatus}</h4>
		<hr>
		<form class="form-horizontal" action="AddBitacoraServlet" method="post" id="FormAddBitacora">
	  		<div class="form-group">
	    		<label for="idP">ID:</label>
	    		<input type="text" class="form-control" id="idP" name="idP" value="${idP}" readonly>
	    		<input type="text" class="form-control" id="nombre" name="nombre" value="${nombre}" style="display:none;" readonly>
	    		<input type="text" class="form-control" id="apellido" name="apellido" value="${apellido}" style="display:none;" readonly>
	  		</div>
	  		<div class="form-group">
	    		<label for="entrada">Entrada:</label>
	    		<textarea id="entrada" name="entrada" class="form-control textbox" required></textarea>
	  		</div>
	  		<button type="submit" class="btn btn-success" value="Agregar">Agregar</button>
		</form>
		<hr>
		<form action="Index.jsp" method="post">
			<input type="submit" value="Menu" class="btn btn-primary">	
		</form>
	</div>
</body>
</html>