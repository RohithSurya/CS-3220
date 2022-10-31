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
	<form action='CreateAppointment' method='post'>

		<table border='1'>
			<tr>
			<th>Your Name:</th>
			<td>
				<input type='text' name='name'>
			</td>
			</tr>
			
			<tr>
			<th>Appointment Time:</th>
			<td>
				<select name="apptTime">
				  <option value="11:00">11:00 AM</option>
				  <option value="11:30">11:30 AM</option>
				  <option value="12:00">12:00 PM</option>
				  <option value="12:30">12:30 PM</option>
				  <option value="13:00">1:00 PM</option>
				  <option value="13:30">1:30 PM</option>
				  <option value="14:00">2:00 PM</option>
				  <option value="14:30">2:30 PM</option>
				  <option value="15:30">3:30 PM</option>
				  <option value="16:00">4:00 PM</option>
				  <option value="16:30">4:30 PM</option>
				</select>
			</td>
			</tr>
			
			<tr>
			<th> Department:</th>
			<td>
				<select name="departments" multiple>
				  <option value="Computers">Computers</option>
				  <option value="Video Games">Video Games</option>
				  <option value="Appliances">Appliances</option>
				  <option value="Movies">Movies</option>
				</select>
			</td>
			</tr>
			
			<tr>
			<th>Reason:</th>
			<td>
				<textarea name="reason" rows="4" cols="50"></textarea>
			</td>
			</tr>
			
			<tr>
				<td colspan='2'> <button>Create</button> </td>
			</tr>
		</table>
	</form>
</body>
</html>