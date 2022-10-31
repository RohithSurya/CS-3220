<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b>${appt.department} Service requested by ${appt.name} at ${appt.formatTime } </b>
	<br>
	<b>Status:</b>
	<c:choose>
		<c:when test="${appt.status == 'Assigned'}">
			Assigned to ${appt.assignedTo}
		</c:when>
		<c:otherwise>
			${appt.status}
		</c:otherwise>
	</c:choose>	
	<br>
	<b>Reason</b> <br>
	${appt.reason}
	<br>
	
	
	<c:choose>
		<c:when test="${appt.status == 'Scheduled'}">
			<form action='UpdateAppointment' method='post'>
				<b>Assign this request to</b>
				<input type='hidden' name='id' value='${appt.id}'>
							<select name="emp">
							  <option>Amy</option>
							  <option>Joseph</option>
							  <option>Maria</option>
							  <option>Tintin</option>
							</select>
							<button>Ok</button>
			</form>
		</c:when>
		<c:when test="${appt.status == 'Assigned'}">
			<b>Change the status to Completed?</b>
			<a href="CompleteAppointment?id=${appt.id}">Yes</a>
			<a href="Appointments">No</a>
			<a href="CancelAppointment?id=${appt.id}">Cancelled</a>
		</c:when>
	</c:choose>
	
	
	
	
</body>
</html>