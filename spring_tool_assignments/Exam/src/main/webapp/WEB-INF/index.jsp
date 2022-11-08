<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
</head>
<body>
	<div class="container">
	<h1>Course Platform - Instructors</h1>
	<h4>A place for friends to share thoughts on books</h4>
        <div class="row">
            <div class="col">
                <form:form action="/register" method="post" modelAttribute="newUser">
                <h3>Register</h3>
                    <div>
                        <form:label path="name">Name</form:label>
                        <form:errors path="name"/>
                        <form:input path="name" type="text" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="email">Email</form:label>
                        <form:errors path="email"/>
                        <form:input path="email" type="email" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="password">Password</form:label>
                        <form:errors path="password"/>
                        <form:input path="password" type="password" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="confirm">Confirm Password</form:label>
                        <form:errors path="confirm"/>
                        <form:input path="confirm" type="password" class= "form-control"/>
                    </div>
                    
                    <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
                </form:form>   
            </div>
            <div class="col">
                <h3>Login:</h3>
                <form:form action="/login" method="post" modelAttribute="newLogin">

                    <div>
                        <form:label path="email">Email</form:label>
                        <form:errors path="email"/>
                        <form:input path="email" type="email" class= "form-control"/>
                    </div>
                    <div>
                        <form:label path="password">Password</form:label>
                        <form:errors path="password"/>
                        <form:input path="password" type="password" class= "form-control"/>
                    </div>
                    
                    <input type="submit" value="Login" class= "btn btn-success mt-3"/>
                </form:form>   
            </div>
        </div>
    </div>
</body>
</html>