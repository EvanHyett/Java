<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo</title>
</head>
<body>
	<h1> ${showDojo.name } Location Ninjas</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${showDojo.ninjas }" var="ninjaObj">
				<tr>
					<th>${ninjaObj.firstName }</th>
					<th>${ninjaObj.lastName }</th>
					<th>${ninjaObj.age }</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/"> Home </a>
</body>
</html>