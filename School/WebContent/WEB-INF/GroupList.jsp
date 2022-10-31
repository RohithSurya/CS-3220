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
						<li class="breadcrumb-item active" aria-current="page">Groups</li>
					</ol>
				</nav>
				<div class="row">
					<div class="col-xs-12">
						<a class="btn btn-primary m-2" href='AddGroup'>Add Group</a>
						<div class="row">
							<div class="col-xs-8">
								<table class="table" border='1'>
									<tr>
										<th>Group</th>
										<th>Members</th>
										<th></th>
									</tr>
									<c:forEach items="${groups}" var="group">
										<tr>
											<td>${group.name}</td>
											<td>
												${group.studentNames}
											</td>
											<td>
												<a class="btn btn-primary" href="EditGroup?group=${group.id}">Edit</a>
											</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</body>

		</html>