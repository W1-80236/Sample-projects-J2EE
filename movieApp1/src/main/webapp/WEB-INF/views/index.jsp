<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
<center>
<h1>Login Page</h1><hr/>
    <form action="login" method="post">
        Email: <input type="text" name="email"/> <br/></br>
        Password: <input type="password" name="passwd"/> <br/></br>
          <input type="submit" value="Sign In"/>
   
    </form>
    <br>
    <form action="register" method="post">
 
        <input type="submit" value="Sign Up"/>
        
    </form>
    
 </center>   
</body>
</html>