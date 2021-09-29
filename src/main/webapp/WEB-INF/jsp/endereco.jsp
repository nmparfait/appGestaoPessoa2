<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <title>APP Gestão |Register</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	    <link rel="stylesheet" href="css/cadastro.css" />
	</head>
	<body>
		<c:import url="/WEB-INF/jsp/menu.jsp"/>
		
		
	
		    
		    	<h1>Check the Adress</h1>
		    	
		    	<input type="text" class="form-control" placeholder="logradouro"  name="logradouro">
		    	<input type="text" class="form-control" placeholder="cep"  name="cep">
		        <input type="password" class="form-control" placeholder="complemento" name="complemento">
		        <input type="text" class="form-control" placeholder="bairro" name="bairro">
		        <input type="text" class="form-control" placeholder="localidade" name="localidade">
		        <input type="text" class="form-control" placeholder="Estado" name="Estado">
		      
		        <input type="submit" class="btn btn-default" name="" value="check">
		    
	</body>
</html>
