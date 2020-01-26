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
<#--    <script type="text/javascript">-->
<#--        let id;-->

<#--        function bookEdit() {-->

<#--            $.ajax({-->
<#--                url: '',-->
<#--                method: 'PUT',-->
<#--                data: {-->
<#--                    id: $('input[name=id]').val(),-->
<#--                    title: $('input[name=title]').val(),-->
<#--                    author: $('input[name=author]').val(),-->
<#--                    kind: $('input[name=kind]').val(),-->
<#--                    genre: $('input[name=genre]').val(),-->
<#--                    epoch: $('input[name=epoch]').val(),-->
<#--                    cover: $('input[name=cover]').val(),-->

<#--                }-->
<#--            })-->
<#--        }-->
<#--<script>-->



<#--        const $list = $(".user-list");-->

<#--        $("#test").on("click", function() {-->
<#--            const $btn = $(this);-->

<#--            //dodajemy klasę .loading do buttona, która doda mu ikonkę ładowania-->
<#--            //i wyłączamy go aby użytkownik nie mógł w niego ponownie kliknąć aż do zakończenia połączenia-->
<#--            $btn.addClass("loading");-->
<#--            $btn.prop("disabled", true);-->

<#--            $.ajax({-->
<#--                url : "/api/management/",-->
<#--                dataType : "json"-->
<#--            })-->
<#--                .done(function(res) {-->
<#--                    //czyścimy listę przed dodaniem użytkowników-->
<#--                    //inaczej ponowne kliknięcie duplikowało by użytkowników na liście-->
<#--                    $list.empty();-->

<#--                    //robimy pętlę po zwróconej tablicy-->
<#--                    //dołączając do listy kolejne LI z imieniem i emailem użytkownika-->
<#--                    res.forEach(function(el) {-->
<#--                        const $li = $('<li>${el.title}  : ${el.author}</li>');-->
<#--                        $list.append($li);-->
<#--                    })-->
<#--                })-->
<#--                .always(function() {-->
<#--                    //po zakończeniu wczytywania wyłączamy loading-->
<#--                    //i włączamy przycisk-->
<#--                    $btn.removeClass("loading");-->
<#--                    $btn.prop("disabled", false);-->
<#--                });-->
<#--        });-->
<#--    </script>-->

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
            <a class="dropdown-item" href="#" id="test">Lista</a>
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
    </ul>

</div>

<div class="container" style="margin-top:30px">
    <div class="row">

        <div class="col-sm-8">
            <h2>TITLE HEADING</h2>
            <h5>Title description, Dec 7, 2017</h5>
            <div class="fakeimg">Fake Image</div>
            <p>Some text..</p>
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
                </form>     </#if> <br>
        </div>

    </div>
</div>


    <div id="log" style="height: 200px; width: 300px; overflow: auto;" class="ui-widget-content"></div>

<#--    <script>-->
<#--        $(function () {-->

<#--            $(document).ready(function () {-->

<#--                $.ajax({-->
<#--                    url: '/api/managemant',-->
<#--                    type: 'GET',-->
<#--                    success: function (result) {-->

<#--                    for (var i = 0; i < result.length; i++) {-->
<#--                        $("#team").append(-->
<#--                            "<option value='" + result[i].id + "'>" + result[i].name + "</option>");-->
<#--                    }-->

<#--                    console.log(result);-->
<#--                }-->
<#--            });-->

<#--            var urlParams = new URLSearchParams(window.location.search);-->
<#--            var id = urlParams.get('id');-->

<#--            if (id != null) {-->
<#--                $.ajax({-->
<#--                    url: '/api/users/' + id,-->
<#--                    type: 'GET',-->
<#--                    success: function (result) {-->

<#--                        $("[name='name']").val(result.name);-->
<#--                        $("[name='login']").val(result.login);-->
<#--                        $("[name='age']").val(result.age);-->
<#--                        $("[name='team']").val(result.teamView.id);-->
<#--                        $("[name='save']").attr('type', 'button');-->
<#--                        $("[name='save']").attr('value', 'edit');-->

<#--                        $("[name='save']").click(function () {-->

