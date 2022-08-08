<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Omikuji Form</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<h1 class="text-center">Here's Your Omikuji</h1>
	<p class="text-center mt-4 container border border-dark mb-4 p-4 bg-primary">In <c:out value="${num }" /> years, you will live in <c:out value="${cityName }" /> with <c:out value="${personName }" /> 
		as your roommate, <c:out value="${hobbyName }" /> for a living. The next time you see a <c:out value="${livingThingName }" />, 
		you will have good luck. Also, <c:out value="${descriptionName }" /> </p>
	<div class="text-center">
		<a class="back" href="/">Go Back</a>
	</div>
</body>
</html>