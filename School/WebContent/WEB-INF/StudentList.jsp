<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<li class="breadcrumb-item active" aria-current="page">Students</li>
				</ol>
			</nav>
			<div class="row mb-1">
				<div class="col-xs-12">
					<a class="btn btn-primary" href='AddStudent'>Add Student</a>
				</div>
			</div>
				<div class="row">
					<table class="table table-striped" border='1'>
						<thead>
							<tr>
								<th>Student</th>
								<th>Age</th>
								<th>Parent</th>
								<th>Email</th>
								<th>Group</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${students}" var="student">
								<tr>
									<td>${student.name}</td>
									<td>${student.age}</td>
									<td>${student.parent}</td>
									<td>${student.email}</td>
									<td>${student.group.name}</td>
									<td><a class="btn btn-primary" href="EditStudent?edit=${student.id}">Edit</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</body>

		</html>