<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/17/2021
  Time: 7:11 PM
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
Hello,boss
${sessionScope.user.firstName}
${sessionScope.user.lastName}
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <%--    <a class="navbar-brand" href="home?command=main_page">Main page</a>--%>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="home?command=sign_out">Sign out<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="home?command=admin_area">Personal area</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="home?command=show_all_admin_orders">Show all orders verified by me</a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="home?command=show_orders_by_status">Show orders by status</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Find books:
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="home?command=books_by_name">By name</a>
                    <a class="dropdown-item" href="home?command=by_price">By price</a>
                    <a class="dropdown-item" href="home?command=by_author">By author</a>
                    <a class="dropdown-item" href="home?command=by_genre">By genre</a>
                    <a class="dropdown-item" href="home?command=all_books">Show all books</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenu" role="button"
                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Find users:
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="home?command=user_by_login">By login</a>
                    <a class="dropdown-item" href="home?command=users_by_first_name">By first name</a>
                    <a class="dropdown-item" href="home?command=users_by_last_name">By last name</a>
                    <a class="dropdown-item" href="home?command=all_users">Show all users</a>
                    <a class="dropdown-item" href="home?command=banned_users">Show banned users</a>
                </div>
            </li>
            <%--            <li class="nav-item dropdown">--%>
            <%--                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownShow" role="button"--%>
            <%--                   data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
            <%--                Show orders by status:--%>
            <%--                </a>--%>
            <%--            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">--%>
            <%--                    <a class="dropdown-item" href="home?command=show_orders_by_status">Awaiting confirmation--%>
            <%--                    <button type="submit" name="status" value="Awaiting confirmation"> </button></a>--%>
            <%--                    <a class="dropdown-item" href="home?command=show_orders_by_status?status=In progress">In progress</a>--%>
            <%--                    <a class="dropdown-item" href="home?command=show_orders_by_status?status=Completed">Completed</a>--%>
            <%--                </div>--%>
            <%--            </li>--%>
<%--            <li>--%>
<%--                <div class="dropdown">--%>
<%--                    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2"--%>
<%--                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
<%--                        Show orders by status--%>
<%--                    </button>--%>
<%--                    <div class="dropdown-menu" aria-labelledby="dropdownMenu2">--%>
<%--                        <a href="home?command=show_orders_by_status">--%>
<%--                        <button class="dropdown-item" name="status" value="Awaiting confirmation" type="button">Awaiting confirmation</button>--%>
<%--                        </a>--%>
<%--                        <button class="dropdown-item" type="button">Another action</button>--%>
<%--                        <button class="dropdown-item" type="button">Something else here</button>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </li>--%>
        </ul>
    </div>
</nav>
</body>
</html>
