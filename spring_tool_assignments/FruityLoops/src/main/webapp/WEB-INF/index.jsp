<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Fruity Loops</title>
	</head>
	<body>
		<h1>
			Fruit Store
		</h1>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="fruits" items="${fruits}">
					<tr>
						<td><c:out value="${fruits.name }" /></td>
						<td><c:out value="${fruits.price }" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>