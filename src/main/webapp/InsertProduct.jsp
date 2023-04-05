<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Product</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link" href="AdminLandingPage.jsp" tabindex="-1">Bumblee-Bee</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="product">Store</a>
		  </li>
		</ul>
	<div class="container">
		
		<br><p>${message}</p><br>
		<form method="post" action="product">
			<lable for="txtProductName">Product Name</lable>
			<input type="text" id="txtProductName" name="product_name" class="form-control" Required/>
			
			<lable for="txtPrice">Product Price</lable>
			<input type="number" id="txtPrice" name="product_price" class="form-control" Required/>
			
			<lable for="txtProductbrand">Product Description</lable>
			<input type="text" id="txtProductbrand" name="product_brand" class="form-control" Required/>
			
			<lable for="txtCategory">Product Category</lable>
			<select id="txtCategory" name="category" class="form-control" Required/>
				<tag:forEach var ="category" items="${categoryList}">
					<option>${category.category_name}</option>
				</tag:forEach>				
			</select>
			
			<input type="hidden" name="type" value="add"><br/>
			<button type="submit" class="btn btn-success">Register</button>
			
		</form>
	</div>

</body>
</html>