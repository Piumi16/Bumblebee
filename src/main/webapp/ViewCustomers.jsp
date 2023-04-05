<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Customers</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link" href="AdminLandingPage.jsp" tabindex="-1">Bumblee-Bee</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link active" href="CategoryController">View Customers</a>
		  </li>
		</ul>
	<div class="container">
		
		<br><p>${message}</p><br>
		<table class="table">
			<thead>
			
				<tr class="table-dark">
					<th>Customer ID</th>
					<th>Customer Name</th>					
					<th>Mail</th>
					<th>Contact</th>
					<th>Date Of Birth</th>
					
					<th>Loan </th>
					
				</tr>
			</thead>		
			<tbody>
				<tag:forEach var ="customer" items="${customerList}">
					<tr>
						<td>${customer.customer_id}</td>
						<td>${customer.customer_name}</td>
						<td>${customer.customer_mail}</td>
						<td>${customer.customer_tel}</td>	
						<td>${customer.date_of_birth}</td>
						
						
						<td>
							<form method="get" action="loan">
								<input type="hidden" name="customerIdLoan" value="${customer.customer_id}">
								<input type="hidden" name="type" value="specific">
								<button type="submit" class="btn btn-primary">VIEW</button>							
							</form>
						</td>
					</tr>
				</tag:forEach>			
			</tbody>
		</table>
	</div>
</body>
</html>