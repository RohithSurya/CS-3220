<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
			integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	</head>

	<body>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
			crossorigin="anonymous"></script>


		<div class="container">
			<nav aria-label="breadcrumb">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="HomeServlet">Home</a></li>
					<li class="breadcrumb-item"><a href="GroupListServlet">Groups</a></li>
					<li class="breadcrumb-item active" aria-current="page">Add Group</li>
				</ol>
			</nav>
			<div class="row">
				<form action='AddGroup' method='post'>
					<div class="row">
						<div class="col-sm-4">
							<label for="name">Name:</label>
							<input id="name" type='text' name='name' class="form-control">
						</div>
					</div>
					<div class="row mt-2">
						<div class="col-sm-4">
							<button class="btn btn-success">Add</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>

	</html>