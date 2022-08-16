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
<title>Book Club</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
	<div class="container">
         <h1>Change your Entry!</h1>
         <form:form action="/books/update/${book.id}" method="post" modelAttribute="book">
             <input type="hidden" name="_method" value="put"> 
             <form:input type="hidden" path="uploader" value="${idOfLoggedInUser}"/>
             <div> 
                 <form:label path="title">Title:</form:label>
                 <form:errors path="title" class = "text-danger"/>
                 <form:input path="title" type="text" class= "form-control"/>
             </div>
             <div>
                 <form:label path="author">Author:</form:label>
                 <form:errors path="author" class = "text-danger"/>
                 <form:input path="author" type="text" step="0.1" class= "form-control"/>
             </div>
             <div>
                 <form:label path="description">My Thoughts:</form:label>
                 <form:errors path="description" class = "text-danger"/>
                 <form:textarea path="description" type="text" class= "form-control"/>
             </div>
             <input type="submit" value="Submit" class= "btn btn-success mt-3"/>
         </form:form>
		<p>Back to the <a href="/home">shelves</a></p>
         <hr>
         <c:if test='${idOfLoggedInUser == idea.getUploader().getId()}'>
            <a href="/book/delete/${book.id}">Delete Entry</a>
         </c:if>
     </div>
</body>
</html>