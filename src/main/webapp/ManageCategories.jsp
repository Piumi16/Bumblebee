<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Categories</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link" href="AdminLandingPage.jsp" tabindex="-1" >Bumblee-Bee</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="CategoryController">Store</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="InsertCategory.jsp">Register Category</a>
		  </li>		  
		</ul>
	<div class="container">
			
		<br><p>${message}</p><br>
		
		
		<h3>Update The Category</h3>
		<form method="post" action="CategoryController">
			<lable for="txtCategoryCode">Category Id</lable>
			<input type="text" id="txtCategoryCode" name="category_id" class="form-control" value="${category.category_id}" Required/>
			
			<lable for="txtCategoryName">Category Name</lable>
			<input type="text" id="txtCategoryName" name="category_name" class="form-control" value="${category.category_name}" Required/>			
			<input type="hidden" name="type" value="update">
			<br/>
			<button type="submit" class="btn btn-warning">Update</button>			
		</form>
	</div>
</body>
</html>