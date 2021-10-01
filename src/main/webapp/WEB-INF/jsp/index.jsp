<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>APP Gestão |Index</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<!-- style -->
		<link rel="stylesheet" href="../css/login.css" />
		<link rel="stylesheet" href="../css/styles.css" />
		<link rel="stylesheet" href="../css/footer.css" />
	</head>
	<body>


		<div class="header">

			<c:import url="/WEB-INF/jsp/menu.jsp"/>
	    </div>
	    <hr>
		<!-- connect people -->
		<section class="connect">
	      <video controls autoplay muted loop class="video-container">
	      	<source src="video/connect.mp4" type="video/mp4" />
	      		sorry, your browser doesn't support embedded videos.
	      </video>
	      <div class="video-banner">
	      	<!-- section title  -->
	        <div class="section-title">
	          <h2>let's get in touch</h2>
	          <div class="underline"></div>
	        </div>
	        <!--end of section title  -->
	        <p class="video-text">
	          Lorem ipsum dolor sit amet consectetur adipisicing elit. Est quos
	          dolorum odit necessitatibus hic omnis ut, nobis consectetur sunt
	          voluptatibus ea quas in totam eligendi. Unde cumque possimus
	          laudantium cum expedita asperiores, quas deleniti quod dolorum
	          repudiandae magnam laboriosam? Voluptatum.
	        </p>
	        <a href="contact.html" class="btn"> contact me </a>
	      </div>
    	</section>
    	

		   <!-- services -->
		    <section class="section bg-grey" id="service">
		      <!-- section title  -->
		      <div class="section-title">
		        <h2>services</h2>
		        <div class="underline"></div>
		      </div>
		      <!--end of section title  -->
		      <div class="services-center section-center">
		        <!-- single service -->
		        <article class="service">
		          <i class="fas fa-code service-icon"></i>
		          <h4>IT SERVICES</h4>
		          <div class="underline"></div>
		          <p>
		            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Porro
		            temporibus alias possimus suscipit deserunt repudiandae vitae
		            perspiciatis, molestias architecto error!
		          </p>
		        </article>
		        <!-- end of single service -->
		
		        <!-- single service -->
		        <article class="service">
		          <i class="fab fa-sketch service-icon"></i>
		          <h4>PUBLICS JOBS</h4>
		          <div class="underline"></div>
		          <p>
		            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Porro
		            temporibus alias possimus suscipit deserunt repudiandae vitae
		            perspiciatis, molestias architecto error!
		          </p>
		        </article>
		        <!-- end of single service -->
		
		        <!-- single service -->
		        <article class="service">
		          <i class="fab fa-android service-icon"></i>
		          <h4>SALARY AND IMPACT</h4>
		          <div class="underline"></div>
		          <p>
		            Lorem, ipsum dolor sit amet consectetur adipisicing elit. Porro
		            temporibus alias possimus suscipit deserunt repudiandae vitae
		            perspiciatis, molestias architecto error!
		          </p>
		        </article>
		        <!-- end of single service -->
		      </div>
		    </section>
		    <!-- end of services -->
		  <!-- contact -->
			<section class="section about contact" id="contact">
		      <div class="section-center about-center">
		        <!-- about img -->
		        <article class="">
		          <img src="img/contact.jpg" alt="contact img" class="hero-photo" />
		        </article>
		        <article class="about-info">
		          <!-- section title  -->
		          <div class="section-title about-title">
		            <h1>contact</h1>
		            <div class="underline"></div>
		          </div>
		          <!--end of section title  -->
		          <!-- about info -->
		          <h4>
		            Gestão App, A company at the service of the 
		            community to create opportunities and help make your dreams come true by organizing your times. 
		          </h4>
		
		          <p>
		            You can join me at <em>parfait.mbamu@al.infnet.edu.br</em> or find me on
		            <a href="https://twitter.com/nmparfait">
		              <i class="fab fa-twitter"></i>
		            </a>
		            <a href="https://twitter.com/nmparfait">
		              <i class="fab fa-linkedin"></i>
		            </a>
		            <a href="https://twitter.com/nmparfait">
		              <i class="fab fa-github"></i>
		            </a>
		          </p>
		          <a href="about.html" class="btn">read more</a>
		        </article>
		      </div>
		    </section>
		    <!-- end of about -->
	<!-- footer -->
		<c:import url="/WEB-INF/jsp/footer.jsp"/>

    	
	</body>
</html>