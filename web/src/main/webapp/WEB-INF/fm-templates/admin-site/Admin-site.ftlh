<!DOCTYPE html>
<html lang="en">
<head>
    <title>Admin Panel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="/../../../html/js/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

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
            <a class="dropdown-item" href="/admin/add-book">Dodaj</a>
            <a class="dropdown-item" href="/admin/list-book">Lista</a>
        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
            Użytkownicy
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" id="1" href="#">dodaj</a>
            <a class="dropdown-item" id="3" href="#">edytuj</a>
            <a class="dropdown-item" id="2" href="#">usuń</a>

        </div>
    </div>
    <div class="btn-group">
        <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                aria-expanded="false">
           Powrót na strone
        </button>
        <div class="dropdown-menu">
            <a class="dropdown-item" href="/">Wróć</a>
        </div>
    </div>

    <div class="container" style="margin-top:30px">

        <#if content??>
            <#include "/${content}">
        </#if>
    </div>
    <div>
        <form method="post" action="/uploader" enctype="multipart/form-data">

            <header>Awaryjne ładowanie API z pliku</header>
            <input type="file" accept="application/JSON" name="api">
            <input type="submit" name="upload" value="Upload">
        </form>
    </div>

</div>

<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">Usuwanie </h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Modal body -->
            <div class="modal-body" style="color: #0b0b0b" >
                </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="location.reload()">Close</button>
            </div>

        </div>
    </div>
</div>
</body>
</html>

