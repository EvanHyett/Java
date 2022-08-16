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
        <h1>${bookDetail.title}</h1>
        <p>${bookDetail.uploader.userName} read ${bookDetail.title} by ${bookDetail.author}</p>
        <p> Here are ${bookDetail.uploader.userName} thoughts:</p>
        <p>${bookDetail.description}

        <c:if test='${idOfLoggedInUser == bookDetail.uploader.id}'>
            <a href="/books/edit/${bookDetail.id}">Edit</a>
            <a href="/books/delete/${bookDetail.id}">Delete</a>
        </c:if>
		<p>Back to the <a href="/home">shelves</a></p>

    </div>
</body>
</html>