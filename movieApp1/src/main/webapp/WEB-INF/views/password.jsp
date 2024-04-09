<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Change Password</title>
</head>
<body>

<h1>Change Password</h1><hr/>
<form action="/updatepassword" method="post">
        <!--  Enter Old Password: <input type="text" name="passwd" /> <br/><br/>-->
		Enter New Password: <input type="text" name="passwd" /> <br/><br/>
		<!--Confirm Password:   <input type="text" name="passwd" /> <br/><br/>-->
		<input type ="submit" value="Save Password"/>
</form>
</body>
</html>