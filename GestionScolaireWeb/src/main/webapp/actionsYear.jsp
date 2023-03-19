<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  

<!doctype html>
<html>
	<head>

		
		<title>Details</title>
		<meta charset="ISO-8859-1">
	
		<!-- LINEARICONS -->
		<link rel="stylesheet" href="ressources/fonts/linearicons/style.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="ressources/css/register/style.css">
	</head>

	<body>
		
		
		<div class="wrapper">
			<div class="inner">
				<img src="ressources/images/image-1.png" alt="" class="image-1">
				<c:if test="${year!=null }">		
					
				<form action="Update_year"	method="post" name="f">
				<a style="text-decoration:none; margin-left:84.5%;margin-top:-4em;"href="Home"><span style="border-color: #fff;"	class="lnr lnr-arrow-left"></span>Back</a>
					<br>
					<h3>Edit Year </h3>
					<div class="form-holder">
						
						<input type="hidden" class="form-control"	name="id"  placeholder="id" />
					</div>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" class="form-control"	name="name" value='<c:out value="${year}"></c:out>' placeholder=" Name" required="required"/>
					</div>
					
				
					
					
					<button>
						<span>Edit</span>
					</button><br>
					
				</form>
				</c:if>
				
				<img src="ressources/images/image-2.png" alt="" class="image-2">
				
			</div>
		
		</div>
			
		<script src="ressources/js/jquery-3.3.1.min.js"></script>
		<script src="ressources/js/main.js"></script>
</html>