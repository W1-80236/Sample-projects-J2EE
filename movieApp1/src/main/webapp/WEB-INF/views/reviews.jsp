<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reviews</title>

</head>
<body>
<center>
<h3>${title}</h3>
	Hello, ${curUser.firstName} <hr/>
	<a href="/allreviews">All Reviews</a>
	<a href="/myreviews">My Reviews</a>
	<a href="/reviewssharedwithme">Shared Reviews</a>
	<a href="/newreview">New Review</a>
	<a href="/changepassword">Change Password</a>
	<a href="/logout">Sign Out</a>
	<hr/>

	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Review</th>
				<th>Rating</th>
				<th>Modified</th>
				<th>Action</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="r" items="${reviewList}">
				<tr>
					<td>${r.id}</td>
					<td>${r.review}</td>
					<td>${r.rating}</td>
					<td><fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${r.modified}"/></td>
 					

					<td>
						<c:if test="${r.userId == curUser.id}">
							<a href="/delreview?id=${r.id}">
								<img height="24" width="24" src="delete.png" alt="Delete"/>
							</a>
							<a href="/editreview?id=${r.id}">
								<img height="24" width="24" src="edit.png" alt="Edit"/>
							</a>
							<a href="/sharereview?id=${r.id}">
								<img height="24" width="24" src="share.png" alt="Share"/>
							</a>
						</c:if>
					</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table><br/>
    
	<center/>
</body>
</html>

</body>
</html>