<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
	<head>
		<title>Registration</title>
		<meta charset="ISO-8859-1">
		<!-- LINEARICONS -->
		<link rel="stylesheet" href="../../ressources/fonts/linearicons/style.css">
		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="../../ressources/register/style.css">
				
	</head>
	<body>
		<div class="wrapper">
			<div class="inner">
				<img src="../../ressources/images/image-1.png" alt="" class="image-1">
				<form action="AddStudent"	method="post" name="frm">
				<a style="text-decoration:none; margin-left:84.5%;margin-top:-4em;"href="Home"><span style="border-color: #fff;"	class="lnr lnr-arrow-left"></span>Back</a>
					<br>
					<h3>New Student?</h3>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" class="form-control"	name="firstName" placeholder="Fisrt Name" required="required"/>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-home"></span>
						<input type="text" class="form-control"	name="lastName" placeholder="Last Name"	required="required"/>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-calendar-full"></span>
						<input type="date" class="form-control"	name="birthdate" placeholder="Birthdate"	required="required"/>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-phone-handset"></span>
						<input type="tel" class="form-control" name="phone"	placeholder="Phone Number" required="required"/>
					</div>
					<button>
						<span>Register</span>
					</button><br>
				</form>
				<img src="../../ressources/images/image-2.png" alt="" class="image-2">
				
			</div>
		
		</div>
			
		<script src="../../ressources/js/jquery-3.3.1.min.js">register</script>
		<script src="../../ressources/js/main.js"></script>
	</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>