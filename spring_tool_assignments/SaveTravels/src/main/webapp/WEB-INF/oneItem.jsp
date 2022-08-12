<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Info about ${expense.expense}</h1>
	<p>Vendor: ${expense.vendor}</p>
	<p>Amount: ${expense.amount}</p>
	<p>Description: ${expense.description}</p>
	<a href="/" >Home</a>
</body>
</html>