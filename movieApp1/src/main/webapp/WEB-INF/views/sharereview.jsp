<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Share Review</title>
</head>
<body>
<!--${userList}-->
     <h2>Share Review</h2>
     <form action="/sendreview?id=${reviewId}" method="post">
      <select name="userId"> 
     <c:forEach var="u" items="${userList}">
     <c:if test="${curUser.id!=u.id }">
        <option value="${u.id}">${u.firstName}</option>
         </c:if>
     </c:forEach>
     </select>
     <br>  <br>
     <input type="submit" value="Share Review"/>
     </form>
</body>
</html>