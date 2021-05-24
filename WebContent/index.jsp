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
	<title>Add Package</title>
</head>
<body>

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="PackageController"><i class="fab fa-opencart"></i> Event Management</a>
			
			<ul class="navbar-nav">
				<li class="nav-item">
				
				</li>
				<li class="nav-item">
					<c:url var="logoutLink" value="UserController">
						<c:param name="command" value="LOGOUT"/>
					</c:url>
					<a class="nav-link" href="adminbooking.jsp" style="color: #F1F1F1;"><i class="fas fa-sign-out-alt"></i> Booking</a>
					<a class="nav-link" href="adminpayment.jsp" style="color: #F1F1F1;"><i class="fas fa-sign-out-alt"></i> Payment</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#ffc107;">
		<div class="container">
			<h2><i class="fas fa-folder-plus"></i> Add Package</h2>
		</div>
	</nav>
	
	<br>
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
		
			<form action="PackageController" method="get">
			
				<input type="hidden" name="COMMAND" value="ADD">
				
			
				<div class="form-group">
					<label for="inputName">Package Name: </label>
					<input type="text" id="packageName" name="packageName" placeholder="Package Name" class="form-control" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputUnit">Package Price: </label>
					<input type="number" id="packagePrice" name="packagePrice" placeholder="Price" class="form-control" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputBI">Description: </label>
					<input type="text" id="description" name="description" placeholder="Description" class="form-control" required="required">
				</div>
				
				
				<div class="form-group">
					<label for="inputPrice">Price Per Person: </label>
					<input type="number" id="pricePerPerson" name="pricePerPerson" placeholder="Price in rupees" class="form-control" required="required">
				</div>
				
				
				
				
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Add Item" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br><br>
			
			<div style="text-align:center; margin-bottom: 20px;">
				<c:url var="listLink" value="PackageController">
					<c:param name="COMMAND" value="LIST"/>
				</c:url>
				<button  class="btn btn-link" type="submit"><a href="${listLink}">Back to List</a></button>
			</div>
			
			<br>
		</div>
		
	</div>
	
	<footer class="page-footer font-small navbar-dark bg-dark" style="color:#ffffff; left: 0; bottom: 0; width: 100%; margin-top: 20px;">
		<div class="footer-copyright text-center py-3">© 2021 Copyright</div>
	</footer>
	
</body>
</html>