<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Review</title>
</head>
<body>
<form method="post" action="editreview">
		Id: <input type="text" name="id" value="${review.id}" readonly/> <br/><br/>
		Review: <input type="text" name="review" value="${review.review}"/> <br/><br/>
		Rating: <input type="text" name="rating" value="${review.rating}"/> <br/><br/>
		<input type ="submit" name="Save">
		 <br/><br/>
		
	</form>
</body>
</html>