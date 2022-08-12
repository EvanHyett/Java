<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<h1>Edit Expense</h1>
	<form:form action="/update/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="expenseName">Expense</form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>