<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@ page isErrorPage="true" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
        <h1>Create a Course</h1>
        <form:form action="/yoga/create" method="post" modelAttribute="yoga">
            <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}" />
            <div> 
                <form:label path="name">Name:</form:label>
                <form:errors path="name" class = "text-danger"/>
                <form:input path="name" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="dayOfWeek">Day of Week:</form:label>
                <form:errors path="dayOfWeek" class = "text-danger"/>
                <form:input path="dayOfWeek" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="price">Drop-in Price:</form:label>
                <form:errors path="price" class = "text-danger"/>
                <form:input path="price" type="number" class= "form-control"/>
            </div>
            <div>
                <form:label path="description">Description:</form:label>
                <form:errors path="description" class = "text-danger"/>
                <form:textarea path="description" type="text" class= "form-control"/>
            </div>
            <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
        </form:form>
        <p><a href="/home">Cancel</a></p>
    </div>
</body>
</html>