<#--                            $.fn.serializeObject = function () {-->
<#--                                var o = {};-->
<#--                                var a = this.serializeArray();-->
<#--                                $.each(a, function () {-->
<#--                                    if (o[this.name]) {-->
<#--                                        if (!o[this.name].push) {-->
<#--                                            o[this.name] = [o[this.name]];-->
<#--                                        }-->
<#--                                        o[this.name].push(this.value || '');-->
<#--                                    } else {-->
<#--                                        o[this.name] = this.value || '';-->
<#--                                    }-->
<#--                                });-->
<#--                                return o;-->
<#--                            };-->

<#--                            $.ajax({-->
<#--                                type: "PUT",-->
<#--                                dataType: 'json',-->
<#--                                contentType: 'application/json;charset=UTF-8',-->
<#--                                url: '/api/users/' + id,-->
<#--                                data: JSON.stringify($('form').serializeObject()),-->
<#--                                success: function (data) {-->
<#--                                    window.location.href='/users'-->
<#--                                }-->
<#--                            });-->

<#--                        });-->
<#--                    }-->
<#--                });-->
<#--            }-->
<#--        });-->
<#--    });-->
<#--</script>-->

</div>
<div class="jumbotron text-center" style="margin-bottom:0">
    <ul class="user-list"></ul>
</div>
<script src="../../../html/js/uisearch.js"></script>

</body>
</html>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<#--<script>-->
<#--    $(function () {-->
<#--        function log(message) {-->
<#--            $("<div>").text(message).prependTo("#log");-->
<#--            $("#log").scrollTop(0);-->
<#--          source: function (request, response) {-->
<#--                $.ajax({-->
<#--                    type: "GET",-->
<#--                    url: "/api/search/" + request.term,-->
<#--                    success: function (data) {-->
<#--                        if (data.length === 0) {-->
<#--                            response(log("brak resultatów"))-->
<#--                        } else {-->
<#--                            for (var i = 0; i < data.length; i++) {-->
<#--                                $("#log").append(-->
<#--                                    "<input type='checkbox' name='applications' value='" + data[i].id + "'/> "-->
<#--                                    + data[i].title);-->
<#--                            }-->
<#--                            response(data.map(b => b.title))-->
<#--                            ;-->
<#--                        }-->
<#--                    }-->
<#--                });-->
<#--            },)-->
<#--            minLength: 3,-->
<#--            select: function (event, ui) {-->
<#--                log("Selected: " + ui.item.value + " aka " + ui.item.label);-->
<#--            }-->
<#--        });-->
<#--    });-->
<#--    // $(function() {-->
<#--    //     $("#result-div").hide();-->
<#--    // });-->
<#--    // $('#bookSearch').keyup(function (e) {-->
<#--    //     e.preventDefault(); // Prevent the form from submitting via the browser-->
<#--    //     $("#result-div").html("");-->
<#--    //     if($('#bookSearch').val().length >=3) {-->
<#--    //         $.ajax({-->
<#--    //             type: "GET",-->
<#--    //             url: "/api/search/" + $('#bookSearch').val(),-->
<#--    //             enctype: 'application/json; charset=UTF-8',-->
<#--    //             dataType: 'json',-->
<#--    //             contentType: 'application/json; charset=UTF-8'-->
<#--    //         })-->
<#--    //             .done(-->
<#--    //                 function (data) {-->
<#--    //                     $("#result-div").show();-->
<#--    //                     if (data.length==0){-->
<#--    //                         return;-->
<#--    //                     }-->
<#--    //                     $.each(data, function (i, item) {-->
<#--&lt;#&ndash;    //                         $("#result-div").append('<a href="/single?id='+item.id+'" class="list-group-item list-group-item-action list-group-item-primary">'+item.title+'</a>');&ndash;&gt;-->
<#--    //                     });-->
<#--    //                 })-->
<#--    //             .fail(-->
<#--    //                 function () {-->
<#--    //                     $("#result-div").show();-->
<#--    //                     $("#result-div").html("Fatal error!");-->
<#--    //                 });-->
<#--    //     }-->
<#--    // });-->

