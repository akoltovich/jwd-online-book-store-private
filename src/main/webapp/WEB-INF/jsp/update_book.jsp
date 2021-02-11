<%--
  Created by IntelliJ IDEA.
  User: alexe
  Date: 1/28/2021
  Time: 2:27 AM
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
    <div class="form-group row">
        <label for="ID" class="col-sm-2 col-form-label">ID of updated book</label>
        <div class="col-sm-5">
            <input type="number" class="form-control" id="ID" name="id" aria-describedby="nameHelp"
                   placeholder="Enter book id">
        </div>
    </div>
    <div class="form-group row">
        <label for="Name" class="col-sm-2 col-form-label">Name</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="Name" name="name" aria-describedby="nameHelp"
                   placeholder="Enter book name">
        </div>
    </div>
    <div class="form-group row">
        <label for="Author" class="col-sm-2 col-form-label">Author</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="Author" name="author" placeholder="Enter author name">
        </div>
    </div>
    <div class="form-group row">
        <label for="dateOfWriting" class="col-sm-2 col-form-label">Date of writing</label>
        <div class="col-sm-5">
            <input type="date" class="form-control" id="dateOfWriting" name="date_of_writing" aria-describedby="Name"
                   placeholder="Enter date of writing">
        </div>
    </div>
    <div class="form-group row">
        <label for="price" class="col-sm-2 col-form-label">Price</label>
        <div class="col-sm-5">
            <input type="number" class="form-control" id="price" name="price" aria-describedby="Last"
                   placeholder="Enter price">
        </div>
    </div>
    <div class="form-group row">
        <label for="quantity" class="col-sm-2 col-form-label">Quantity</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="quantity" name="quantity" aria-describedby="Last"
                   placeholder="Enter quantity">
        </div>
    </div>
    <div class="form-group row">
        <label for="preview" class="col-sm-2 col-form-label">Preview</label>
        <div class="col-sm-5">
            <textarea type="text" class="form-control" id="preview" name="preview" rows="3" aria-describedby="Last"
                      placeholder="Enter preview"></textarea>
        </div>
    </div>
    <div class="form-group row">
        <label for="genre" class="col-sm-2 col-form-label">Genre</label>
        <div class="col-sm-5">
            <input type="text" class="form-control" id="genre" name="genre" aria-describedby="Last"
                   placeholder="Enter genre">
        </div>
    </div>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">Update book</button>
        </div>
    </div>
</form>
</body>
</html>
