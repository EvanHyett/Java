<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Ninja</title>
</head>
<body>
	<h1>Create Ninja</h1>
	<form:form action="/create/ninja" method="post" modelAttribute="ninja">
			<form:label path="dojo">Select Dojo</form:label>
                <form:errors path="dojo" class= "text-danger"/>
                <form:select path="dojo" name="" id="" class="form-select">
                    <c:forEach items='${ allDojos }' var='dojoObj'>
                        <option value="${dojoObj.id}">${dojoObj.name}</option>
                    </c:forEach>
              	</form:select>
            <div>
                <form:label path="firstName">First Name</form:label>
                <form:errors path="firstName" class= "text-danger"/>
                <form:input path="firstName" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="lastName">Last Name</form:label>
                <form:errors path="lastName" class= "text-danger"/>
                <form:input path="lastName" type="text" class= "form-control"/>
            </div>
            <div>
                <form:label path="age">Age</form:label>
                <form:errors path="age" class= "text-danger"/>
                <form:input path="age" type="number" step="0.1" class= "form-control"/>
            </div>
            <div>
            </div>
            <input type="submit" value="Submit"/>
        </form:form>
        <a href="/"> Home </a>
</body>
</html>