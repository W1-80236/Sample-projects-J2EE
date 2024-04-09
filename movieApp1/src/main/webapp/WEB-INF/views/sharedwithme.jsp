<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shared Reviews</title>
</head>
<body>

 <h1>Reviews Shared With Me</h1>

 <table border="1">
  <thead>
      <tr>
          <th>MovieId</th>
          <th>Review</th>
          <th>Rating</th>
          <th>userId</th>    
      </tr>
  </thead>
  <tbody>
    <c:forEach var="r" items="${reviewList}">
      <tr> 
          <td>${r.movieId}</td>
          <td>${r.review}</td>
          <td>${r.rating}</td>
          <td>${r.userId}</td>
      </tr>
    </c:forEach>
  </tbody>
 </table>
 
</body>
</html>