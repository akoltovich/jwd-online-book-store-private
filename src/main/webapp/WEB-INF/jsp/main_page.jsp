<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/15/2021
  Time: 4:00 PM
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

<!-- Кнопка, открывающее модальное окно -->
<%--<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#SignUp">--%>
<%--    Sign up!--%>
<%--</button>--%>
<!-- Модальное окно -->
<%--<div class="modal fade" id="SignUp" tabindex="-1" role="dialog" aria-labelledby="SignUp" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--        <div class="modal-content">--%>
<%--            <div class="modal-header">--%>
<%--                <button type="button" class="close" data-dismiss="modal" aria-label="Закрыть">--%>
<%--                    <span aria-hidden="true">×</span>--%>
<%--                </button>--%>
<%--                <h4 class="modal-title" id="myModalLabel">Registration</h4>--%>
<%--            </div>--%>
<%--            <div class="modal-body">--%>
<%--                <form method="post">--%>
<%--                    <c:import url="registration.jsp"/>--%>
<%--                    <input type="hidden" name="command" value="registration">--%>
<%--                    Login:--%>
<%--                    <input type="email" name="login">--%>
<%--                    <br>--%>
<%--                    Password:--%>
<%--                    <input type="password" name="password">--%>
<%--                    <br>--%>
<%--                    First name:--%>
<%--                    <input type="text" name="first_name">--%>
<%--                    <br>--%>
<%--                    Last name:--%>
<%--                    <input type="text" name="last_name">--%>
<%--                    <br>--%>
<%--                                        <a href="home?command=user_page">--%>
<%--                                            <input type="submit">--%>
<%--                                        </a>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <div class="modal-footer">--%>
<%--                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
<%--                <a href="home?command=user_page">--%>
<%--                    <button type="submit" class="btn btn-primary">Submit</button>--%>
<%--                </a>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<%--    <a class="navbar-brand" href="home?command=main_page">Main page</a>--%>
<%--    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"--%>
<%--            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">--%>
<%--        <span class="navbar-toggler-icon"></span>--%>
<%--    </button>--%>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="home?command=registration">Sign up <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="home?command=sign_in">Sign in</a>
            </li>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link" href="home?command=error">Error</a>--%>
<%--            </li>--%>
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
        </ul>
    </div>
</nav>
<%--<a href="home?command=registration">--%>
<%--    <button>Sign Up</button>--%>
<%--</a>--%>
<%--<a href="home?command=sign_in">--%>
<%--    <button>Sign In</button>--%>
<%--</a>--%>
<%--<a href="home?command=error">--%>
<%--    <button>Error page</button>--%>
<%--</a>--%>

</body>
</html>
