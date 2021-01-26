<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/16/2021
  Time: 8:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="author">
    <button type="submit">Find</button>
</form>
<c:forEach var="book" items="${books}">
    <tr>
        <td><c:out value="${book.name}"/></td>
        <td><c:out value="${book.author}"/></td>
        <td><c:out value="${book.dateOfWriting}"/></td>
        <td><c:out value="${book.price}"/></td>
        <td><c:out value="${book.pricePerDay}"/></td>
        <td><c:out value="${book.quantity}"/></td>
        <td><c:out value="${book.preview}"/></td>
        <td><c:out value="${book.genre}"/></td>
    </tr>
<%--    <a href="home?command=main_page">--%>
<%--        <button>To main page</button>--%>
<%--    </a>--%>
    <br>
</c:forEach>
<%--<a href="#" onclick="history.back();return false;">Вернуться назад</a>--%>
<c:if test="${sessionScope.user.roleId == 1}">
    <a href="home?command=admin_page">
        <button>To admin page</button>
    </a>
</c:if>
<c:if test="${sessionScope.user.roleId == 2}">
    <a href="home?command=user_page">
        <button>To user page</button>
    </a>
</c:if>
</body>
</html>
