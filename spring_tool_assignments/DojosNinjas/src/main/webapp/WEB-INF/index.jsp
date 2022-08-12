<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
	<h1>NEW DOJO</h1>
	<form:form action="/" method="post" modelAttribute="dojo">
            <p>
                <form:label path="name">Name:</form:label>
                <form:errors path="name" class= "text-danger"/>
                <form:input path="name" type="text" class= "form-control"/>
            </p>
            <input type="submit" value="Create"/>
            <a href="add/ninja"> Add Ninja </a>
        </form:form>
        <p>
        	<c:forEach var="dojo" items="${allDojos}">
    			<tr>
      				<td><a href="/dojos/${dojo.id }"> ${dojo.name} </a></td>
      			</tr>
      		</c:forEach>
        </p>
</body>
</html>