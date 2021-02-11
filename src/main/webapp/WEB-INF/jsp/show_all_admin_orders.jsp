<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/31/2021
  Time: 7:48 PM
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
<c:if test="${orders != null}">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Order id</th>
            <th scope="col">Date of creation</th>
            <th scope="col">Date of complete</th>
            <th scope="col">Status</th>
            <th scope="col">Book name</th>
            <th scope="col">Book author</th>
            <th scope="col">Date of writing</th>
            <th scope="col">Price</th>
            <th scope="col">Price per day</th>
            <th scope="col">Quantity</th>
            <th scope="col">Preview</th>
            <th scope="col">Genre</th>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="order">
            <tbody>
            <tr>
                <td><c:out value="${order.key.id}"/></td>
                <td><c:out value="${order.key.dateOfCreation}"/></td>
                <td><c:out value="${order.key.orderCompleteDate}"/></td>
                <td><c:out value="${order.key.bookOrderStatus}"/></td>
                <td><c:out value="${order.value.name}"/></td>
                <td><c:out value="${order.value.author}"/></td>
                <td><c:out value="${order.value.dateOfWriting}"/></td>
                <td><c:out value="${order.value.price}"/></td>
                <td><c:out value="${order.value.pricePerDay}"/></td>
                <td><c:out value="${order.value.quantity}"/></td>
                <td width="700">
                    <p>
                        <button class="btn btn-primary" type="button" data-toggle="collapse"
                                data-target="#collapseE" aria-expanded="false" aria-controls="collapseE">
                            Show preview
                        </button>
                    </p>
                    <div class="collapse" id="collapseE">
                        <div class="card card-body">
                            <c:out value=" ${order.value.preview}"/>
                        </div>
                    </div>
                </td>
                <td><c:out value="${order.value.genre}"/></td>
            </tr>
            </tbody>
        </c:forEach>
    </table>
    <a href="home?command=complete_order">
        <button>Complete order</button>
    </a>
    <a href="home?command=admin_page">
        <button>To main page</button>
    </a>
</c:if>
<c:if test="${empt!=null}">
    <c:out value="${empt}"/>
    <a href="home?command=admin_page">
        <button>To main page</button>
    </a>
</c:if>
</body>
</html>
