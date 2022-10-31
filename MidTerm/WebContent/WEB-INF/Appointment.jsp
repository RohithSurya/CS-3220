<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
	<tr>
	<th>Appointment Time</th>
	<th>Scheduled For</th>
	<th>Department</th>
	<th>Status</th>
	<th></th>
	</tr>
	<c:forEach items="${appnts}" var="appt">
	<tr>
		<td>${appt.formatTime}</td>
		<td>${appt.name}</td>
		<td>${appt.department}</td>
		<td>${appt.status}</td>
		<td><a href="UpdateAppointment?id=${appt.id}">Update</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href='CreateAppointment'>Create Appointment</a>
</body>
</html>