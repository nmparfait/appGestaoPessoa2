<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>APP Gestão | Instituicao</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	</head>
	<body>	
		
		<c: import url="/jsp/menu.jsp"/>
		
		
		 <form action="/instituicao/incluir" method="post">

		  <div class="form-group">
			  <label>Nome da Instituiçao:</label>
			  <input  type="text" class="form-control" placeholder="Entre com a sua instituicao" name="nome">
		  </div>

		  <div class="form-group">
			  <c:if test="${not empty professores}">
				  <label>Professor:</label>
				  <select class="form-control" name="professor">
					  <c:forEach var="d" items="${professores}">
						  <option value="${d.id}">${d.nome}</option>
					  </c:forEach>
				  </select>
			  </c:if>
			  <c:if test="${empty professores}">
				  <c:set var="botao" value="disabled"/>
				  <label>Não há professor cadastrado!!</label>
			  </c:if>
		  </div>

		  <div class="form-group">
			  <c:if test="${not empty administrativo}">
				  <label>Administrativos:</label>
				  <select class="form-control" name="administrativo">
					  <c:forEach var="t" items="${administrativos}">
						  <option value="${t.id}">${t.nome}</option>
					  </c:forEach>
				  </select>
			  </c:if>
			  <c:if test="${empty administrativos}">
				  <c:set var="botao" value="disabled"/>
				  <label>Não há administrativo cadastrado!!</label>
			  </c:if>
		  </div>

		  <div class="form-group">
			  <c:if test="${not empty alunos}">
				  <label>Alunos:</label>
				  <c:forEach var="j" items="${alunos}">
					  <div class="form-check">
						  <label class="form-check-label">
							  <input name="alunosId" type="checkbox" checked="checked"> 
						  </label>
					  </div>
				  </c:forEach>
			  </c:if>
			  <c:if test="${empty alunos}">
				  <c:set var="botao" value="disabled"/>
				  <label>Não há alunos cadastrado!!</label>
			  </c:if>
		  </div>

		  <button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
	  </form>
	  
	  <c: import url="/jsp/footer.jsp"/>
		
	</body>
	
</html>