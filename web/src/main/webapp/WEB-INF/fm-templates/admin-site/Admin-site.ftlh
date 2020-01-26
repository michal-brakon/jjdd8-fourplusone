<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap 4 Website Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        let id;

        function bookEdit() {

            $.ajax({
                url: '/update',
                method: 'PUT',
                data: {
                    id: $('input[name=id]').val(),
                    title: $('input[name=title]').val(),
                    author: $('input[name=author]').val(),
                    kind: $('input[name=kind]').val(),
                    genre: $('input[name=genre]').val(),
                    epoch: $('input[name=epoch]').val(),
                    cover: $('input[name=cover]').val(),

                }
            })
        }
    </script>

    <style>

    </style>
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
        <a class="dropdown-item" href="">Edytuj</a>
        <a class="dropdown-item" href="#">Usuń</a>
        <div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#">Usuń rezerwacje</a>
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
    </ul>

</div>

<div class="container" style="margin-top:30px">
    <div class="row">

        <div class="col-sm-8">
            <h2>TITLE HEADING</h2>
            <h5>Title description, Dec 7, 2017</h5>
            <div class="fakeimg">Fake Image</div>
            <p>Some text..</p>
            <label for="exampleInputHolidayName">Wyszukiwanie :</label>
            <div class="form-group">
                <input type="text" title="Wyszukiwanie powyżej 3 znaków." name="holiday-quick"
                       class="form-control form-control-user" pattern=".{3,}"
                       id="holiday-quick" placeholder="Wyszukiwanie powyżej 3 znaków." autocomplete="off">
                <div id="result-div" class="list-group"
                     style="margin-top:2px;position:absolute;margin-left:0;z-index: 1001 !important; ">
                </div>
            </div>
            <#if Error??>
            <h3>nie można znaleźć książki</h3>
            <#else>
                <form method="put" action="/update" enctype="multipart/form-data">
                    Id: <input type="number" name="id" value="${id !""}"/>
                    Author: <input type="text" name="author" value="${author !""}"/><br/><br/>
                    title : <input type="text" name="title" value="${title !""}"/><br/><br/>
                    typ literatury: <input type="text" name="kind" value="${kind !""}"/><br/><br/>
                    Rodzaj: <input type="text" name="genre" value="${genre !""}"/><br/><br/>
                    Epoka : <input type="text" name="epoch" value="${epoch !""}"/><br/><br/>
                    Cover: <input type="file" name="cover" value="${cover !""}"/><br/><br/>
                    <input type="submit" name="save" value="Save" onclick="bookEdit()"/><br/><br/>
                </form>     </#if>       <br>
                    </div>

        </div>
</div>
<script>
    $(function () {

        $(document).ready(function () {

            $.ajax({
                url: '/api/managemant',
                type: 'GET',
                success: function (result) {

                    for (var i = 0; i < result.length; i++) {
                        $("#team").append(
                            "<option value='" + result[i].id + "'>" + result[i].name + "</option>");
                    }

                    console.log(result);
                }
            });

            var urlParams = new URLSearchParams(window.location.search);
            var id = urlParams.get('id');

            if (id != null) {
                $.ajax({
                    url: '/api/users/' + id,
                    type: 'GET',
                    success: function (result) {

                        $("[name='name']").val(result.name);
                        $("[name='login']").val(result.login);
                        $("[name='age']").val(result.age);
                        $("[name='team']").val(result.teamView.id);
                        $("[name='save']").attr('type', 'button');
                        $("[name='save']").attr('value', 'edit');

                        $("[name='save']").click(function () {

                            $.fn.serializeObject = function () {
                                var o = {};
                                var a = this.serializeArray();
                                $.each(a, function () {
                                    if (o[this.name]) {
                                        if (!o[this.name].push) {
                                            o[this.name] = [o[this.name]];
                                        }
                                        o[this.name].push(this.value || '');
                                    } else {
                                        o[this.name] = this.value || '';
                                    }
                                });
                                return o;
                            };

                            $.ajax({
                                type: "PUT",
                                dataType: 'json',
                                contentType: 'application/json;charset=UTF-8',
                                url: '/api/users/' + id,
                                data: JSON.stringify($('form').serializeObject()),
                                success: function (data) {
                                    window.location.href='/users'
                                }
                            });

                        });
                    }
                });
            }
        });
    });
</script>

    </div>
<div class="jumbotron text-center" style="margin-bottom:0">
    <p>Footer</p>
</div>
<script src="../../../html/js/uisearch.js"></script>

</body>
</html>

