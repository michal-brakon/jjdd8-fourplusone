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
</head>
<body>
<div id="wrapper">
    <header>
        <div class="top">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <ul class="topleft-info">
                        </ul>
                    </div>
                    <div class="col-md-6">
                        <div id="sb-search" class="sb-search">
                            <form>
                                <input class="sb-search-input" placeholder="Czego szukasz?" type="text" value=""
                                       name="search" id="search">
                                <input class="sb-search-submit" type="submit" value="">
                                <span class="sb-icon-search" title="Click to start searching"></span>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="navbar navbar-default navbar-static-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.ftlh"><img src="../../html/img/logo.png" alt="" width="199"
                                                               height="52"/></a>
            </div>
            <div class="navbar-collapse collapse ">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="index.ftlh">Strona główna</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown"
                           data-delay="0" data-close-others="false">Biblioteka <i class="fa fa-angle-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="comingsoon.ftlh">Wyszukaj</a></li>
                            <li class="dropdown-submenu">
                                <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown">Katalog</a>
                                <ul class="dropdown-menu">
                                    <li><a href="comingsoon.ftlh">Książki</a></li>
                                    <li><a href="comingsoon.ftlh">AudioBooki</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li><a href="../../html/szablony/login.ftlh">Zaloguj/Rejestracja</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <img src="https://wolnelektury.pl/media/${book.cover!}" class="img-fluid" alt="Responsive image"
                     height="500" width="400">
            </div>
            <div class="col-lg-6, d-flex">
				<p class="text-left"><strong>Title:</strong> ${book.title}</p>
                    <p class="text-left"><strong>Autor:</strong> ${book.author!} </p>
                    <p class="text-left"><strong>Epoka:</strong> ${book.epoch!} </p>
                    <p class="text-left"><strong>Audio:</strong> ${book.audio?c!}</p>
                    <p class="text-left"><strong>Rodzaj:</strong> ${book.genre!}</p>
                    <p class="text-left"><strong>Typ literatury:</strong> ${book.kind!}</p>
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
                                <!--
                All the links in the footer should remain intact.
                You can delete the links only if you purchased the pro version.
                Licensing information: https://bootstrapmade.com/license/
                Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Sailor
              -->
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

<script src="../../html/js/jquery.min.js"></script>
<script src="../../html/js/modernizr.custom.js"></script>
<script src="../../html/js/jquery.easing.1.3.js"></script>
<script src="../../html/js/bootstrap.min.js"></script>
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
    