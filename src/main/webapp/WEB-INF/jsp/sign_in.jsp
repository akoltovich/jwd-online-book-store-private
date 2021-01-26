<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/13/2021
  Time: 2:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
This is sign in page
<form method="post">
    Login:
    <input type="email" name="login">
    <br>
    Password:
    <input type="password" name="password">
    <br>
    <a href="home?command=sign_in">
        <button>Sign in!</button>
    </a>
</form>
<a href="home?command=user_change_password">
    <button>Forgot my password</button>
</a>
</body>
</html>
