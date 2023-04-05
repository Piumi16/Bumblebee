<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false" %>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
<ul class="nav nav-tabs">
		  <li class="nav-item">
		    <a class="nav-link" href="AdminLandingPage.jsp" tabindex="-1" >Bumblee-Bee</a>
		  </li>
		  		  
		</ul>
	<div class="container">
			
		<br><p>${message}</p><br>
		
		
		<h3>View Loan</h3>
			
			<lable for="txtLoanCustCode">Customer Id</lable>
			<input type="text" id="txtLoanCustCode" name="customerIdLoan" class="form-control" value="${loan.cust_id}"/>
			
			<lable for="txtLoanAmount">Loan Amount</lable>
			<input type="text" id="txtLoanAmount" name="usedAmount" class="form-control" value="${loan.loan_amount}"/>
			
			<lable for="txtLoanLoanGetDay">Loan Get Day</lable>
			<input type="text" id="txtLoanLoanGetDay" name="loanLoanGetDay" class="form-control" value="${loan.loan_get_day}"/>
			
			
			
			

	</div>
	
</body>
</html>