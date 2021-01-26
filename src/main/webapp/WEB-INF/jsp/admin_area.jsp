<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/17/2021
  Time: 7:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
This is admin area
<a href="home?command=self_delete">
    <button>Delete me pls!(admin)</button>
</a>
<a href="home?command=user_change_first_name">
    <button>Update my first name pls!(admin)</button>
</a>
<a href="home?command=admin_page">
    <button>To admin page</button>
</a>
<a href="home?command=user_change_first_name">
    <button>Change my first name</button>
</a><a href="home?command=user_change_last_name">
    <button>Change my last name</button>
</a><a href="home?command=user_change_login">
    <button>Change my email</button>
</a>
</body>
</html>
