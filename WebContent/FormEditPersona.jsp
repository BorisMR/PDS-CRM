<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="business.Persona" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="i" %>
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

	<title>Editar Contacto</title>
</head>
<body>
	<h2><b>Editar Persona</b></h2>
	<div class="container">
		<h3>Formulario de Datos de la Persona</h3>
		<hr>
			<h3>${EditPersonaStatus}</h3>
		<hr>
		<form class="form-horizontal" action="EditPersonaServlet" method="post">
	  		<div class="form-group">
	    		<label for="run">ID:</label>
	    		<input type="text" class="form-control" id="idP" name="run" value="${idE}" readonly>
	  		</div>
	  		<div class="form-group">
	    		<label for="run">Run:</label>
	    		<input type="text" class="form-control" id="run" name="run" value="${run}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="nombre">Nombre:</label>
	    		<input type="text" class="form-control" id="nombre" name="nombre" value="${nombre}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="apellido">Apellido:</label>
	    		<input type="text" class="form-control" id="apellido" name="apellido" value="${apellido}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="email">eMail:</label>
	    		<input type="email" class="form-control" id="email" name="email" value="${email}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="telefono">Telefono:</label>
	    		<input type="number" class="form-control" id="fono" name="fono" value="${fono}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="direccion">Dirección:</label>
	    		<input type="text" class="form-control" id="direccion" name="direccion" value="${direccion}" required>
	  		</div>
	  		<div class="form-group">
	    		<label for="genero">Genero:</label>
	    		<input type="text" class="form-control" id="genero" name="genero" value="${genero}" required>
	  		</div>
	  		<div>
	  			<label for="foto">Foto Contacto:</label>
	  			<div class="form-group" id="imgContainer"></div>
	  			<input id="inputImagen" name="inputImagen" type="file" multiple accept='image/*' onchange="encodeImage();" />
	  		</div>
	  		<textarea id="textArea" name="textArea" class="form-control textbox" value="${foto_b64}" hidden></textarea> 
	  		<!--        		   		
	  		<div class="form-group">	
		  		<select multiple class="form-control" name="empresaIde">  
		  		<i:forEach items="${listaEmpresas}" var="empresa">
					<option value="${empresa.idE}">${empresa.nombre}</option>
				</i:forEach>
				</select>
	  		</div>
	  		 -->
	  		 ${empresanombre}
	  		 ${LISTA}  		 		
	  		<button type="submit" class="btn btn-warning" value="Editar">Editar</button>
		</form>
		<hr>
		<a href="Index.jsp" class="btn btn-primary">Volver</a>
	</div>
</body>
</html>