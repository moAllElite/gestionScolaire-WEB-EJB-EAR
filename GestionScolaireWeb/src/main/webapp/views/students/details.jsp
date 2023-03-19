<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  

<!doctype html>
<html>
	<head>

		
		<title>Details</title>
		<meta charset="ISO-8859-1">
	
		<!-- LINEARICONS -->
		<link rel="stylesheet" href="../../ressources/register/fonts/linearicons/style.css">
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="../../ressources/register/style.css">
	
	</head>

	<body>
		 <%@ page errorPage="404Error.jsp " %>
		 
		<div class="wrapper">
			<div class="inner">
			
				<img src="../../ressources/images/image-1.png">
				<c:if test="${student!=null }">		
					
				<form action="update"	method="post" name="frm">
				<a style="text-decoration:none; margin-left:84.5%;margin-top:-4em;"href="Home"><span style="border-color: #fff;"	class="lnr lnr-arrow-left"></span>Back</a>
					<br>
					<h3>Edit Student</h3>
					<div class="form-holder">
						
						<input type="hidden" class="form-control"	name="id" value='<c:out value="${student.id }"></c:out>' placeholder="id" required="required"/>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" class="form-control"	name="firstName" value='<c:out value="${student.firstName }"></c:out>' placeholder="Fisrt Name" required="required"/>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-home"></span>
						<input type="text" class="form-control"	name="lastName" value='<c:out value="${student.lastName  }"></c:out>'placeholder="Last Name"	required="required"/>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-calendar-full"></span>
					
						<input type="date" class="form-control"	name="birthdate" placeholder="Birthdate" value='<c:out value="${student.birthdate}"></c:out>'	required="required"/>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-phone-handset"></span>
						<input type="tel" class="form-control" name="phone"	placeholder="Phone Number" required="required" value='<c:out value="${student.phone }"></c:out>'/>
					</div>
					
					
					<button>
						<span>Edit</span>
					</button><br>
					
				</form>
				</c:if>
				
					<img src="../../ressources/images/image-2.png" alt="" class="image-1">
				
			</div>
		
		</div>
			
		<script src="../../ressources/js/jquery-3.3.1.min.js"></script>
		<script src="../../ressources/register/js/main.js"></script>
</html>