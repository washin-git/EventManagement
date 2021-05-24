<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
	<link rel="stylesheet" href="css/universal_style.css">
	<title>User Book Package</title>
</head>
<body>

	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="PackageViewController"><i class="fab fa-opencart"></i> Event Management</a>
			
			
		</div>
	</nav>
	
	<nav class="navbar navbar-light" style="background-color:#ffc107;">
		<div class="container">
			<h2><i class="fas fa-pen-square"></i> Book Package</h2>
		</div>
	</nav>
	<br>
	<div class="container" style="max-width: 800px; box-shadow: 5px 10px 18px #888888;">
		
		<br>
		
		<div>
			<form action="PackageViewController" method="get">
			
				<input type="hidden" name="COMMAND" value="UPDATE">
				<input type="hidden" name="id" value="${PACKAGE.id}">
				
			
				<div class="form-group">
					<label for="inputName">Package Name: </label>
					<input type="text" id="packageName" name="packageName" placeholder="package Name" class="form-control" value="${PACKAGE.packageName}" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputUnit">Package Price: </label>
					<input type="number" id="packagePrice" name="packagePrice" placeholder="Price" class="form-control" value="${PACKAGE.packagePrice}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputBI">Description: </label>
					<input type="text" id="description" name="description" placeholder="Description" class="form-control" value="${PACKAGE.description}" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputPrice">Price Per Person: </label>
					<input type="number" id="pricePerPerson" name="pricePerPerson" placeholder="Price in rupees" class="form-control" value="${PACKAGE.pricePerPerson}" required="required">
				</div>
				
				<input type="hidden" name="COMMAND" value="ADD">
				
			
				<div class="form-group">
					<label for="inputName">Full Name: </label>
					<input type="text" id="fullName" name="fullName" placeholder="Enter Full Name" class="form-control" required="required">	
				</div>
				
				<div class="form-group">
					<label for="inputUnit">Address: </label>
					<input type="text" id="address" name="address" placeholder="Enter Address" class="form-control" required="required">
				</div>
				
				<div class="form-group">
					<label for="inputBI">Phone Number: </label>
					<input type="text" id="phoneNumber" name="phoneNumber" placeholder="Enter Phone Number" class="form-control" required="required">
				</div>
				
				
				
				<div class="row">
					<div class="col text-center">
						<input type="submit" value="Book Package" class="btn btn-success btn-block">
					</div>
				</div>
					
			</form>
			
			<br><br>
			
			<div style="text-align:center; margin-bottom: 20px;">
				<c:url var="listLink" value="PackageViewController">
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