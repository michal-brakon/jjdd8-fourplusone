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
       <script>$(function() {
            $("#result-div").hide();
        });
        function getModal(id){
            $.ajax({
                type: "GET",
                url: "/api/search/" + id,
                enctype: 'application/json; charset=UTF-8',
                dataType: 'json',
                //data: $('#holiday-name').val(),
                contentType: 'application/json; charset=UTF-8'
            })
                .done(
                    function (resp) {
                        $('#modal-info-body').html("Holiday name: "+resp.name +" on day "+ resp.date +"<br />"+resp.description);
                        $('#infoModal').modal('show');
                    })
                .fail(
                    function () {
                        $('#modal-info-body').html("Ups... Operation failed!!!");
                        $('#infoModal').modal('show');
                    });
        }
        $('#holiday-quick').keyup(function (e) {
            e.preventDefault(); // Prevent the form from submitting via the browser
            $("#result-div").html("");
            if($('#holiday-quick').val().length >=3) {
                $.ajax({
                    type: "GET",
                    url: "/api/search/" + $('#holiday-quick').val(),
                    enctype: 'application/json; charset=UTF-8',
                    dataType: 'json',
                    contentType: 'application/json; charset=UTF-8'
                })
                    .
                    done(
                        function (data) {
                            $("#result-div").show();
                            if (data.length==0){
                                $("#result-div").append('<a href="#" class="list-group-item list-group-item-action list-group-item-warning">No results found!</a>');
                                return;
                            }
                            $("#modalh1id").text("Quick Holiday info");
                            $.each(data, function (i, item) {
                                $("#result-div").append('<a href="#" onclick="getModal('+item.id+')" class="list-group-item list-group-item-action list-group-item-primary">'+item.title+'</a>');
                            });
                        })
                    .fail(
                        function () {
                            $("#result-div").show();
                            $("#result-div").html("Fatal error!");
                        });
            }
        });</script>
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
                    <label for="exampleInputHolidayName">Quick live search:</label>
                    <div class="form-group">
                        <input type="text" title="Please insert min 3 char." name="holiday-quick" class="form-control form-control-user" pattern=".{3,}"
                               id="holiday-quick" placeholder="Please enter a minimum of 3 letters..." autocomplete="off">
                        <div id="result-div" class="list-group" style="margin-top:2px;margin-left:0;z-index: 1000 !important;">
                        </div>
                    </div>
                    </div>
                </div>
            </div>

    </header>
    <header>
        <div class="navbar navbar-default navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/"><img src="../../html/img/logo.png" alt="" width="199" height="52"/></a>
                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="/">Strona główna</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown"
                               data-delay="0" data-close-others="false">Biblioteka <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="https://google.pl">Wyszukaj</a></li>
                                <li class="dropdown-submenu">
                                    <a href="#" class="dropdown-toggle " data-toggle="dropdown" data-hover="dropdown">Katalog</a>
                                    <ul class="dropdown-menu">
                                        <li><a href="/catalogue?bookNum=0">Książki</a></li>
                                        <li><a href="/soon">AudioBooki</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li><a href="/soon">Zaloguj/Rejestracja</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </header>

    <section id="featured" class="bg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div id="main-slider" class="main-slider flexslider">
                        <ul class="slides">
                            <li>
                                <img src="../../html/img/slides/flexslider/1.jpg" alt=""/>
                                <div class="flex-caption">
                                    <p> Dla tych co umieją czytać</p>
                                    <a href="/catalogue?bookNum=0" class="btn btn-theme">Książki</a>
                                </div>
                            </li>
                            <li>
                                <img src="../../html/img/slides/flexslider/2.jpg" alt=""/>
                                <div class="flex-caption">
                                    <p>Dla tych co wolą słuchać</p>
                                    <a href="/soon" class="btn btn-theme">AudioBooki</a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

    </section>
    <section class="callaction">
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="cta-text">
                        <h2>Biblioteka zespołu <span>Four+One</span></h2>
                        <p> powstała w ramach zajęć kursu w Infoshare Academy. W projekt zaangażowanych było pięć osób,
                            dla których praca nad
                            projektem była częścią kursu Junior Java Developer. Naszym celem jest propagowanie
                            czytelnictwa wśród internautów,
                            a wszytkie pozycje dostępne są dzięki serwisowi wolnelektury.pl </p>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="cta-btn">
                        <img src="../../html/img/zyj.jpg" alt="Czytaj książki - żyj dłuzej."/>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <section id="content">
        <div id="parallax1" class="parallax text-light text-center marginbot50" data-stellar-background-ratio="0.5">
            <div class="container">
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <div class="align-center color-white txt-shadow row appear stats">
                        <div class="icon">
                            <i class="fa fa-book fa-5x"></i>
                        </div>
                        <strong id="counter-coffee" class="number">5561</strong><br/>
                        <span class="text">Książki</span>
                    </div>
                </div>
                <div class="col-xs-6 col-sm-6 col-md-6">
                    <div class="align-center color-white txt-shadow row appear stats">">
                        <div class="icon">
                            <i class="fa fa-music fa-5x"></i>
                        </div>
                        <strong id="counter-music" class="number">855</strong><br/>
                        <span class="text">AudioBook</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="col-sm-12 col-md-12 row ">
                <div class="testimonialslide clearfix flexslider row">
                    <ul class="slides">
                        <li>
                            <blockquote>
                                Każda znajdująca się tu książka, każdy tom, posiadają własną duszę. I to
                                zarówno duszę tego, kto daną książkę napisał, jak i dusze tych, którzy tę
                                książkę przeczytali i tak mocno ją przeżyli, że zawładnęła ich wyobraźnią.
                            </blockquote>
                            <h5>Carlos Ruiz Zafón</h5>
                        </li>
                        <li>
                            <blockquote>
                                Czytanie dobrych książek jest niczym rozmowa z najwspanialszymi ludźmi
                                minionych czasów.
                            </blockquote>
                            <h5>Kartezjusz</h5>
                        </li>
                        <li>
                            <blockquote>
                                Kocham książkę dlatego, że wprowadza mnie w mój własny świat, że odkrywa we
                                mnie bogactwa, których nie przeczuwałem.
                            </blockquote>
                            <h5> Jarosław Iwaszkiewicz</h5>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <div class="container">
            <div class="col-sm-12 col-lg-12 row">
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
        <div id="sub-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <p>&copy; Sailor Theme - All Right Reserved</p>
                        <div class="credits">
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
