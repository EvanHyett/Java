<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Namaste, ${loggedInUser.name} </h1>
		<h4>Course Schedule</h4>
		<a href="/yoga/new">Add a new course!</a>
	    <a href="/logout">Logout</a>
	    <table class="table">
            <thead>
              <tr>
                <th scope="col">Class Name</th>
                <th scope="col"></th>
                <th scope="col">Instructor</th>
                <th scope="col">Weekday</th>
                <th scope="col">Price</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allYoga}' var='yogaObj'>
                    <tr>
                        <td><a href="/yoga/details/${yogaObj.id}">${yogaObj.name}</a></td>
                        <td>
                        	<c:if test='${loggedInUser.id == yogaObj.uploader.id}'>
					            <a href="/yoga/edit/${yogaObj.id}">Edit</a>
					        </c:if>
					    </td>
                        <td>${yogaObj.uploader.name}</td>
                        <td>${yogaObj.dayOfWeek}</td>
                        <td>${yogaObj.price}</td>
                    </tr>
                </c:forEach>
              
            </tbody>
          </table>
      </div>
</body>
</html>