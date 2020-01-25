<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <form method="post" action="/uploader" enctype="multipart/form-data">
        <title>Upload pliku JSON</title>
        <p></p>
        <header>Awaryjne ładowanie API z pliku</header>
        <input type="file" accept="application/JSON" name="api">
        <input type="submit" name="upload" value="Upload">
    </form>

</head>
<body>
<h2>JavaScript Confirm Box</h2>


<button onclick="myFunction()">Try it</button>

<p id="demo"></p>

<script>
    function myFunction() {
        var txt;
        if (confirm("Press a button ${name} !")) {
            txt = "You pressed OK! ";
        } else {
            txt = "You pressed Cancel!";
        }
        document.getElementById("demo").innerHTML = txt;
    }
    </script>
    $.ajax({
        type : "POST",
        cache: false,
        url : "localhost:8080",
    success: function myFunction()
    })


</body>
</html>