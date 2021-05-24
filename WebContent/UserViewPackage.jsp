<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
	<link rel="stylesheet" href="css/universal_style.css">
	<title>Package List</title>
</head>
<body>

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="PackageviewController"><i class="fab fa-opencart"></i> Event Management</a>
			
			<ul class="navbar-nav">
				
				<li class="nav-item">
					
					<a class="nav-link" href="UserViewPackage.jsp" style="color: #F1F1F1;"><i class="fas fa-sign-out-alt"></i> Booking</a>
					<a class="nav-link" href="adminpayment.jsp" style="color: #F1F1F1;"><i class="fas fa-sign-out-alt"></i> Payment</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#ffc107;">
		<div class="container">
			<h2>List of Packages</h2>
		</div>
	</nav>
	
	<div class="container" style="text-align:center; padding-top: 10px;">
	
		<div class="row">
			
			
			<div class="col-sm-6" style="padding: 10px 15px 10px 15px;">
				<c:url var="checkLink" value="PackageviewController">
					<c:param name="COMMAND" value="CHECK"/>
				</c:url>
				
			</div>
		</div>  
	  	
	    <br>
		
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead style="background-color: #007bff; color:#ffffff">
					<tr>
						<th>Package Name</th>
						<th>Package Price</th>
						<th>Description</th>
						<th>Price Per person</th>
						<th>Action</th>
						
					</tr>
				</thead>
				
				<tbody>
				
					<c:forEach var="tempItem" items="${ BOOK_LIST }">
						<c:url var="updateLink" value="PackageviewController">
							<c:param name="COMMAND" value="LOAD"/>
							<c:param name="id" value="${tempItem.id}"/>
						</c:url>
						<c:url var="deleteLink" value="PackageviewController">
							<c:param name="COMMAND" value="DELETE"/>
							<c:param name="id" value="${tempItem.id}"/>
						</c:url>
						<tr>
							<td> ${tempItem.packageName} </td>
							<td> ${tempItem.packagePrice} </td>
							<td> ${tempItem.description} </td>
							<td> ${tempItem.pricePerPerson} </td>
							
							<td>
								<a href="${updateLink}">Update</a>
								|
								<a href="${deleteLink}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>

				</table>
				</div>
				
				<br><br>
			</div>
			
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; position: fixed; left: 0; bottom: 0; width: 100%;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
</body>
</html>