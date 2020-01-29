<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>jQuery UI Autocomplete - Remote JSONP datasource</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <style>
        .ui-autocomplete-loading {
            background: white right center no-repeat;
        }
    </style>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $(function () {
            function log(message) {
                $("<div>").text(message).prependTo("#log");
                $("#log").scrollTop(0);
            }
            $("#birds").keyup({
                source: function (request, response) {
                    $.ajax({
                        type: "GET",
                        url: "/api/search/"+request.term,
                        success: function (data) {
                            if(data.length===0){
                                response( log("brak resultatów"))
                            }   else {
                                $("#log").css(display,"block");
                                response(data.map(b => b.title))
                                ;}
                        }
                    });
                },
                minLength: 3,
                select: function (event, ui) {
                    log("Selected: " + ui.item.value + " aka " + ui.item.label);
                }
            });
        });
    </script>
</head>
<body>
<div class="ui-widget">
    <label for="birds">Birds: </label>
    <input id="birds" autocomplete="off" >
</div>
<div class="ui-widget" style="margin-top:2em; font-family:Arial">
    Result:
    <div id="log" style="height: 200px; width: 300px; overflow: auto; display: none;"></div>
</div>
</body>
</html>