<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/17/2021
  Time: 9:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    Last name:
    <input type="text" name="last_name">
    <br>
    <button type="submit">Find</button>
</form>
<c:forEach var="user" items="${users}">
    <tr>
        <td><c:out value="${user.login}"/></td>
        <td><c:out value="${user.firstName}"/></td>
        <td><c:out value="${user.lastName}"/></td>
            <%--        <td><c:out value="${user.isBanned}"/></td>--%>
    </tr>
    <br>
</c:forEach>
<a href="home?command=admin_page">
    <button>To admin menu</button>
</a>
<%--<a href="#" onclick="history.back();return false;">Вернуться назад</a>--%>
</body>
</html>
