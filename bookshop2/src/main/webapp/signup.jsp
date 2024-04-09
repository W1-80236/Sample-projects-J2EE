<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean"/>
	<jsp:setProperty name="rb" property="*" />
	${rb.registerUser()}
	User Registered: ${rb.count} <br/><br/>
	<a href="index.jsp">Sign In</a>
</body>
</html>