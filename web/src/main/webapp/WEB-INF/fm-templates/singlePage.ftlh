<!DOCTYPE html>
<html lang="pl">

<head>
    <meta charset="utf-8">
    <title>Four+One Library</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content="Bootstrap 3 template for corporate business"/>
    <link href="../../html/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="../../html/plugins/flexslider/flexslider.css" rel="stylesheet" media="screen"/>
    <link href="../../html/css/cubeportfolio.min.css" rel="stylesheet"/>
    <link href="../../html/css/style.css" rel="stylesheet"/>
    <link id="t-colors" href="../../html/skins/default.css" rel="stylesheet"/>
    <link id="bodybg" href="../../html/bodybg/bg1.css" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

</head>
<body>
<div id="wrapper">
    <#include "header-nav.ftlh">

    <div class="container">
        <div class="center-block">
            <div class="col-lg-4">
                <img src="${book.cover!}" class="img-fluid" alt="Okładka">
            </div>
            <div class="col-lg-8, text-left">
                <div class="text-center">
                    <h2 class="text-primary">Książka:</h2>
                    <h3 class="text-danger">${book.title}</h3>
                </div>
                <br>
                <h3>Autor: ${book.author} </h3>
                <h4>Epoka: ${book.epoch} </h4>
                <h4>Wersja audio: ${book.audio?then('Dostępna','Brak')}</h4>
                <h4>Rodzaj: ${book.genre}</h4>
                <h4>Typ literatury: ${book.kind}</h4>
            </div>
        </div>
    </div>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-sm-12 col-lg-12">
                    <div class="widget">
                        <h4>Kontakt</h4>
                        <address>
                            <strong>Four+One Library</strong><br>Olivia Busines Centre<br>Gdańsk
                        </address>
                        <p>
                            <i class="icon-phone"></i> (0048) 123-456-789 <br>
                            <i class="icon-envelope-alt"></i> fourplusone@library.com
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div id="sub-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="copyright">
                            <p>&copy; Sailor Theme - All Right Reserved</p>
                            <div class="credits">
                                Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>

<script src="../../html/js/modernizr.custom.js"></script>
<script src="../../html/js/jquery.easing.1.3.js"></script>
<script src="../../html/plugins/flexslider/jquery.flexslider-min.js"></script>
<script src="../../html/plugins/flexslider/flexslider.config.js"></script>
<script src="../../html/js/jquery.appear.js"></script>
<script src="../../html/js/stellar.js"></script>
<script src="../../html/js/classie.js"></script>
<script src="../../html/js/uisearch.js"></script>
<script src="../../html/js/jquery.cubeportfolio.min.js"></script>
<script src="../../html/js/google-code-prettify/prettify.js"></script>
<script src="../../html/js/animate.js"></script>
<script src="../../html/js/custom.js"></script>


</body>

</html>
    