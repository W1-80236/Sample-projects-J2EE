<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><!--  
<form method="post" action="/register">
		First Name: <input type="text" name="firstName"/> <br/><br/>
		Last Name: <input type="text" name="lastName"/> <br/><br/>
		Email: <input type="text" name="email"/> <br/><br/>
		Mobile: <input type="text" name="mobile"/> <br/><br/>
		Password: <input type="password" name="password"/> <br/><br/>
		Birth: <input type="date" name="birth"/> <br/><br/>
		<input type="submit" value="Sign Up"/>
	</form>-->
	<!--  
	<sf:form modelAttribute="usr" action="/saveuser">
		First Name: <sf:input path="firstName"/> <br/><br/>
		Last Name: <sf:input path="lastName"/> <br/><br/>
		Email: <sf:input path="email"/> <br/><br/>
		Mobile: <sf:input path="mobile"/> <br/><br/>
		Password: <sf:password path="password"/> <br/><br/>
		Birth: <sf:input type="date" path="birth"/> <br/><br/>
		<input type="submit" value="Sign Up"/>
	</sf:form>-->
	<sf:form modelAttribute="usr" action="/saveuser">
	First Name: <sf:input path="firstName"/> <sf:errors path="firstName" cssStyle="color:red;"/> <br/><br/>
		Last Name: <sf:input path="lastName"/> <sf:errors path="lastName" cssStyle="color:red;"/> <br/><br/>
		Email: <sf:input path="email"/> <sf:errors path="email" cssStyle="color:red;"/> <br/><br/>
		Mobile: <sf:input path="mobile"/> <sf:errors path="mobile" cssStyle="color:red;"/> <br/><br/>
		Password: <sf:password path="password"/> <sf:errors path="password" cssStyle="color:red;"/> <br/><br/>
		Birth: <sf:input type="date" path="birth"/> <sf:errors path="birth" cssStyle="color:red;"/> <br/><br/>
 		<input type="submit" value="Sign Up"/>
 	</sf:form>
	
</body>
</html>