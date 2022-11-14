<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
			<!DOCTYPE html>
			<html>

			<head>
				<meta charset="ISO-8859-1">
				<title>Insert title here</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
					crossorigin="anonymous">
			</head>

			<body>
				<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
					integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8"
					crossorigin="anonymous"></script>
				
				<div class="container">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="HomeServlet">Home</a></li>
							<li class="breadcrumb-item"><a href="StudentListServlet">Students</a></li>
							<li class="breadcrumb-item active" aria-current="page">Create Student</li>
						</ol>
					</nav>
					<div class="row">
						<form action='AddStudent' method='post'>
							<div class="row">
								<div class="col-sm-4">
									<label for="name">Name:</label>
									<input id="name" type='text' name='name' class="form-control">
								</div>
							</div>
							<div class="row">
								<div class="col-sm-4">
									<label for="birth">Birth Year</label>
									<input id="birth" type='text' name='year' class="form-control">
								</div>
							</div>

							<div class="row">
								<div class="col-sm-4">
									<label for="parentName">Parent Name</label>
									<input id="parentName" type='text' name='parentName' class="form-control">
								</div>
							</div>

							<div class="row">
								<div class="col-sm-4">
									<label for="parentEmail">Parent Email</label>
									<input id="parentEmail" type='text' name='parentEmail' class="form-control">
								</div>
							</div>

							<div class="row">
								<div class="col-sm-4">
									<label for="group">Group</label>
									<select name='group' class="form-control">
										<option></option>
										<c:forEach items="${groups}" var="group">
											<option value="${group.id}">${group.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>

							<div class="row mt-1">
								<div class="col-sm-4">
									<button class="btn btn-success">Add</button>
								</div>
							</div>
						</form>
					</div>
				</div>


			</body>

			</html>