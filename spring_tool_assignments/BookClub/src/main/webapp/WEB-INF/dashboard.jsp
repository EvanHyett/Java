<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Club</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Welcome, ${loggedInUser.userName} </h1>
		<h4>Books from everyone's shelves.</h4>
		<a href="/books/new">Add a Book to My Shelf!</a>
	    <a href="/logout">Logout</a>
	    <table class="table">
            <thead>
              <tr>
                <th scope="col">ID#</th>
                <th scope="col">Title</th>
                <th scope="col">Author</th>
                <th scope="col">Posted By</th>
              </tr>
            </thead>
            <tbody>
                <c:forEach items='${ allBooks}' var='bookObj'>
                    <tr>
                        <th scope="row">${bookObj.id}</th>
                        <td><a href="/books/details/${bookObj.id}">${bookObj.title}</a></td>
                        <td>${bookObj.author}</td>
                        <td>${bookObj.uploader.userName}</td>
                    </tr>
                </c:forEach>
              
            </tbody>
          </table>
      </div>
</body>
</html>