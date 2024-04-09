<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Review</title>
</head>
<body>
	<form method="post" action="/savereview">
		Review: <input type="text" name="review"/> <br/><br/>
		Rating: <input type="text" name="rating"/> <br/><br/>
		Movie: <select name="movieId">
			<c:forEach var="m" items="${movieList}">
				<option value="${m.id}">${m.title}</option>		
			</c:forEach>
		</select> <br/><br/>
		<input type="submit" value="Submit"/> <br/><br/>
	</form>
</body>
</html>