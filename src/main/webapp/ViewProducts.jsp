<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
	<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link " href="AdminLandingPage.jsp" tabindex="-1">Bumblee-Bee</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" href="product">View Products</a>
		  </li>
		</ul>
	<div class="container">
		
		<br><p>${message}</p><br>
		<form method="get" action="CategoryController">
			<input type="hidden" name="type" value="select">
			<button type="submit" class="btn btn-success">ADD NEW PRODUCT</button>							
		</form></br>
		<table class="table">
			<thead>
				<tr class="table-dark">
					<th>Product Code</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Brand</th>
					<th>Category</th>
					<th>Delete</th>
					<th>Update</th>
				</tr>
			</thead>		
			<tbody>
				<tag:forEach var ="product" items="${productList}">
					<tr>
						<td>${product.product_id}</td>
						<td>${product.product_name}</td>
						<td>${product.product_price}</td>
						<td>${product.product_brand}</td>
						<td>${product.product_category}</td>
						<td>
							<form method="post" action="product">
								<input type="hidden" name="product_id" value="${product.product_id}">
								<input type="hidden" name="type" value="delete">
								<button type="submit" class="btn btn-danger">DELETE</button>							
							</form>
						</td><td>
							
							<form method="get" action="product">
								<input type="hidden" name="product_id" value="${product.product_id}">
								<input type="hidden" name="type" value="specific">
								<button type="submit" class="btn btn-warning">UPDATE</button>							
							</form>
						</td>
					</tr>
				</tag:forEach>			
			</tbody>
		</table>
	</div>

</body>
</html>