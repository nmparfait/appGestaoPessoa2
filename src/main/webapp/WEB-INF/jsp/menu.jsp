<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	    <meta charset="UTF-8" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
	    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
	    <title>APP Gestão | Navbar</title>
	    <!-- font awesome -->
	    <link
	      rel="stylesheet"
	      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css"
	    />
	    <!-- google font -->
	    <link href="https://fonts.googleapis.com/css2?family=Dancing+Script&display=swap" rel="stylesheet">
	    <!-- style -->
	    <link rel="stylesheet" href="css/styles.css" />
  	</head>
  	 <body>
  	 	<nav class="navbar navbar-default navbar-fixed-top">
  			<div class="container-fluid">
    			<div class="navbar-header">
      				<a class="navbar-brand font logoVentura" href="http://localhost:8080">Gestão App</a>
    			</div>
	  	 	<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty user}">
				    <li><a href="/usuario"><span class="glyphicon glyphicon-user navSize"></span> Usuario</a></li>
				    <li><a href="/acesso"><span class="glyphicon glyphicon-log-in navSize"></span> Professor</a></li>
				    <li><a href="http://localhost:8080/#about"><span class="glyphicon glyphicon-flag navSize"></span> Administrativo</a></li>
				    <li><a href="http://localhost:8080/#service"><span class="glyphicon glyphicon-retweet navSize"></span> Aluno</a></li>
				    <li><a href="http://localhost:8080/#contact"><span class="glyphicon glyphicon-envelope navSize"></span> Instituicao</a></li>
			    </c:if>
			    <c:if test="${not empty user}">
			    	<li><a href="http://localhost:8080/#about"><span class="glyphicon glyphicon-flag navSize"></span> Register</a></li>
				    <li><a href="http://localhost:8080/#service"><span class="glyphicon glyphicon-retweet navSize"></span> Login</a></li>
				    <li><a href="http://localhost:8080/#contact"><span class="glyphicon glyphicon-envelope navSize"></span> Contact</a></li>
			    	<li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span>Logout, ${usuario.email}</a></li>
			    </c:if>
			 </ul>
		</nav>
    </body>
   </html>
