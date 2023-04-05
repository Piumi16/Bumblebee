<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<ul class="nav nav-tabs">
		<li class="nav-item">
		  <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Bumble-Bee</a>
		</li>
		<li class="nav-item">
		   <a class="nav-link" href="category">Categories</a>
		</li>
		<li class="nav-item">
		  <a class="nav-link" href="product">Products</a>
		</li>
		<li class="nav-item">
		  <a class="nav-link" href="customer">Customers</a>
		</li>
		<li class="nav-item">
		  	<form method="post" action="customer">
				<input type="hidden" name="type" value="logout">
				<button type="submit" class="btn btn-danger">LOGOUT</button>							
			</form>
		</li>
		
	</ul>
</body>
</html>