<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
</head>
<body>
    <form action="fc?page=signup" method="post">
        Name: <input type="text" name="name"/> <br/><br/>
        Email: <input type="text" name="email"/> <br/><br/>
        Mobile: <input type="text" name="mobile"/> <br/><br/>
        Address: <input type="text" name="address"/> <br/><br/>
        Birth: <input type="date" name="birth"/> <br/><br/>
        Password: <input type="password" name="password"/> <br/><br/>
        <input type="submit" value="Sign Up"/>
       <a href="fc?page=index">Sign In</a>
    </form>
</body>
</html>
