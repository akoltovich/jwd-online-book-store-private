<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/28/2021
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>
</head>
<body>
<c:forEach var="book" items="${books}">
    <tr>
        <td><c:out value="${book.id}"/></td>
        <td><c:out value="${book.name}"/></td>
        <td><c:out value="${book.author}"/></td>
        <td><c:out value="${book.dateOfWriting}"/></td>
        <td><c:out value="${book.price}"/></td>
        <td><c:out value="${book.pricePerDay}"/></td>
        <td><c:out value="${book.quantity}"/></td>
        <td><c:out value="${book.preview}"/></td>
        <td><c:out value="${book.genre}"/></td>
    </tr>
    <br>
</c:forEach>
<c:if test="${sessionScope.user.roleId == 1}">
    <br>
    <a href="home?command=delete_book">
        <button>Delete book!</button>
    </a>
    <a href="home?command=admin_page">
        <button>To admin page</button>
    </a>
</c:if>
<c:if test="${sessionScope.user.roleId == 2}">
    <a href="home?command=user_page">
        <button>To user page</button>
    </a>
</c:if>
<a href="home?command=main_page">
    <button>To main page</button>
</a>

</body>
</html>
