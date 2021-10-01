<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>APP Gestão| Cadastro Aluno</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>	
		<div class="header">
			<c: import url="/jsp/menu.jsp"/>
		
	    </div>
	    <hr>

	<div class="container">
	  <h2>Cadastro de Aluno</h2>
	  <form action="/aluno/incluir" method="post">

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
	      <input type="text" class="form-control"  name="idade">
	    </div>
	    
	    <div class="form-group">
	      <label>Sexo</label>
	      <input type="text" class="form-control"  name="sexo">
	    </div>
	    
	    <div class="form-group">
	      <label>Mensalidade:</label>
	      <input type="text" value="43" class="form-control"  name="mensalidade">
	    </div>
	    
	    <div class="form-group">
	      <label>Turma:</label>
	      <input type="text" class="form-control"  name="turma">
	    </div>
	    
	    <div class="form-group">
	      <label>Atividade Fisica:</label>
	      <input type="text" class="form-control"  name="aitividadeFisica">
	    </div>
		
	    <button type="submit" class="btn btn-default">Cadastrar</button>
	  </form>
	</div>

		<hr>
	<c: import url="/jsp/footer.jsp"/>
</body>
</html>