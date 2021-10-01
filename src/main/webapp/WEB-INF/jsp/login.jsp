<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>APP Gestão | Login</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	    <!-- style -->
		<link rel="stylesheet" href="/css/login.css" />
		<link rel="stylesheet" href="/webapp/css/styles.css" />

	</head>
	<body>

		<c:import url="/WEB-INF/jsp/menu.jsp"/>

		
		 <form class="box" action="/login" method="post">
			 <c:if test="${not empty mensagem}">
				 <div class="alert alert-danger">
					 <strong>Está errado!</strong> ${mensagem}
				 </div>
			 </c:if>

          <h1>Login</h1>
          <!-- <input type="email" name="email" placeholder="email@email.com">  -->
          <input type="text" class="form-control" placeholder="email@email.com"  name="email">
          <input type="password" class="form-control" name="senha" placeholder="Password">
          <input type="submit"  value="Login">
       </form>



	</body>
</html>
