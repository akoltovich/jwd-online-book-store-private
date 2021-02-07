<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/16/2021
  Time: 8:28 PM
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
<form method="post">
    From:
    <input type="text" name="from">
    To:
    <input type="text" name="to">
    <button type="submit">Find</button>
</form>
<c:if test="${books != null}">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Author</th>
            <th scope="col">Date of writing</th>
            <th scope="col">Price</th>
            <th scope="col">Price per day</th>
            <th scope="col">Quantity</th>
            <th scope="col">Preview</th>
            <th scope="col">Genre</th>
        </tr>
        </thead>
        <c:forEach var="book" items="${books}">
            <tbody>
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
            </tbody>
        </c:forEach>
    </table>
</c:if>
<c:if test="${empt != null}">
    <c:out value="${empt}"/>
</c:if>
<c:if test="${sessionScope.user.roleId == 1}">
    <a href="home?command=admin_page">
        <button>To admin page</button>
    </a>
    <br>
    <a href="home?command=delete_book">
        <button>Delete book!</button>
    </a>
    <a href="home?command=add_book">
        <button>Add new book in the store!</button>
    </a>
    <a href="home?command=update_book">
        <button>Update book!</button>
    </a>
</c:if>
<c:if test="${sessionScope.user.roleId == 2}">
    <a href="home?command=user_page">
        <button>To user page</button>
    </a>
    <br>
    <a href="home?command=order_book">
        <button>Order book!</button>
    </a>
</c:if>
<c:if test="${sessionScope.user == null}">
    <a href="home?command=main_page">
        <button>To main page</button>
    </a>
</c:if>
</body>
</html>
