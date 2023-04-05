<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manage Products</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link" href="AdminLodingPage.jsp" tabindex="-1">Bumblee-Bee</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="product">Store</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" href="InsertProduct.jsp">Register Product</a>
		  </li>
		</ul>	
	<div class="container">
		
		<br><p>${message}</p><br>
		
		
		<h3>Update The Product</h3>
		<form method="post" action="product">
			<lable for="txtProductId">Product Id</lable>
			<input type="text" id="txtProductId" name="product_id" class="form-control" value="${product.product_id}" Required/>
			
			<lable for="txtProductName">Product Name</lable>
			<input type="text" id="txtProductName" name="product_name" class="form-control" value="${product.product_name}" Required/>			
			<lable for="txtPrice">Product Price</lable>
			<input type="number" id="txtPrice" name="product_price" class="form-control" value="${product.product_price}" Required/>
			<input type="hidden" name="type" value="update">
			<lable for="txtProductBrand">Product Brand</lable>
			<input type="text" id="txtProductBrand" name="product_brand" class="form-control" value="${product.product_brand}" Required/>			
			<lable for="txtProductCategory">Product Category</lable>
			<input type="text" id="txtProductCategory" name="product_category" class="form-control" value="${product.product_category}" Required/>			
			<br/>
			<button type="submit" class="btn btn-warning">Update</button>			
		</form>
	</div>
</body>
</html>