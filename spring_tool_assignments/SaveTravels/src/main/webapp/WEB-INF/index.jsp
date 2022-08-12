<!-- c:out ; c:forEach ; c:if -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<title>Save Travels</title>
</head>
<body>
	<h1>Save Travels</h1>
	<table class="table">
  <thead>
    <tr>
      <th scope="col">Expense</th>
      <th scope="col">Vendor</th>
      <th scope="col">Amount</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="expense" items="${allExpenses}">
    	<tr>
      		<td><a href="/expense/${expense.id }"> ${expense.expenseName} </a></td>
      		<td><c:out value="${expense.vendor }" /></td>
      		<td><c:out value="${expense.amount }" /></td>
      		<td><a href="/edit/${expense.id }"> Edit </a><a href="/delete/${expense.id}"> Delete </a></td>
      	</tr>
      </c:forEach>
  </tbody>
</table>
	<h1>Add an Expense</h1>
	<form:form action="/create" method="post" modelAttribute="expense">
    <p>
        <form:label path="expenseName">Expense</form:label>
        <form:errors path="expenseName" class = "text-danger"/>
        <form:input path="expenseName"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor" class = "text-danger"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount" class = "text-danger"/>
        <form:input type="number" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description" class = "text-danger"/>
        <form:textarea path="description" />
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>