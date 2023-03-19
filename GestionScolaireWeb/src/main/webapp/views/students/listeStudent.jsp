<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib	uri ="http://java.sun.com/jsp/jstl/core" 	prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
	
		 <!-- our project just needs Font Awesome Solid  -->
		  <link href="/fontawesome/css/fontawesome.css" rel="stylesheet">
		  <link href="/fontawesome/css/brands.css" rel="stylesheet">
		  <link href="/fontawesome/css/solid.css" rel="stylesheet">
		   <script defer src="/fontawesome/js/brands.js"></script>
		  <script defer src="/fontawesome/js/solid.js"></script>
		  <script defer src="/fontawesome/js/fontawesome.js"></script>
		
			<!-- LINEARICONS -->
		<link rel="stylesheet" href="register/fonts/linearicons/style.css">
		<link	href="css/bootstrap.css" rel="stylesheet"></link>	
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
		<meta http-equiv="Content-Type"	content="text/html" charset="UTF-8">
		<title>List of Student</title>
	</head>
	<body	 style="background-image: url('images/back.jpg'); background-position:'cover';">
	
		<div class="container mt-4" >
			<a class="btn btn-success d-inline-flex p-2 mb-5 ms-0	" href="AddStudent" > <span class="fa-solid fa-hexagon-plus"></span>Add Student</a>
				<table class="table table-dark table-hover ">
					<tr>
						<th class="item level">#</th>
						<th	class="item level">Fisrt Name</th>
						<th class="item	level">Last Name</th>
						<th	class="item	level">Birthdate</th>
						<th class="item level">Phone Number</th>
						<th colspan="2" class="item level">Actions</th>
						
					</tr>	
				<c:if test="${students !=null }">
				
					<c:forEach	items="${students}"	var="stud"  >
					
						<tr>
								<td	class="item"><pre>${stud.id}</pre></td>
								<td	class="item"><pre>${stud.firstName}	</pre></td>
								<td	class="item"><pre>${stud.lastName}	 </pre></td>
								<td	class="item"><pre >${stud.birthdate}</pre></td>
								<td	class="item"><pre>${stud.phone} </pre></td>
								<td	>
									<a	class="ref ms-4  btn btn-success	"	href="Edit?id=<c:out value='${ stud.id}'/>">
										<i class="fa-solid fa-folder-o$"></i>Details 
									</a>
								</td>
								<td	>
									<a class="ref  btn btn-warning"  href="delete?id=<c:out value='${ stud.id}'/>">
										<i class="fa-solid fa-trash-xmark"></i>Delete
									</a></td>
						</tr>
					</c:forEach>
				</c:if>
				
		</table>
		  <div class="position-relative top-50 start-50 translate-middle">	<a	href="Home" class="btn btn-secondary mt-5	justify-contents">Back</a>	</div>
		</div>
	</body>
	<style>
		.item{
			text-align: center;
		}
		.level{
			max-width:100vh;
		}
		.ref{
			text-decoration:none;
			margin:0.2em;
			cursor :pointor;
		}
		
		.color1{
 			 color: yellow;
		}
		.color2{color: green;}
		.positions{margin-left: 20em;}
	</style>
</html>