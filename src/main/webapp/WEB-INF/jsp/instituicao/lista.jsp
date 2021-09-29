<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>APP Gestão | Lista de Instituicao</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>	
		<div class="header">
			<c:import url="/WEB-INF/jsp/menu.jsp"/>
		</div>
		
		<div class="container">

		<form action="/instituicao" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
		
		<c:if test="${not empty instituicao}">
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
				  <strong>Sucesso!</strong> ${msg}
				</div>
			</c:if>
	
			<h4>Lista de Instituições existentes: ${instituicoes.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Nome</th>
		        <th>Professor</th>
		        <th>Administrativo</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="t" items="${instituicao}">
			      <tr>
			        <td>${t.id}</td>
			        <td>${t.nome}</td>
			        <td>${t.professor.nome}</td>
			        <td>${t.administrativo.nome}</td>
			        <td><a href="/instituicao/${t.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty instituicoes}">
			<h4>Nenhuma instituição cadastrada!!</h4>
	  	</c:if>
	</div>
	<c:import url="/WEB-INF/jsp/footer.jsp"/>
	</body>
</html>
	