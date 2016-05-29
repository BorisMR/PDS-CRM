<%@ page language="java" contentType="text/html; charset=iso-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<title>Formulario de Ingreso</title>
</head>
<body>
	<div class="container">
		<div class="row" id="pwd-container">
        <div class="col-md-4"></div>
    
        <div class="col-md-4">
			<h2><b>Login</b></h2>
			<hr>
			<h4 class="text-warning">${LoginStatus}</h4>
			<hr>	
			<form class="form-horizontal" action="LoginServlet" method="post" role="form">
				<div class="form-group">
					 <label class="sr-only" for="usser">Usuario</label>
					 <input class="form-control" 
					 	type="text" 
					 	id="user" 
					 	name="user" 
					 	placeholder="Introduce tu Usuario" 
					 	required>
				</div>
				<div class="form-group">
					 <label class="sr-only" for="password">Password</label>
					 <input class="form-control" 
						type="password" 
						id="pass" 
						name="pass" 
						placeholder="Introduce tu Password" 
					 	required>
				</div>
				<div class="form-group">
					<button type="submit" class="btn btn-success">Ingresar</button>
				</div>				
			</form>		
			
		</div>
		</div>		
	</div>
</body>
</html>