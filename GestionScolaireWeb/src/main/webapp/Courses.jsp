<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
	<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Courses</title>
	 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	
	</head>
	<body>
			
			<div class="container">
				<form action="Courses" method="post">
					<h3>Add Course</h3>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="basic-addon1">@</span>
					  <input type="text" class="form-control" name="name" placeholder="name" aria-label="name" aria-describedby="basic-addon1">
					</div>
					<div class="input-group mb-3">
					  <span class="input-group-text" id="basic-addon1">#</span>
					  <input type="text" class="form-control" name="program" placeholder="Program" aria-label="Program" aria-describedby="basic-addon1">
					</div>
					<button class="btn btn-success ms-5">Save</button>
					<a href="Home" class="btn btn-secondary ms-5">Home</a>
				</form>
				<table class="table table-dark table-hover mt-5" style="min-width:300px; ">
					<tr>
						<th class="item level">#</th>
						<th	class="item level">Name</th>
						<th	class="item level">Progam</th>
						<th colspan="2" class="item level">Actions</th>
					</tr>	
					<c:forEach	items="${courses}"	var="course"  >
						<tr>
							<td	class="item"><pre>${course.id}</pre></td>
							<td	class="item"><pre>${course.name}	</pre></td>
							<td	class="item"><pre>${course.program}	</pre></td>
							<td	>
								<a	class="ref ms-4  btn btn-primary"  href="Edit_?id=<c:out value='${course.id}'/>">
									<i class="fa-solid fa-folder-o$"></i>Details 
								</a>
							</td>
							<td>
								<a class="ref  btn btn-warning"  href="DeleteCourse?id=<c:out value='${course.id}'/>">
									<i class="fa-solid fa-trash-xmark"></i>Delete
								</a>
							</td>
						</tr>
					</c:forEach>	
			</table>
			
			</div>
			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD" crossorigin="anonymous"></script>
		
	</body>
</html>