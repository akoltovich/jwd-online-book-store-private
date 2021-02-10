<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/11/2021
  Time: 3:25 PM
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
<%--<form method="post">--%>
<%--    Email:--%>
<%--    <input type="email" name="login">--%>
<%--    <br>--%>
<%--    Password:--%>
<%--    <input type="password" name="password">--%>
<%--    <br>--%>
<%--    First name:--%>
<%--    <input type="text" name="first_name">--%>
<%--    <br>--%>
<%--    Last name:--%>
<%--    <input type="text" name="last_name">--%>
<%--    <br>--%>
<%--    Role:--%>
<%--    <input type="radio" name="role_id" value="1" checked> Admin--%>
<%--    <input type="radio" name="role_id" value="2"> User--%>
<%--    <br>--%>
<%--    <input type="submit">--%>
<form method="post">
    <div class="form-group row">
        <label for="Email" class="col-sm-2 col-form-label">Email address</label>
        <div class="col-sm-5">
            <input type="email" class="form-control" id="Email" name="login" aria-describedby="emailHelp"
                   placeholder="Enter email">
        </div>
    </div>
    <div class="form-group row">
        <label for="Password" class="col-sm-2 col-form-label">Password</label>
        <div class="col-sm-5">
            <input type="password" class="form-control" id="Password" name="password" placeholder="Enter password">
            <small id="Password1" class="form-text text-muted">Password must contain eight characters, at least one
                letter and one number</small>
        </div>
    </div>
    <div class="form-group row">
        <label for="firstName" class="col-sm-2 col-form-label">First name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="firstName" name="first_name" aria-describedby="Name"
                   placeholder="Enter first name">
        </div>
    </div>
    <div class="form-group row">
        <label for="lastName" class="col-sm-2 col-form-label">Last name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="lastName" name="last_name" aria-describedby="Last"
                   placeholder="Enter last name">
        </div>
    </div>
    <fieldset class="form-group">
        <div class="row">
            <legend class="col-form-label col-sm-2 pt-0">Role</legend>
            <div class="col-sm-5">
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role_id" id="gridRadios1" value="1">
                    <label class="form-check-label" for="gridRadios1">
                        Admin
                    </label>
                </div>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="role_id" id="gridRadios2" value="2" checked>
                    <label class="form-check-label" for="gridRadios2">
                        User
                    </label>
                </div>
            </div>
        </div>
    </fieldset>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Sign up</button>
        </div>
    </div>
    <%--    </div>--%>
</form>
<%--        <button type="submit" class="btn btn-primary">Sign up!</button>--%>
<%--</form>--%>
<%--</form>--%>
</body>
</html>
