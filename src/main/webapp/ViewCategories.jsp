<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Categories</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link" href="AdminLandingPage.jsp" tabindex="-1">Bumblee-Bee</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" href="CategoryController">View Categories</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link " href="InsertCategory.jsp">Register Category</a>
		  </li>
		</ul>
	<div class="container">
		
		<br><p>${message}</p><br>
		<a href="InsertCategory.jsp"><button class="btn btn-success">ADD CATEGORY</button></a><br>
		<table class="table">
			<thead>
				<tr class="table-dark">
					<th>Category Code</th>
					<th>Category Name</th>
					
					<th>Update</th>
					<th>Delete</th>
				</tr>
			</thead>		
			<tbody>
				<tag:forEach var ="category" items="${categoryList}">
					<tr>
						<td>${category.category_id}</td>
						<td>${category.category_name}</td>
						
						<td>
							<form method="get" action="CategoryController">
								<input type="hidden" name="category_id" value="${category.category_id}">
								<input type="hidden" name="type" value="specific">
								<button type="submit" class="btn btn-warning">UPDATE</button>							
							</form>
						</td><td>
							<form method="post" action="category">
								<input type="hidden" name="categoryId" value="${category.category_id}">
								<input type="hidden" name="type" value="delete">
								<button type="submit" class="btn btn-danger">DELETE</button>							
							</form>
						</td>
					</tr>
				</tag:forEach>			
			</tbody>
		</table>
	</div>
</body>
</html>