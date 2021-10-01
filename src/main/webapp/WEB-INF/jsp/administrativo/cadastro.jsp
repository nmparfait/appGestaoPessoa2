<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>APP Gestão | Cadastro</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	    <!-- style -->
		<link rel="stylesheet" href="css/login.css" />
		<link rel="stylesheet" href="css/styles.css" />
		<link rel="stylesheet" href="css/footer.css" />
	</head>
	<body>
	
		<c: import url="/jsp/menu.jsp"/>

	<div class="container">
	  <h2>Cadastro de Administrativo</h2>
	  <form action="/administrativo/incluir" method="post">

	    <div class="form-group">
	      <label>Nome:</label>
	      <input type="text" class="form-control"  name="nome">
	    </div>

	    <div class="form-group">
	      <label>Email:</label>
	      <input type="text" class="form-control" name="email">
	    </div>
	    
	    <div class="form-group">
	      <label>Idade:</label>
	      <input type="text"class="form-control"  name="idade">
	    </div>
	    
	    <div class="form-group">
	      <label>Departamento:</label>
	      <input type="text" class="form-control"  name="departamento">
	    </div>
	    
	    <div class="form-group">
	      <label>Salario</label>
	      <input type="text" class="form-control"  name="salario">
	    </div>
	    
	    <div class="form-group">
	      <label>tempo de Empresa</label>
	      <input type="text" class="form-control"  name="tempoEmpresa">
	    </div>
		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>
	<c: import url="/jsp/footer.jsp"/>
</body>
</html>