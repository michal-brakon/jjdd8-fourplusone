<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="/../../../html/js/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="/../../../html/js/datatables/jquery.dataTables.min.js"></script>
    <script src="/../../../html/js/datatables/dataTables.bootstrap4.min.js"></script>
    <script src="/../../../html/js/demo/datatables-demo.js"></script>
    <!-- Page level custom scripts -->

</head>
<body>
<div class="container p-3 my-3 bg-dark text-white">
    <div class="btn-group">
        <button type="button" class="btn btn-danger dropdown-toggle " data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
            Zarządzanie Książkami
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">Dodaj</a>
            <a class="dropdown-item" href="/list-book">Lista</a>
            <a class="dropdown-item" href="#">Usuń rezerwacje </a>
        </div>
        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
            Użytkownicy
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">dodaj</a>
            <a class="dropdown-item" href="#">edytuj</a>
            <a class="dropdown-item" href="#">usuń</a>

        </div>
        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
            Ulubione
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="#">usuń</a>
        </div>
    </div>

    <div class="container" style="margin-top:30px">

        <#if content??>
            <#include "/${content}">
        </#if>

<div class="row">

    <div class="col-sm-8">
        <h2>TITLE HEADING</h2>
        <h5>Title description, Dec 7, 2017</h5>
        <div class="fakeimg">Fake Image</div>
        <p>Some text..</p>
        <#if Error??>
            <h3>nie można znaleźć książki</h3>
        <#else>
            <form method="put" action="/mmanagement/edit" enctype="multipart/form-data">
                Id: <input type="number" name="id" value="${id !""}"/>
                Author: <input type="text" name="author" value="${author !""}"/><br/><br/>
                title : <input type="text" name="title" value="${title !""}"/><br/><br/>
                typ literatury: <input type="text" name="kind" value="${kind !""}"/><br/><br/>
                Rodzaj: <input type="text" name="genre" value="${genre !""}"/><br/><br/>
                Epoka : <input type="text" name="epoch" value="${epoch !""}"/><br/><br/>
                Cover: <input type="file" name="cover" value="${cover !""}"/><br/><br/>
                <input type="button" name="save" value="Save" onclick="bookEdit()"/><br/><br/>
            </form>     </#if> <br>
    </div>

</div>
</div>


<div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>

</div>
<div class="jumbotron text-center" style="margin-bottom:0">
    <ul class="user-list"></ul>
</div>
<script src="../../../html/js/uisearch.js"></script>

</body>
</html>

