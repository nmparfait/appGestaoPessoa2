<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>APP Gestão | Lista de Alunos</title>
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
			<c:if test="${not empty mensagem}">
				<div class="alert alert-success alert-dismissible">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
					<strong>Informação!</strong> ${mensagem}
				</div>
			</c:if>

			<c:if test="${not empty alunos}">
				<form action="/aluno" method="get">
					<h4>
						Lista de alunos cadastrados: ${alunos.size()}
						<button type="submit" class="btn btn-default btn-lg" name="tela">Incluir</button>
					</h4>
				</form>
				<br>
				<table class="table table-striped">
				<thead>
				  <tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Idade</th>
					<th>Sexo</th>
					<th>Mensalidade</th>
					<th>Turma</th>
					<th>Atividade Física</th>
				  </tr>
				</thead>
				<tbody>
					<c:forEach var="j" items="${alunos}">
					  <tr>
						<td>${j.id}</td>
						<td>${j.nome}</td>
						<td>${j.email}</td>
						<td>${j.idade}</td>
						<td>${j.sexo}</td>
						<td>${j.mensalidade}</td>
						<td>${j.turma}</td>
						<td>${j.atividadeFisica}</td>
						<td><a href="/aluno/${j.id}/excluir">Excluir</a></td>
					  </tr>
					</c:forEach>
				</tbody>
				</table>
	  		</c:if>
	  	
	  	<c:if test="${empty alunos}">
			<h4>Não existem alunos cadastrados!!!</h4>	  	
	  	</c:if>
	</div>
		   
	<c:import url="/WEB-INF/jsp/footer.jsp"/>
	</body>
</html>
	