<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<!-- LINEARICONS -->
		
		<link rel="stylesheet" href="fonts/linearicons/style.css">
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script><title>Insert title here</title>
	</head>
	<body class="glock"style="background-color:#b5651d;">
		 <form action="Years" method="post" class="mt-5">
			<div class=" position-absolute top-10 start-50 translate-middle">
				<h2 class="ms-5 mt-5 mb-3">Year</h2>
				<div class="input-group mb-1">
				  <span class="input-group-text" id="basic-addon1"><span class="lnr lnr-calendar-full"></span></span>
				  <input type="text"  name="name"	class="form-control" placeholder="Name" aria-label="Name" aria-describedby="basic-addon1">
				  <button class="btn btn-success">Save</button>
				</div>
			</div>
		</form>
	
		<div class="position-absolute top-50 start-50 translate-middle " >
				<table class="table table-dark table-hover " style="min-width:300px; ">
					<tr>
						<th class="item level">#</th>
						<th	class="item level">Name</th>
						<th colspan="2" class="item level">Actions</th>
					</tr>	
					<c:forEach	items="${years}"	var="year"  >
						<tr>
							<td	class="item"><pre>${year.id}</pre></td>
							<td	class="item"><pre>${year.name}	</pre></td>
							<td	>
								<a	class="ref ms-4  btn btn-primary"  href="Edit_year?id=<c:out value='${year.id}'/>">
									<i class="fa-solid fa-folder-o$"></i>Details 
								</a>
							</td>
							<!--  <td	>
								<a class="ref  btn btn-warning"  href="Delete_year?id=<c:out value='${year.id}'/>">
									<i class="fa-solid fa-trash-xmark"></i>Delete
								</a>
							</td>-->
						</tr>
					</c:forEach>	
		</table>
	
		</div>
		
	</body>
</html>