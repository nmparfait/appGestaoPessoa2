<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>APP Gestão | Administrativo</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">

		<form action="/administrativo" method="get">
			<button type="submit" class="btn btn-link">Incluir</button>
		</form>
		
		<hr>
		
		<c:if test="${not empty administrativos}">
			<c:if test="${not empty msg}">
				<div class="alert alert-success">
				  <strong>Sucesso!</strong> ${msg}
				</div>
			</c:if>
	
			<h4>Quantidade de administrativos existentes: ${administrativos.size()}!!!</h4>
			
			<hr>
	
			<table class="table table-striped">
		    <thead>
		      <tr>
		      	<th>Id</th>
		        <th>Nome</th>
		        <th>Email</th>
		        <th>Idade</th>
		        <th>sexo</th>
		        <th>Departamento</th>
		        <th>Salario</th>
		        <th>tempoEmpresa</th>
		        <th></th>
		      </tr>
		    </thead>
		    <tbody>		    
		    	<c:forEach var="t" items="${administrativos}">
			      <tr>
			        <td>${t.id}</td>
			        <td>${t.nome}</td>
			        <td>${t.email}</td>
			        <td>${t.idade}</td>
			        <td>${t.sexo}</td>
			        <td>${t.departamento}</td>
			        <td>${t.salario}</td>
			        <td>${t.tempoEmpresa}</td>
			        <td><a href="/administrativo/${t.id}/excluir">Excluir</a></td>
			      </tr>
		    	</c:forEach>
		    </tbody>
		  	</table>
	  	</c:if>
	  	
	  	<c:if test="${empty administrativos}">
			<h4>Não existem administrativos cadastrados!!!</h4>	  	
	  	</c:if>
	</div>
</body>
</html>